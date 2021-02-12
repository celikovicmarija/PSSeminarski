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
public class Passenger implements GenericEntity {
    private String passportNumber;
    private String firstName;
    private String lastName;
    private String mlb;
    private String searchCriteria;
    
    public Passenger() {
    }

    public Passenger(String passportNumber, String firstName, String lastName, String mlb) {
        this.passportNumber = passportNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mlb = mlb;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMlb() {
        return mlb;
    }

    public void setMlb(String mlb) {
        this.mlb = mlb;
    }
     public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.passportNumber);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.mlb);
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
        final Passenger other = (Passenger) obj;
        if (!Objects.equals(this.passportNumber, other.passportNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Passenger{" + "passportNumber=" + passportNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", mlb=" + mlb + '}';
    }

    @Override
    public String getTableName() {
        return "passenger";
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
        List<GenericEntity> passengerList= new LinkedList<>();
       while (rs.next()){
           Passenger passenger=new Passenger(rs.getString("passportNumber"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("mlb"));
           passengerList.add(passenger);
       }
       return passengerList;
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

    @Override
    public String returnSearchCondition() {
       return " firstName LIKE " +"'%"+searchCriteria+"%'"+ " OR lastName LIKE "+"'%"+searchCriteria+"%'"+ " OR passportNumber LIKE "+"'%"+searchCriteria+"%'";
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
