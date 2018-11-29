package repository;

import entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomRepo {
    List<Room> all();

    Room byName(String name) throws SQLException;

    void save(Room room);

}
