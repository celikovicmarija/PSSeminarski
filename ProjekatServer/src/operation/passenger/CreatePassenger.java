package operation.passenger;

import domain.Passenger;
import operation.AbstractGenericOperation;

public class CreatePassenger extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Passenger)) {
            throw new Exception("Invalid passenger data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Passenger) param);
    }

}
