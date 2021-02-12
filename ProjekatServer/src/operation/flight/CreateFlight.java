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
public class CreateFlight extends AbstractGenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
            if (param == null || !(param instanceof Flight)) {
            throw new Exception("Invalid flight data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Flight) param);
    }
    
}
