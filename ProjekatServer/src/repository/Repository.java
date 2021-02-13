package repository;

import java.util.List;

/**
 * @param <T>
 */
public interface Repository<T> {

    List<T> getAll(T param) throws Exception;

    List<T> get(T param) throws Exception;

    List<T> returnThreeTables(T param) throws Exception;

    List<T> returnThreeTablesWithCondition(T param) throws Exception;

    List<T> returnTwoTables(T param) throws Exception;

    List<T> returnTwoTablesWithCondition(T param) throws Exception;

    List<T> returnFiveTablesWithCondition(T param) throws Exception;

    List<T> returnFiveTables(T param) throws Exception;

    List<T> returnSevenTables(T param) throws Exception;

    List<T> returnSevenTablesWithCondition(T param) throws Exception;

    List<T> returnEightTables(T param) throws Exception;

    List<T> returnEightTablesWithCondition(T param) throws Exception;

    void add(T param) throws Exception;

    void edit(T param) throws Exception;

    void delete(T param) throws Exception;

    List<T> getAll();
}
