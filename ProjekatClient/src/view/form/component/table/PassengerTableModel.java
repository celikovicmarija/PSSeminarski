package view.form.component.table;

import domain.Passenger;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PassengerTableModel extends AbstractTableModel {
    private final List<Passenger> passengers;
    private final String[] columnNames={"Passport No","First Name","Last Name","MLB"};

    public PassengerTableModel(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public int getRowCount() {
        if (passengers==null) return 0;
            return passengers.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Passenger passenger= passengers.get(rowIndex);
        switch(columnIndex){
            case 0: return passenger.getPassportNumber();
            case 1: return passenger.getFirstName();
            case 2: return passenger.getLastName();
            case 3: return passenger.getMlb();
            default: return "n/a";
        }
    }
        @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Passenger passenger= passengers.get(rowIndex);
            switch(columnIndex){
            case 0: passenger.setPassportNumber(String.valueOf(aValue)); break;
           /* case 1:  passenger.setFirstName();break;
            case 2:  passenger.setLastName();break;
            case 3:  passenger.setMlb();break;*/
          
        }
    }
        //TODO- DORADI OVO I I VIDI OVO POD KOMENTAROM
   /*   @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex==1) || (columnIndex==3);
        //if (columnIndex==1) return true;
        //return false;
    }*/
    
    
    
     public Passenger getPassengerAt(int row){
        return passengers.get(row);
    }
    
     public void addPassenger(Passenger passenger){
        passengers.add(passenger);
        fireTableRowsInserted(passengers.size()-1, passengers.size()-1);
 
    }
       public void clear() {
        passengers.removeAll(passengers);
        fireTableDataChanged();
    }
    public void addPassengers(List<Passenger> list) {
        list.forEach((a) -> {
            passengers.add(a);
        });
        
        fireTableDataChanged();
    }
    public List<Passenger>getPassengers(){
        return passengers;
    }   
    public void deletePassenger(Passenger passenger) {
        passengers.remove(passenger);
        fireTableDataChanged();
    }
           public void refresh( ) {
        fireTableDataChanged();
    }

    
}
