import entity.Reservation;
import entity.Room;
import service.*;

import java.util.List;

public class Main {


    public static void main(String[] args) {


        OperationManagementFactory<EntityOpManagement> entityOpFactory = new EntityOpManagementFactory(
                null
                /*() -> JDBCCOnnectionHelper.createConnection(....)*/
        ); //provide connection
        OperationManagementFactory<ModelOpManagement> modelOpFactory = new ModelOpManagementFactory(entityOpFactory);

        BasicReservationManager reservationManager = new BasicReservationManager(modelOpFactory);

        Room room = modelOpFactory.runWith(management -> management.roomRepo().byName("Test"));
        List<Reservation> allReservations = reservationManager.all(room);
        allReservations.forEach(System.out::println);

    }
}
