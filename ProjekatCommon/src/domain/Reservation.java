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

public class Reservation implements GenericEntity {

    private Long reservationID;
    private BigDecimal price;
    private Date issueDate;
    private Date validUntil;
    private BigDecimal discountedPrice;
    private Flight flight;
    private Passenger passenger;
    private Coupon coupon;
    private String searchCriteria;

    public Reservation() {
    }

    public Reservation(Long reservationID,Coupon coupon,
            BigDecimal price, Date issueDate, Date validUntil,
            BigDecimal discountedPrice, Flight flight, Passenger passenger) {
        this.reservationID = reservationID;
        this.price = price;
        this.issueDate = issueDate;
        this.validUntil = validUntil;
        this.discountedPrice = discountedPrice;
        this.flight = flight;
        this.passenger = passenger;
        this.coupon=coupon;
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
        return "(" + reservationID + "), price=" + price + ", issueDate=" + issueDate + ", validUntil=" + validUntil + ", discountedPrice=" + discountedPrice + ", flight=" + flight + ", passenger=" + passenger + '}';
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
        return "price,discountedPrice,issueDate,validUntil,flightID,passengerID,couponID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
                sb.append(price).append(",")
                .append(discountedPrice).append(",")
                .append("'").append(issueDate).append("',")
                .append("'").append(validUntil).append("',")
                .append(flight.getFlightID()).append(",'")
                .append(passenger.getPassportNumber()).append("',")
                 .append(coupon.getCouponID());
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
           reservation.setReservationID(rs.getLong("reservation.reservationID"));
           reservation.setIssueDate(rs.getDate("reservation.issueDate"));
           reservation.setValidUntil(rs.getDate("reservation.validUntil"));
           reservation.setPrice(rs.getBigDecimal("reservation.price"));
           reservation.setDiscountedPrice(rs.getBigDecimal("reservation.discountedPrice"));
 
           Passenger p=new Passenger();
           Flight f=new Flight();
           
           p.setFirstName(rs.getString("passenger.firstName"));
           p.setLastName(rs.getString("passenger.lastName"));
           p.setPassportNumber(rs.getString("passenger.passportNumber"));
           p.setMlb(rs.getString("passenger.mlb"));
           
           f.setFlightID(rs.getLong("flight.flightID"));
           f.setNote(rs.getString("flight.note"));
           f.setDate(rs.getDate("flight.date"));
           f.setTime(rs.getTime("flight.time"));
           f.setAirline(rs.getString("flight.airline"));
           
           
           Airplane a=new Airplane();
           a.setAirplaneID(rs.getLong("airplane.airplaneID"));
           a.setAirplaneName(rs.getString("airplane.airplaneName"));
           a.setAirplaneType(airplaneType.valueOf(rs.getString("airplane.airplaneType")));
           a.setDescription(rs.getString("airplane.description"));
           a.setNoPlacesBusinessClass(rs.getInt("airplane.noPlacesBusinessClass"));
           a.setNoPlacesEconomyClass(rs.getInt("airplane.noPlacesEconomyClass"));
           f.setAirplane(a);
           
           
           Line line= new Line();
            
           line.setLineID(rs.getLong("line.lineID"));
           line.setLineName(rs.getString("line.lineName"));
           
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
           
           f.setLine(line);
           
           Coupon c=new Coupon();
           c.setCouponID(rs.getLong("coupon.couponID"));
           c.setDescription(rs.getString("coupon.description"));
           c.setDiscountAmount(rs.getBigDecimal("coupon.discountAmount"));
           c.setValidUntil(rs.getDate("coupon.validUntil"));
       
      
           
       reservation.setPassenger(p);
       reservation.setFlight(f);
       reservation.setCoupon(c);
          
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
        if (allDigits(searchCriteria)){
             return "reservation.couponID="+searchCriteria+" OR reservation.reservationID="+searchCriteria+" OR reservation.flightID="+searchCriteria+" OR reservation.passengerID LIKE '%"+searchCriteria+"%'";
        }else{
           return   "coupon.description LIKE '%"+searchCriteria+"%' OR passenger.firstName LIKE '%"+searchCriteria+"%' OR passenger.lastName LIKE '%"+searchCriteria+"%'"; 
 
        }
    }

    @Override
    public String returnUpdateValues() {
        return " reservation.couponID="+String.valueOf(coupon.getCouponID())+", reservation.reservationID="+reservationID+", reservation.price= "+String.valueOf(price)+", reservation.discountedPrice="+String.valueOf(price)+", reservation.validUntil='"+String.valueOf(validUntil)+"', reservation.issueDate='"+String.valueOf(issueDate)+"', reservation.passengerID='"+passenger.getPassportNumber()+"', reservation.flightID="+flight.getFlightID();
    }

    @Override
    public String returnUpdateCondition() {
        return "reservation.reservationID="+reservationID;
    }

    @Override
    public String returnJoinConditionThree() {
        return "flight.lineID=line.lineID";
    }

    @Override
    public String returnJoinConditionFour() {
        return "flight.airplaneID=airplane.airplaneID";
    }

    @Override
    public String returnJoinTableThree() {
        return "line";
    }

    @Override
    public String returnJoinTableFour() {
        return "airplane";
    }

    @Override
    public String returnJoinConditionFive() {
        return "line.airportFrom=a.airportID";
    }

    @Override
    public String returnJoinConditionSix() {
        return "line.airportTo=b.airportID";
    }

    @Override
    public String returnJoinConditionSeven() {
        return "coupon.couponID=reservation.couponID";
    }

    @Override
    public String returnJoinTableFive() {
        return "airport a";
    }

    @Override
    public String returnJoinTableSix() {
        return "airport b";
    }

    @Override
    public String returnJoinTableSeven() {
        return "coupon";
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
         boolean allDigits(String s) {
      if (s == null)
      {
         return false;
      }
      int len = s.length();
      for (int i = 0; i < len; i++) {

         if ((Character.isDigit(s.charAt(i)) == false)) {
            return false;
         }
      }
      return true;
   }
}
