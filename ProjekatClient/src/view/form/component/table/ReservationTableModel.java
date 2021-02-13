package view.form.component.table;

import domain.Reservation;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ReservationTableModel extends AbstractTableModel{
    private final List<Reservation> reservations;
    private final String[] columnNames={"ID","Price","Issue Date","Valid Until","Discounted Price","Flight", "Passenger","Coupon"};

    public ReservationTableModel(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    @Override
    public int getRowCount() {
     if (reservations==null) return 0;
        return reservations.size();
    }
        @Override
    public String getColumnName(int column) {
        if (column>columnNames.length) return "n/a";
        return columnNames[column]; 
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Reservation reservation= reservations.get(rowIndex);
        switch(columnIndex){
            case 0: return reservation.getReservationID();
            case 1: return reservation.getPrice();
            case 2: return reservation.getIssueDate();
            case 3: return reservation.getValidUntil();
            case 4: return reservation.getDiscountedPrice();
            case 5: return reservation.getFlight().getFlightID();
            case 6: return reservation.getPassenger().getPassportNumber();
            case 7: return reservation.getCoupon().getDescription();
            default: return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Reservation reservation= reservations.get(rowIndex);
        switch(columnIndex){
        /*    case 0:  reservation.setReservationID();break;
            case 1:  reservation.setPrice();break;
            case 2:  reservation.setIssueDate();break;
            case 3:  reservation.setValidUntil();break;
            case 4:  reservation.setDiscountedPrice();break;
            case 5:  reservation.setFlight();break;
            case 6:  reservation.setPassenger();break;*/
            //default: return "n/a";
        }
    }
        //TODO -VIDI OVO POD KOMENTAROM
   /*   @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex==1) || (columnIndex==3);
        //if (columnIndex==1) return true;
        //return false;
    }*/
     
      public Reservation getReservationAt(int row){
        return reservations.get(row);
    }
    
        public void addReservation(Reservation flight){
        reservations.add(flight);
        fireTableRowsInserted(reservations.size()-1, reservations.size()-1);
  
    }
        public void clear() {
        reservations.removeAll(reservations);
        fireTableDataChanged();
    }
    public void addReservations(List<Reservation> list) {
        for (Reservation a : list) {
            reservations.add(a);        
        }
        
        fireTableDataChanged();
    }
    public List<Reservation>getReservations(){
        return reservations;
    }   
    public void deleteFlight(Reservation reservation) {
        reservations.remove(reservation);
        fireTableDataChanged();
    }
       public void refresh( ) {
        fireTableDataChanged();
    }

    
}
