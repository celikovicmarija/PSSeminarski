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
public class Coupon implements   GenericEntity{
    private Long couponID;
    private Reservation reservationID;
    private BigDecimal discountAmount;
    private String description;
    private Date validUntil;
    private BigDecimal discountedPrice;
    private String searchCriteria;


    public Coupon() {
    }

    public Coupon(Long couponID, Reservation reservationID, BigDecimal discountAmount, String description, Date validUntil, BigDecimal discountedPrice) {
        this.couponID = couponID;
        this.reservationID = reservationID;
        this.discountAmount = discountAmount;
        this.description = description;
        this.validUntil = validUntil;
        this.discountedPrice = discountedPrice;
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

    public Reservation getReservationID() {
        return reservationID;
    }

    public void setReservationID(Reservation reservationID) {
        this.reservationID = reservationID;
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

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.couponID);
        hash = 59 * hash + Objects.hashCode(this.reservationID);
        hash = 59 * hash + Objects.hashCode(this.discountAmount);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.validUntil);
        hash = 59 * hash + Objects.hashCode(this.discountedPrice);
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
        if (!Objects.equals(this.reservationID, other.reservationID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coupon{" + "couponID=" + couponID + ", reservationID=" + reservationID + ", discountAmount=" + discountAmount + ", description=" + description + ", validUntil=" + validUntil + ", discountedPrice=" + discountedPrice + '}';
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
        return "coupon.flightID=flight.flightID";
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
        //dopuni
        //return "airportFrom LIKE "+"'%"+searchCriteriaSrc+"%'"+ "OR airportTo LIKE"+"'%"+searchCriteriaDest+"%'";{
        return "description LIKE" +"'%"+searchCriteria+"%'";
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
