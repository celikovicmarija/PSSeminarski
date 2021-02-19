package operation.reservation;

import domain.Reservation;
import operation.AbstractGenericOperation;

public class CreateReservation extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Reservation)) {
            throw new Exception("Invalid reservation data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Reservation) param);
    }

}
