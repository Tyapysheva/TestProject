package repository.impl;

import entity.RoomEntity;
import repository.RoomEntityRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class RoomEntityRepoImpl implements RoomEntityRepo {

    private Connection connection;

    public RoomEntityRepoImpl(Connection c) {
        connection = c;
    }

    @Override
    public RoomEntity byId(long id) {
        return null;
    }

    @Override
    public RoomEntity byName(String name) throws Exception {
        String sql = "name_room,total_row,total_col" +
                " FROM cinema_room WHERE name_room = ? ";
        try (Connection connection = this.connection;
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, "Test");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name_room1 = rs.getString("name_room");
                int total_row = rs.getInt("total_row");
                int total_col = rs.getInt("total_col");
                RoomEntity roomEntity = new RoomEntity(name_room1, total_row, total_col);
                return roomEntity;
            }
        }
        return null;
    }

    @Override
    public void save(RoomEntity room) {

    }
}
