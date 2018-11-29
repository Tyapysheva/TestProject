import entity.Reservation;
import entity.Room;
import helper.JDBCConnectionHelper;
import repository.RoomRepo;
import repository.impl.RoomRepoImpl;
import service.*;
import service.management.*;
import service.management.factory.EntityOpManagementFactory;
import service.management.factory.ModelOpManagementFactory;
import service.management.factory.OperationManagementFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args)  throws ClassNotFoundException, SQLException{


        OperationManagementFactory<EntityOpManagement> entityOpFactory = new EntityOpManagementFactory(
                () -> {
            try {
                try {
                    return JDBCConnectionHelper.getConnection();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
                }

        ); //provide connection

        OperationManagementFactory<ModelOpManagement> modelOpFactory = new ModelOpManagementFactory(entityOpFactory);

        BasicReservationManager reservationManager = new BasicReservationManager(modelOpFactory);

        Room room = modelOpFactory.runWith(management -> {
            RoomRepo roomRepo = management.roomRepo();
            Room test;
            try {
                test = roomRepo.byName("Test");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("oy");
            }
            return null;
        });
        System.out.println(room.nameRoom());
        List<Reservation> allReservations = reservationManager.all(room);
        allReservations.forEach(System.out::println);


    }
}
