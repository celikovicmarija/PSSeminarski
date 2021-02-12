/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.component.table;

import domain.Airport;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marija
 */
public class AirportTableModel extends AbstractTableModel{
    private final List<Airport> airports;
    private final String[] columnNames={"airportID","Name","Code","Country", "City"};

    public AirportTableModel(List<Airport> airports) {
        this.airports = airports;
    }


    @Override
    public int getRowCount() {
         if (airports==null) return 0;
        return airports.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
      @Override
    public String getColumnName(int column) {
        if (column>columnNames.length) return "n/a";
        return columnNames[column]; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Airport airport= airports.get(rowIndex);
        switch(columnIndex){
            case 0: return airport.getAirportID();
            case 1: return airport.getAirportName();
            case 2: return airport.getAirportCode();       
            case 3: return airport.getCountryName();
            case 4: return airport.getPlaceName();    
            
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
        Airport airport= airports.get(rowIndex);
        switch (columnIndex){
            case 1: 
                airport.setAirportName(String.valueOf(aValue));break;
        }
    }
    public Airport getAirportAt(int row){
        return airports.get(row);
    }
    public void addAirport(Airport airport){
        airports.add(airport);
        fireTableRowsInserted(airports.size()-1, airports.size()-1);
       
    }
    public void clear() {
        airports.removeAll(airports);
        fireTableDataChanged();
    }
    public void addAirports(List<Airport> list) {
        for (Airport a : list) {
            airports.add(a);
                    
        }
        
        fireTableDataChanged();
    }
    
}
