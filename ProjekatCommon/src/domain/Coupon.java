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
public class Coupon implements   GenericEntity{
    private Long couponID;

    private BigDecimal discountAmount;
    private String description;
    private Date validUntil;
    private String searchCriteria;


    public Coupon() {
    }

    public Coupon(Long couponID,BigDecimal discountAmount,
            String description, Date validUntil, BigDecimal discountedPrice) {
        this.couponID = couponID;
        this.discountAmount = discountAmount;
        this.description = description;
        this.validUntil = validUntil;
    }

    public Long getCouponID() {
        return couponID;
    }

    public void setCouponID(Long couponID) {
        this.couponID = couponID;
    }
      public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }


    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.couponID);
        hash = 59 * hash + Objects.hashCode(this.discountAmount);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.validUntil);
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
        final Coupon other = (Coupon) obj;
        if (!Objects.equals(this.couponID, other.couponID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "("+ couponID+") "+ description;
    }


    @Override
    public String getTableName() {
        return "coupon";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionOne() {
        return "coupon.reservationID=reservation.reservationID";
    }

    @Override
    public String returnJoinConditionTwo() {
        return "reservation.flightID=flight.flightID";
    }

    @Override
    public String returnJoinTableOne() {
        return "reservation";
    }

    @Override
    public String returnJoinTableTwo() {
        return "flight";
    }

    @Override
    public String returnSearchCondition() {
       // return "coupon.reservation=reservation.reservation";
        //dopuni
        //return "airportFrom LIKE "+"'%"+searchCriteriaSrc+"%'"+ "OR airportTo LIKE"+"'%"+searchCriteriaDest+"%'";{
        return " coupon.description LIKE " +"'%"+searchCriteria+"%' ";
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
    public List<GenericEntity> getList(ResultSet rs) throws SQLException {
       List<GenericEntity> coupons= new LinkedList<>();
       while (rs.next()){
           
           Coupon c=new Coupon();
           c.setCouponID(rs.getLong("coupon.couponID"));
           c.setDescription(rs.getString("coupon.description"));
           c.setDiscountAmount(rs.getBigDecimal("coupon.discountAmount"));
           c.setValidUntil(rs.getDate("coupon.validUntil"));
         
           /*Reservation r=new Reservation();
           r.setReservationID(rs.getLong("reservation.reservationID"));
           r.setIssueDate(rs.getDate("reservation.issueDate"));
           r.setValidUntil(rs.getDate("reservation.validUntil"));
           r.setPrice(rs.getBigDecimal("reservation.price"));
           r.setDiscountedPrice(rs.getBigDecimal("reservation.discountedPrice"));
 
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
            r.setPassenger(p);
            r.setFlight(f);
          
           
          c.setReservation(r);
      
           
           System.out.println(""+c.toString());*/
          coupons.add(c);
       }
       return coupons;
    
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
        return "passenger.passportNumber=reservation.passengerID";
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
        return "passenger";
    }



    
}
