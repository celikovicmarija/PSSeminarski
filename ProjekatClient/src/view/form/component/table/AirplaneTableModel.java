package view.form.component.table;

import domain.Airplane;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AirplaneTableModel extends AbstractTableModel {

    private final List<Airplane> airplanes;
    private final String[] columnNames = {"ID", "Name", "Type", "Description", "NoPEC", "NoPBC"};

    public AirplaneTableModel(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    @Override
    public int getRowCount() {
        if (airplanes == null) {
            return 0;
        }
        return airplanes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Airplane airplane = airplanes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return airplane.getAirplaneID();
            case 1:
                return airplane.getAirplaneName();
            case 2:
                return airplane.getAirplaneType();
            case 3:
                return airplane.getDescription();
            case 4:
                return airplane.getNoPlacesEconomyClass();
            case 5:
                return airplane.getNoPlacesBusinessClass();

            default:
                return "n/a";
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
        Airplane airplane = airplanes.get(rowIndex);
        switch (columnIndex) {
            case 2:
                airplane.setAirplaneName(String.valueOf(aValue));
                break;
        }
    }

    public Airplane getAirplaneAt(int row) {
        return airplanes.get(row);
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
        fireTableRowsInserted(airplanes.size() - 1, airplanes.size() - 1);
    }

    public void clear() {
        airplanes.removeAll(airplanes);
        fireTableDataChanged();
    }

    public void addAirplanes(List<Airplane> list) {
        for (Airplane a : list) {
            airplanes.add(a);

        }

        fireTableDataChanged();
    }

}
