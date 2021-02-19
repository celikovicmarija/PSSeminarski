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

    @Override
    public String getSelectCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
