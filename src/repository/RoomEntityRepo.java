package repository;

import entity.RoomEntity;

public interface RoomEntityRepo {
    RoomEntity byId(long id);

    RoomEntity byName(String name);

    void save(RoomEntity room);
}


