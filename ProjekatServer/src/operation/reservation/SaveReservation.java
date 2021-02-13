
package operation.reservation;

import domain.Reservation;
import operation.AbstractGenericOperation;

public class SaveReservation extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if (param == null || !(param instanceof Reservation)) {
            throw new Exception("Invalid reservation data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.edit((Reservation) param);
    }
    
}
