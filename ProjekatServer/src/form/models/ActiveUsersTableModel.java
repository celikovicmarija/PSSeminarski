package form.models;

import controller.Controller;
import domain.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ActiveUsersTableModel extends AbstractTableModel{
private final String[] columnNames= {"Frist name","LastName","Username","Status"};
private final List<User> korisnici;

    public ActiveUsersTableModel(List<User> korisnici) {
        this.korisnici = korisnici;
    }

    @Override
    public String getColumnName(int column) {
        if (column>columnNames.length) return "n/a";
        return columnNames[column]; 
    }
    @Override
    public int getRowCount() {
        if (korisnici==null) return 0;
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (korisnici.isEmpty()){
            return Object.class;
        }
         return getValueAt(0, columnIndex).getClass();

    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User k= korisnici.get(rowIndex);
        switch(columnIndex){
            case 0:
                return k.getFirstname();
            case 1:
                return k.getLastname();
                case 2:
                return k.getUsername();
            case 3: {
                boolean uListi=false;
                for(User korisnik: Controller.getInstance().getActiveUsers()){
                    if(k.getUsername().equals(korisnik.getUsername())){
                         uListi=true;
                        k.setStatus("active");
                    }
                }
                if(uListi==false) k.setStatus("not active");
                
                return  k.getStatus();
            }
                  default:
                return "n/a";
        }
    }
    
        @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        User korisnik = korisnici.get(rowIndex);
        switch(columnIndex){
            case 0:
                korisnik.setFirstname(String.valueOf(value));
                break;
            case 1: korisnik.setLastname(String.valueOf(value));break;
            case 2: korisnik.setUsername(String.valueOf(value));break;

            case 3:
                boolean uListi=false;
                for(User k: Controller.getInstance().getActiveUsers()){
                    if(k.getUsername().equals(korisnik.getUsername())){
                         uListi=true;
                        k.setStatus("active");
                    }
                }
                if(uListi==false) korisnik.setStatus("not active");

                break;
        }
    }
    
   public void addUser(User k){
        fireTableDataChanged();
    }
    
}
