/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form.component.table;

import domain.Line;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marija
 */
public class LineTableModel extends AbstractTableModel {

    private final List<Line> lines;
    private final String[] columnNames = {"ID", "Name", "Flying from", "Flying to"};

    public LineTableModel(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public int getRowCount() {
        if (lines == null) {
            return 0;
        }
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
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
       Line line= lines.get(rowIndex);
        switch(columnIndex){
            case 0: return line.getLineID();
            case 1: return line.getLineName();
            case 2: return line.getAirportFrom().getAirportName();       
            case 3: return line.getAirportTo().getAirportName(); 
            
            default: return "n/a";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         Line line= lines.get(rowIndex);
          switch(columnIndex){
            case 0:  line.setId(Long.getLong((String.valueOf(aValue)))); break;
            case 1:  line.setLineName(String.valueOf(aValue)); break;
            /*case 2:  line.getAirportFrom().getAirportName();   break;     
            case 3: return line.getAirportTo().getAirportName();  break;
            */
           
        }
    }
        public Line getLineAt(int row){
        return lines.get(row);
    }
            public void clear() {
        lines.removeAll(lines);
        fireTableDataChanged();
    }
    public void addLines(List<Line> list) {
        for (Line a : list) {
            lines.add(a);
                    
        }
        
        fireTableDataChanged();
    }
    

}
