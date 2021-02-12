/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.component.table;

import domain.Flight;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marija
 */
public class FlightTableModel extends AbstractTableModel{
    private final List<Flight> flights;
    private final String[] columnNames={"flightID","Date","Time","Note","Airline","Line","Airplane"};

    public FlightTableModel(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public int getRowCount() {
         if (flights==null) return 0;
        return flights.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
      @Override
    public String getColumnName(int column) {
        if (column>columnNames.length) return "n/a";
        return columnNames[column]; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Flight flight= flights.get(rowIndex);
        switch(columnIndex){
            case 0: return flight.getFlightID();
            case 1: return flight.getDate();
            case 2: return flight.getTime();
            case 3: return flight.getNote();
            case 4: return flight.getAirline();
            case 5: return flight.getLine().getLineName();
            case 6: return flight.getAirplane().getAirplaneName();
            default: return "n/a";
        }
    }
    //TODO- DORADI OVO I I VIDI OVO POD KOMENTAROM
   /*   @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex==1) || (columnIndex==3);
        //if (columnIndex==1) return true;
        //return false;
    }*/

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Flight flight= flights.get(rowIndex);
        switch (columnIndex){
            case 3: 
                flight.setNote(String.valueOf(aValue));break;
        }
    }
    public Flight getFlightAt(int row){
        return flights.get(row);
    }
    public void addFlight(Flight flight){
        flights.add(flight);
        fireTableRowsInserted(flights.size()-1, flights.size()-1);
    }
    public void clear() {
        flights.removeAll(flights);
        fireTableDataChanged();
    }
    public void addFlights(List<Flight> list) {
        for (Flight a : list) {
            flights.add(a);        
        }
        
        fireTableDataChanged();
    }
    
}
