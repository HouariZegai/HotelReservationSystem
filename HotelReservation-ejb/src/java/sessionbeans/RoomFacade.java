package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Room;

@Stateless
public class RoomFacade extends AbstractFacade<Room> implements RoomFacadeLocal {

    @PersistenceContext(unitName = "HotelReservation-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoomFacade() {
        super(Room.class);
    }
    
}
