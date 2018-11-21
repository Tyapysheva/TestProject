package repository;

import entity.Reservation;
import entity.Room;
import entity.RoomEntity;
import service.EntityOpManagement;
import service.OperationManagementFactory;

import java.util.List;
import java.util.function.BiFunction;

public class BasicReservationRepo implements ReservationRepo{

    private OperationManagementFactory<EntityOpManagement> opManagementFactory;

    public BasicReservationRepo(OperationManagementFactory<EntityOpManagement> opManagementFactory) {
        this.opManagementFactory = opManagementFactory;
    }

    private <R> R runWithRoom(Room room, BiFunction<RoomEntity, ReservationEntityRepo, R> f) {
        return opManagementFactory.runWith(m -> f.apply(m.roomEntityRepo().byName(room.nameRoom()), m.reservationEntityRepo()));
    }

    @Override
    public List<Reservation> all(Room room) {
        return null;
    }

    @Override
    public Reservation bySeq(Room room, int seq) {
        return null;
    }

    @Override
    public void delete(Reservation reservation) {

    }

    @Override
    public void save(Reservation reservation) {

    }
}
