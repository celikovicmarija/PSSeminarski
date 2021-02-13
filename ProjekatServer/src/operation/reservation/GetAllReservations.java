package operation.reservation;

import domain.GenericEntity;
import domain.Reservation;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetAllReservations extends AbstractGenericOperation {

    private List<GenericEntity> list;

    public List<GenericEntity> getList() {
        return list;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.returnEightTables((Reservation) param);
    }

}
