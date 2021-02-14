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
public class Airplane  implements GenericEntity{
    private Long airplaneID;
    private String airplaneName;
    private airplaneType airplaneType;
    private String description;
    private int noPlacesEconomyClass;
    private int noPlacesBusinessClass;
    private String searchCriteria;

    public Airplane() {
    }

    public Airplane(Long airplaneID, String airplaneName, airplaneType airplaneType, 
            String description,int noPlacesEconomyClass, int noPlacesBusinessClass) {
        this.airplaneID = airplaneID;
        this.airplaneName = airplaneName;
        this.airplaneType = airplaneType;
        this.description = description;
        this.noPlacesEconomyClass = noPlacesEconomyClass;
        this.noPlacesBusinessClass = noPlacesBusinessClass;
    }
    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
    public Long getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(Long airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public airplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(airplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoPlacesEconomyClass() {
        return noPlacesEconomyClass;
    }

    public void setNoPlacesEconomyClass(int noPlacesEconomyClass) {
        this.noPlacesEconomyClass = noPlacesEconomyClass;
    }

    public int getNoPlacesBusinessClass() {
        return noPlacesBusinessClass;
    }

    public void setNoPlacesBusinessClass(int noPlacesBusinessClass) {
        this.noPlacesBusinessClass = noPlacesBusinessClass;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.airplaneID);
        hash = 29 * hash + Objects.hashCode(this.airplaneName);
        hash = 29 * hash + Objects.hashCode(this.airplaneType);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + this.noPlacesEconomyClass;
        hash = 29 * hash + this.noPlacesBusinessClass;
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
        final Airplane other = (Airplane) obj;

        if (!Objects.equals(this.airplaneID, other.airplaneID)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return airplaneName;
    }

    @Override
    public String getTableName() {
        return "airplane";
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
                List<GenericEntity> airplanes= new LinkedList<>();
       while (rs.next()){
           Airplane airplane=new Airplane(rs.getLong("airplaneID"), rs.getString("airplaneName"), airplaneType.valueOf(rs.getString("airplaneType")) , rs.getString("description"),rs.getInt("noPlacesEconomyClass"),rs.getInt("noPlacesBusinessClass"));
           airplanes.add(airplane);
       }
       return airplanes;
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionTwo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableTwo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//"airportFrom LIKE "+"'%"+searchCriteriaSrc+"%'"+ "OR airportTo LIKE"+"'%"+searchCriteriaDest+"%'";
    @Override
    public String returnSearchCondition() {
        return "airplaneName LIKE"+"'%"+searchCriteria+"%'";
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
