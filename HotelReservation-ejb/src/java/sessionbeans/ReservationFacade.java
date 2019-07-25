package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Reservation;

@Stateless
public class ReservationFacade extends AbstractFacade<Reservation> implements ReservationFacadeLocal {

    @PersistenceContext(unitName = "HotelReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationFacade() {
        super(Reservation.class);
    }
    
}
