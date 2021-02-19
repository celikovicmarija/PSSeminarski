/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import domain.GenericEntity;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;


public class RepositoryDBGeneric implements DbRepository<GenericEntity> {

    @Override
    public void add(GenericEntity entity) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(entity.getTableName())
                    .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(entity.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsKey = statement.getGeneratedKeys();
            if (rsKey.next()) {
                Long id = rsKey.getLong(1);
                entity.setId(id);
            }
            statement.close();
            rsKey.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName();
            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void edit(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "UPDATE " + param.getTableName() + " SET " + param.returnUpdateValues() + " WHERE " + param.returnUpdateCondition();
            System.out.println(query);
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            st.close();

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity param) throws Exception {

        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "DELETE FROM " + param.getTableName() + " WHERE " + param.getDeleteCondition();
            System.out.println(query);
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            st.close();

        } catch (SQLException ex) {
            throw ex;
        }

    }


    @Override
    public List<GenericEntity> get(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " WHERE " + param.returnSearchCondition();
            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            // st.close();
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> returnThreeTables(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo();
            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (Exception ex) {
            throw ex;
        }

    }

  
    @Override
    public List<GenericEntity> returnThreeTablesWithCondition(GenericEntity param) throws SQLException, Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo() + " WHERE " + param.returnSearchCondition();
            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }

    }

    @Override
    public List<GenericEntity> returnFiveTablesWithCondition(GenericEntity param) throws Exception {

        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo() + " JOIN "
                    + param.returnJoinTableThree() + " ON " + param.returnJoinConditionThree() + " JOIN "
                    + param.returnJoinTableFour() + " ON " + param.returnJoinConditionFour()
                    + " WHERE " + param.returnSearchCondition();
            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> returnFiveTables(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo() + " JOIN "
                    + param.returnJoinTableThree() + " ON " + param.returnJoinConditionThree() + " JOIN "
                    + param.returnJoinTableFour() + " ON " + param.returnJoinConditionFour();

            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> returnEightTables(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo() + " JOIN "
                    + param.returnJoinTableThree() + " ON " + param.returnJoinConditionThree() + " JOIN "
                    + param.returnJoinTableFour() + " ON " + param.returnJoinConditionFour() + " JOIN "
                    + param.returnJoinTableFive() + " ON " + param.returnJoinConditionFive() + " JOIN "
                    + param.returnJoinTableSix() + " ON " + param.returnJoinConditionSix() + " JOIN "
                    + param.returnJoinTableSeven() + " ON " + param.returnJoinConditionSeven();

            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> returnEightTablesWithCondition(GenericEntity param) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo() + " JOIN "
                    + param.returnJoinTableThree() + " ON " + param.returnJoinConditionThree() + " JOIN "
                    + param.returnJoinTableFour() + " ON " + param.returnJoinConditionFour() + " JOIN "
                    + param.returnJoinTableFive() + " ON " + param.returnJoinConditionFive() + " JOIN "
                    + param.returnJoinTableSix() + " ON " + param.returnJoinConditionSix() + " JOIN "
                    + param.returnJoinTableSeven() + " ON " + param.returnJoinConditionSeven() + " WHERE " + param.returnSearchCondition();

            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GenericEntity> select(GenericEntity param) throws Exception {
        
   
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo() + " JOIN "
                    + param.returnJoinTableThree() + " ON " + param.returnJoinConditionThree() + " JOIN "
                    + param.returnJoinTableFour() + " ON " + param.returnJoinConditionFour()
                    + " WHERE " + param.getSelectCondition();
            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> selectMoreComplex(GenericEntity param) throws Exception {
                try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " JOIN "
                    + param.returnJoinTableOne() + " ON " + param.returnJoinConditionOne() + " JOIN "
                    + param.returnJoinTableTwo() + " ON " + param.returnJoinConditionTwo() + " JOIN "
                    + param.returnJoinTableThree() + " ON " + param.returnJoinConditionThree() + " JOIN "
                    + param.returnJoinTableFour() + " ON " + param.returnJoinConditionFour() + " JOIN "
                    + param.returnJoinTableFive() + " ON " + param.returnJoinConditionFive() + " JOIN "
                    + param.returnJoinTableSix() + " ON " + param.returnJoinConditionSix() + " JOIN "
                    + param.returnJoinTableSeven() + " ON " + param.returnJoinConditionSeven() + " WHERE " + param.getSelectCondition();

            System.out.println(query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return param.getList(rs);

        } catch (SQLException ex) {
            throw ex;
        }
    }

   

   
}
