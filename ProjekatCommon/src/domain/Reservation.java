/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marija
 */
public class Reservation implements GenericEntity {

    private Long reservationID;
    private BigDecimal price;
    private Date issueDate;
    private Date validUntil;
    private BigDecimal discountedPrice;
    private Flight flight;
    private Passenger passenger;
    private String searchCriteria;

    public Reservation() {
    }

    public Reservation(Long reservationID, BigDecimal price, Date issueDate, Date validUntil, BigDecimal discountedPrice, Flight flight, Passenger passenger) {
        this.reservationID = reservationID;
        this.price = price;
        this.issueDate = issueDate;
        this.validUntil = validUntil;
        this.discountedPrice = discountedPrice;
        this.flight = flight;
        this.passenger = passenger;
    }

    public Long getReservationID() {
        return reservationID;
    }

    public void setReservationID(Long reservationID) {
        this.reservationID = reservationID;
    }
      public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }



    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservationID=" + reservationID + ", price=" + price + ", issueDate=" + issueDate + ", validUntil=" + validUntil + ", discountedPrice=" + discountedPrice + ", flight=" + flight + ", passenger=" + passenger + '}';
    }

 

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (!Objects.equals(this.reservationID, other.reservationID)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "reservation";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,name,description,price,manufacturerid,measurementunit";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(reservationID).append(",")
                .append(price).append(",")
                .append("'").append(issueDate).append("',")
                .append("'").append(validUntil).append("',")
                .append(discountedPrice).append(",")
                .append(flight.getFlightID());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.reservationID=id;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws SQLException {
          List<GenericEntity> reservations= new LinkedList<>();
       while (rs.next()){
           Reservation reservation=new Reservation();
           reservation.setReservationID(rs.getLong("reservationID"));
           reservation.setIssueDate(rs.getDate("issueDate"));
           reservation.setValidUntil(rs.getDate("validUntil"));
           reservation.setPrice(rs.getBigDecimal("price"));
           reservation.setDiscountedPrice(rs.getBigDecimal("discountedPrice"));
 
           Passenger passenger=new Passenger();
           Flight flight=new Flight();
           
           passenger.setFirstName(rs.getString("passenger.firstName"));
           passenger.setLastName(rs.getString("passenger.lastName"));
           passenger.setPassportNumber(rs.getString("passenger.passportNumber"));
           passenger.setMlb(rs.getString("passenger.mlb"));
           
           flight.setFlightID(rs.getLong("flight.flightID"));
           flight.setNote(rs.getString("flight.getNote"));
           flight.setDate(rs.getDate("flight.date"));
           flight.setTime(rs.getTime("flight.time"));
           flight.setAirline(rs.getString("flight.airline"));
           
           
           Airplane airplane=new Airplane();
           airplane.setAirplaneID(rs.getLong("airplaneID"));
           airplane.setAirplaneName(rs.getString("airplaneName"));
           airplane.setAirplaneType(airplaneType.valueOf(rs.getString("airplaneType")));
           airplane.setDescription(rs.getString("description"));
           airplane.setNoPlacesBusinessClass(rs.getInt("noPlacesBusinessClass"));
           airplane.setNoPlacesEconomyClass(rs.getInt("noPlacesEconomyClass"));
           flight.setAirplane(airplane);
           
           
           Line line= new Line();
           flight.setLine(line);
           
           /*Airplane airplane=new Airplane();
           airplane.setAirplaneID(rs.getLong("airplaneID"));
           airplane.setAirplaneName(rs.getString("airplaneName"));
           airplane.setAirplaneType(airplaneType.valueOf(rs.getString("airplaneType")));
           airplane.setDescription(rs.getString("description"));
           airplane.setNoPlacesBusinessClass(rs.getInt("noPlacesBusinessClass"));
           airplane.setNoPlacesEconomyClass(rs.getInt("noPlacesEconomyClass"));
           flight.setAirplane(airplane);
           
           
           line.setLineID(rs.getLong("lineID"));
           line.setLineName(rs.getString("lineName"));
           
           Airport src= new Airport();
           Airport dest= new Airport();
           
         
          src.setAirportID(rs.getLong("a.airportID"));
          src.setAirportName(rs.getString("a.airportName"));
          src.setPlaceName(rs.getString("a.placeName"));
          src.setCountryName(rs.getString("a.countryName"));
          src.setAirportCode(rs.getString("a.airportCode"));
          line.setAirportFrom(src);
          
         dest.setAirportID(rs.getLong("b.airportID"));
          dest.setAirportName(rs.getString("b.airportName"));
          dest.setPlaceName(rs.getString("b.placeName"));
          dest.setCountryName(rs.getString("b.countryName"));
          dest.setAirportCode(rs.getString("b.airportCode"));
          line.setAirportTo(dest);
          flight.setLine(line);*/
           
       reservation.setPassenger(passenger);
       reservation.setFlight(flight);
          
          reservations.add(reservation);
       }
       return reservations;
    }

    @Override
    public String getDeleteCondition() {
        return "reservationID="+reservationID;
    }

    @Override
    public String returnJoinConditionOne() {
       return "reservation.flightID=flight.flightID";
    }

    @Override
    public String returnJoinConditionTwo() {
        return "reservation.passengerID=passenger.passportNumber";
    }

    @Override
    public String returnJoinTableOne() {
        return "flight";
    }

    @Override
    public String returnJoinTableTwo() {
        return "passenger";
    }

    @Override
    public String returnSearchCondition() {
        //dopuni
         return "reservationID="+searchCriteria; 
    }

    @Override
    public String returnUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnUpdateCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionThree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionFour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableThree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableFour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionFive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionSix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionSeven() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableFive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableSix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableSeven() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
