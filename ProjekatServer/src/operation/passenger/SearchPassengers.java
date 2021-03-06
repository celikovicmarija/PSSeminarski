package operation.passenger;

import domain.GenericEntity;
import domain.Passenger;
import java.util.List;
import operation.AbstractGenericOperation;

public class SearchPassengers extends AbstractGenericOperation {

    private List<GenericEntity> list;

    public List<GenericEntity> getList() {
        return list;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.get((Passenger) param);
    }

}
