package repository;

import entity.Room;

import java.util.List;

public interface RoomRepo {
    List<Room> all();

    Room byName(String name);

    void save(Room room);

}
