/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.passenger;

import domain.GenericEntity;
import domain.Passenger;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author Marija
 */
public class GetAllPassengers extends AbstractGenericOperation{
    
    private List<GenericEntity> list;

    public List<GenericEntity> getList() {
        return list;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list=repository.getAll((Passenger) param);
    }
    
}
