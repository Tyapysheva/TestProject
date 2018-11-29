package repository.impl;

import entity.RoomEntity;
import repository.RoomEntityRepo;

import java.sql.*;


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
    public RoomEntity byName(String name) throws SQLException {
        String sql = "SELECT name_room,total_row,total_col" +
                " FROM cinema_room WHERE name_room = ? ";
        Connection connection = this.connection;
        PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"Test");
            ResultSet rs = statement.executeQuery();
          rs.next();
              RoomEntity r = new RoomEntity(rs.getString("name_room"),rs.getInt("total_row"),rs.getInt("total_col"));
        return r;
    }

    @Override
    public void save(RoomEntity room) {

    }
}
