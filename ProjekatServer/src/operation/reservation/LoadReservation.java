/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.reservation;

import domain.GenericEntity;
import domain.Reservation;
import java.util.List;
import operation.AbstractGenericOperation;

public class LoadReservation extends AbstractGenericOperation{
    
    private List<GenericEntity> result;

    public List<GenericEntity> getResult() {
        return result;
    }
    
    
    @Override
    protected void preconditions(Object param) throws Exception {
    
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       result=repository.selectMoreComplex((Reservation) param);
    }
    
}
