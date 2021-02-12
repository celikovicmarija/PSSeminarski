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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String returnJoinConditionIwo() {
        return "reservation.passengerID=passenger.passportNumber";
    }

    @Override
    public String returnJoinTableOne() {
        return "flight";
    }

    @Override
    public String returnJoinTableIwo() {
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

}
