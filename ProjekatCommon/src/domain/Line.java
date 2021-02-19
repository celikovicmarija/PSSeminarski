/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marija
 */
public class Line implements GenericEntity{
    private Long lineID;
    private String lineName;
    private Airport airportFrom;
    private Airport airportTo;
    private String searchCriteriaSrc;
    private String searchCriteriaDest;


    public Line() {
    }

    public Line(Long lineID, String lineName, Airport airportFrom, Airport airportTo) {
        this.lineID = lineID;
        this.lineName = lineName;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
    }

    public Long getLineID() {
        return lineID;
    }

    public void setLineID(Long lineID) {
        this.lineID = lineID;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Airport getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
    }

    public Airport getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.lineID);
        hash = 59 * hash + Objects.hashCode(this.lineName);
        hash = 59 * hash + Objects.hashCode(this.airportFrom);
        hash = 59 * hash + Objects.hashCode(this.airportTo);
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
        final Line other = (Line) obj;
        if (!Objects.equals(this.lineID, other.lineID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return lineName;
    }

    @Override
    public String getTableName() {
        return "line";
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
    public List<GenericEntity> getList(ResultSet rs) throws SQLException {
       List<GenericEntity> lines= new LinkedList<>();
       while (rs.next()){
           Line line=new Line();
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
           
       
          
          lines.add(line);
       }
       return lines;
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionOne() {
        return "airportFrom=a.airportID";
    }

    @Override
    public String returnJoinConditionTwo() {
        return "airportTo=b.airportID";
    }

    @Override
    public String returnJoinTableOne() {
        return "airport a";
    }

    @Override
    public String returnJoinTableTwo() {
         return "airport b";
    }

    @Override
    public String returnSearchCondition() {
        return "a.placeName LIKE "+"'%"+searchCriteriaSrc+"%'"+
                " OR a.placeName LIKE "+"'%"+searchCriteriaDest+"%'"+
                " OR b.placeName LIKE "+"'%"+searchCriteriaDest+"%'"  +  
                " OR b.countryName LIKE "+"'%"+searchCriteriaSrc+"%'"+
                " OR a.countryName LIKE "+"'%"+searchCriteriaDest+"%'"+
                " OR b.placeName LIKE "+"'%"+searchCriteriaDest+"%'";
    }

    @Override
    public String returnUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnUpdateCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSearchCriteriaSrc() {
        return searchCriteriaSrc;
    }

    public void setSearchCriteriaSrc(String searchCriteriaSrc) {
        this.searchCriteriaSrc = searchCriteriaSrc;
    }

    public String getSearchCriteriaDest() {
        return searchCriteriaDest;
    }

    public void setSearchCriteriaDest(String searchCriteriaDest) {
        this.searchCriteriaDest = searchCriteriaDest;
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
