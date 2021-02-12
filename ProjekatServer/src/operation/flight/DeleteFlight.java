/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.flight;


import domain.Flight;
import operation.AbstractGenericOperation;

/**
 *
 * @author Marija
 */
public class DeleteFlight extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
    
    //TODO- Implement this
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       repository.delete((Flight) param);
     }
    
}
