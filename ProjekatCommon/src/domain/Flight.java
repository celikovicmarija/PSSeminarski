/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marija
 */
public class Flight implements GenericEntity {
    private Long flightID;
    private Date date;
    private Time time;
    private String note;
    private String airline;
    private Line line;
    private Airplane airplane;
    private String searchCriteria;

    public Flight() {
    }

    public Flight(Long flightID, Date date, Time time,
            String note, String airline, Line line, Airplane airplane) {
        this.flightID = flightID;
        this.date = date;
        this.time = time;
        this.note = note;
        this.airline = airline;
        this.line = line;
        this.airplane = airplane;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }
      public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.flightID);
        hash = 67 * hash + Objects.hashCode(this.date);
        hash = 67 * hash + Objects.hashCode(this.time);
        hash = 67 * hash + Objects.hashCode(this.note);
        hash = 67 * hash + Objects.hashCode(this.airline);
        hash = 67 * hash + Objects.hashCode(this.line);
        hash = 67 * hash + Objects.hashCode(this.airplane);
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
        final Flight other = (Flight) obj;
        if (!Objects.equals(this.flightID, other.flightID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return flightID +" ("+ airline + ")";
    }

    @Override
    public String getTableName() {
        return "flight";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "flightID,date,time,note,airline,lineID,airplaneID";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(flightID).append(",")
                .append("'").append(date).append("',")
                .append("'").append(time).append("',")
                .append("'").append(note).append("',")
                .append("'").append(airline).append("',")
                .append(line.getLineID()).append(",")
                .append(airplane.getAirplaneID());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.flightID=id;
    }

    @Override
    public List<GenericEntity> getList(ResultSet rs) throws SQLException {
        List<GenericEntity> flights= new LinkedList<>();
       while (rs.next()){
           Flight flight=new Flight();
           flight.setFlightID(rs.getLong("flightID"));
           flight.setDate(rs.getDate("date"));
           flight.setTime(rs.getTime("time"));
           flight.setNote(rs.getString("note"));
           flight.setAirline(rs.getString("airline"));
           Line line=new Line();
           Airplane airplane=new Airplane();
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
          flight.setLine(line);
           
       
          
          flights.add(flight);
       }
       return flights;
    }

    @Override
    public String getDeleteCondition() {
        return "flightID =" + flightID ;
    }

    @Override
    public String returnJoinConditionOne() {
       return "flight.lineID=line.lineID";
    }

    @Override
    public String returnJoinConditionTwo() {
        return "flight.airplaneID=airplane.airplaneID";

    }

    @Override
    public String returnJoinTableOne() {
        return "line";
    }

    @Override
    public String returnJoinTableTwo() {
        return "airplane";
    }

    @Override
    public String returnSearchCondition()  {    
        return "flight.airline LIKE "+"'%"+searchCriteria+"%'"+" OR a.placeName LIKE "+"'%"+searchCriteria+"%'"+ " OR b.placeName LIKE "+"'%"+searchCriteria+"%'"+
                " OR a.countryName LIKE "+"'%"+searchCriteria+"%'"+" OR b.countryName LIKE "+"'%"+searchCriteria+"%'";
    }

    @Override
    public String returnUpdateValues() {
        return "flightID= "+flightID+", date='"+String.valueOf(date)+"', time='"+String.valueOf(time)+"',airline='"+airline+"',airplaneID="+String.valueOf(airplane.getAirplaneID())+",lineID="+String.valueOf(line.getLineID())+",note= '"+note+"'";
    }

    @Override
    public String returnUpdateCondition() {
        return "flightID="+flightID;
    }

    @Override
    public String returnJoinConditionThree() {
        return "line.airportFrom=a.airportID";
    }

    @Override
    public String returnJoinConditionFour() {
        return "line.airportTo=b.airportID";
    }

    @Override
    public String returnJoinTableThree() {
        return "airport a";
    }

    @Override
    public String returnJoinTableFour() {
        return "airport b";
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
