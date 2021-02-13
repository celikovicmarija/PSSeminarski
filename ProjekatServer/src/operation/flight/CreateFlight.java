package operation.flight;

import domain.Flight;
import operation.AbstractGenericOperation;

public class CreateFlight extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Flight)) {
            throw new Exception("Invalid flight data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Flight) param);
    }

}
