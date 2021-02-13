package operation.airplane;

import domain.Airplane;
import domain.GenericEntity;
import java.util.List;
import operation.AbstractGenericOperation;

public class SearchAirplanes extends AbstractGenericOperation {

    private List<GenericEntity> list;

    public List<GenericEntity> getList() {
        return list;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.get((Airplane) param);
    }

}
