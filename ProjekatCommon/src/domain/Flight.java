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
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marija
 */
public class Flight implements GenericEntity {
    private Long flightID;
    private Date date;
    private Time time;//OBAVEZNO PREGLEDAJ
    private String note;
    private String airline;
    private Line line;
    private Airplane airplane;
    private String searchCriteria;

    public Flight() {
    }

    public Flight(Long flightID, Date date, Time time, String note, String airline, Line line, Airplane airplane) {
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
        return "Flight{" + "flightID=" + flightID + ", date=" + date + ", time=" + time + ", note=" + note + ", airline=" + airline + ", line=" + line + ", airplane=" + airplane + '}';
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String returnJoinConditionIwo() {
        return "flight.airplaneID=airplane.airplaneID";

    }

    @Override
    public String returnJoinTableOne() {
        return "line";
    }

    @Override
    public String returnJoinTableIwo() {
        return "airplane";
    }

    @Override
    public String returnSearchCondition()  {    
     //return "airportFrom LIKE "+"'%"+searchCriteriaSrc+"%'"+ "OR airportTo LIKE"+"'%"+searchCriteriaDest+"%'";
     //DOPUNI
        return "airline LIKE "+"'%"+searchCriteria+"%'";
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
