/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.component.table;

import domain.Reservation;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marija
 */
public class ReservationTableModel extends AbstractTableModel{
    private final List<Reservation> reservations;
    private final String[] columnNames={"ID","Price","Issue Date","Valid Until","Discounted Price","Flight", "Passenger"};

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
        return 7;
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
        /*
        
    public void addInvoiceItem(Product product, BigDecimal quantity, BigDecimal price) {
        InvoiceItem item = new InvoiceItem();
        item.setInvoice(invoice);
        item.setOrderNumber(invoice.getItems().size() + 1);
        item.setProduct(product);
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setMeasurementUnit(product.getMeasurementUnit());
        item.setAmount(item.getPrice().multiply(item.getQuantity()));
        invoice.getItems().add(item);
        invoice.setAmount(invoice.getAmount().add(item.getPrice().multiply(item.getQuantity())));
        fireTableRowsInserted(invoice.getItems().size() - 1, invoice.getItems().size() - 1);
    }

    public void removeInvoiceItem(int rowIndex) {
        InvoiceItem item = invoice.getItems().get(rowIndex);
        invoice.getItems().remove(rowIndex);
        invoice.setAmount(invoice.getAmount().subtract(item.getPrice().multiply(item.getQuantity())));
        setOrderNumbers();
        fireTableRowsDeleted(invoice.getItems().size() - 1, invoice.getItems().size() - 1);
    }

    private void setOrderNumbers() {
        int orderNo = 0;
        for (InvoiceItem item : invoice.getItems()) {
            item.setOrderNumber(++orderNo);
        }
    }
        
        
        
        */
    
}
