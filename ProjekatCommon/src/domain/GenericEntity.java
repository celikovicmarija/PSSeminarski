/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Milos Milic
 */
public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    void setId(Long id);
    
    public List<GenericEntity> getList(ResultSet rs) throws SQLException;

    public String getDeleteCondition();
    public String returnJoinConditionOne();
    public String returnJoinConditionIwo();
    public String returnJoinTableOne();
    public String returnJoinTableIwo();

    public String returnSearchCondition();
    
    public String returnUpdateValues();
    public String returnUpdateCondition();

    
    
    

}
