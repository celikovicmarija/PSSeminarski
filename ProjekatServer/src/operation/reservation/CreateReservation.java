/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation.reservation;

import domain.Reservation;
import operation.AbstractGenericOperation;

/**
 *
 * @author Marija
 */
public class CreateReservation extends AbstractGenericOperation {
//insert
    @Override
    protected void preconditions(Object param) throws Exception {
            if (param == null || !(param instanceof Reservation)) {
            throw new Exception("Invalid reservation data!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.add((Reservation) param);
    }
    
}
