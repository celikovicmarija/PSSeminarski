package repository;

import java.util.List;

/**
 *
 * @author laptop-02
 * @param <T>
 */
public interface Repository<T> {
    List<T> getAll(T param) throws Exception;
    List<T> get(T param) throws Exception;
    List<T> returnThreeTables(T param) throws Exception;
    List<T> returnThreeTablesWithCondition(T param) throws Exception;

    List<T> returnTwoTables(T param) throws Exception;
     List<T> returnTwoTablesWithCondition(T param) throws Exception;

    void add(T param) throws Exception;
    void edit(T param) throws Exception;
    void delete(T param)throws Exception;
    List<T> getAll();
}
