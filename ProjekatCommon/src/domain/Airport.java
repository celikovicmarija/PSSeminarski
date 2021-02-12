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


public class Airport  implements GenericEntity{

    private Long airportID;
    private String airportName;
    private String airportCode;
    private String countryName;
    private String placeName;
    private String searchCriteria;

    public Airport() {
    }

    public Airport(Long airportID, String airportName, String placeName, String countryName, String airportCode) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.placeName = placeName;
        this.countryName=countryName;
        this.airportCode=airportCode;
    }
      public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public String toString() {
        return "Airport{" + "airportID=" + airportID + ", airportName=" + airportName + ", placeName=" + placeName + ", countryName=" + countryName + ", airportCode=" + airportCode + '}';
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.airportID);
        hash = 97 * hash + Objects.hashCode(this.airportName);
        hash = 97 * hash + Objects.hashCode(this.placeName);
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
        final Airport other = (Airport) obj;
        if (!Objects.equals(this.airportID, other.airportID)) {
            return false;
        }
        return true;
    }

     
    @Override
    public String getTableName() {
        return "airport";
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

    public Long getAirportID() {
        return airportID;
    }

    public void setAirportID(Long airportID) {
        this.airportID = airportID;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws SQLException {
                List<GenericEntity> airports= new LinkedList<>();
       while (rs.next()){
           Airport airport=new Airport(rs.getLong("airportID"), rs.getString("airportName"), rs.getString("placeName"), rs.getString("countryName"),rs.getString("airportCode"));
           airports.add(airport);
       }
       return airports;
    }
    
        /*
    
        @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaAutora = new LinkedList<>();
        while(rs.next()){
          Autor autor = new Autor(rs.getInt("autorID"), rs.getString("ime"), rs.getString("prezime"), rs.getDate("datumRodjenja"));
          listaAutora.add(autor);
        }
        return listaAutora;
    }

    
    */

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinConditionIwo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableOne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnJoinTableIwo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String returnSearchCondition() {
         return "airportName LIKE"+"'%"+searchCriteria+"%' OR "+"placeName LIKE"+"'%"+searchCriteria+"%'";
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
