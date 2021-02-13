package operation.line;

import domain.GenericEntity;
import domain.Line;
import java.util.List;
import operation.AbstractGenericOperation;

public class GetAllLines extends AbstractGenericOperation {

    private List<GenericEntity> list;

    public List<GenericEntity> getList() {
        return list;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.returnThreeTables((Line) param);
    }

}
