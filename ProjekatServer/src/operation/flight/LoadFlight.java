package operation.flight;

import domain.Flight;
import operation.AbstractGenericOperation;

public class LoadFlight extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.get((Flight) param);
    }

}
