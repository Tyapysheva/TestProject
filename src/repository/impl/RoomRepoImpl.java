package repository.impl;

import entity.Room;
import entity.RoomEntity;
import repository.RoomRepo;

import java.sql.SQLException;
import java.util.List;

public class RoomRepoImpl implements RoomRepo {

    private RoomEntityRepoImpl roomEntityRepo;

    @Override
    public List<Room> all() {
        return null;
    }

    @Override
    public Room byName(String name) throws SQLException {
        RoomEntity roomEntity = roomEntityRepo.byName(name);
        Room r = new RoomEntity(roomEntity.nameRoom(),roomEntity.rows(),roomEntity.columns());
        return r;
    }

    @Override
    public void save(Room room) {

    }
}
