package sessionbeans;

import java.util.List;
import javax.ejb.Local;
import models.Room;

@Local
public interface RoomFacadeLocal {

    void create(Room room);

    void edit(Room room);

    void remove(Room room);

    Room find(Object id);

    List<Room> findAll();

    List<Room> findRange(int[] range);

    int count();
    
}
