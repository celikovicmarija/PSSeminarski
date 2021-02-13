package operation.airport;

import domain.Airport;
import domain.GenericEntity;
import java.util.List;
import operation.AbstractGenericOperation;

public class SearchAirports extends AbstractGenericOperation {

    private List<GenericEntity> list;

    public List<GenericEntity> getList() {
        return list;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.get((Airport) param);
    }

}
