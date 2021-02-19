package operation.flight;

import domain.Flight;
import domain.GenericEntity;
import java.util.List;
import operation.AbstractGenericOperation;

public class LoadFlight extends AbstractGenericOperation {

    private List<GenericEntity> result;

    public List<GenericEntity> getResult() {
        return result;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        result=repository.select((Flight) param);
    }

}
