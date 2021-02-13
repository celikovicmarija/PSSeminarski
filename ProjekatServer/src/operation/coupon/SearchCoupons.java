package operation.coupon;

import domain.Coupon;
import domain.GenericEntity;
import java.util.List;
import operation.AbstractGenericOperation;

public class SearchCoupons extends AbstractGenericOperation {

    private List<GenericEntity> list;

    public List<GenericEntity> getList() {
        return list;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.returnThreeTables((Coupon) param);
    }

}
