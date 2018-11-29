package service.management;

import repository.BasicReservationRepo;
import repository.ReservationRepo;
import repository.RoomRepo;
import repository.impl.RoomEntityRepoImpl;
import repository.impl.RoomRepoImpl;

import java.sql.Connection;

public class BasicModelOpManagement implements ModelOpManagement {

    private EntityOpManagement entityOps;

    public BasicModelOpManagement(EntityOpManagement entityOpsFactory) {
        this.entityOps = entityOpsFactory;
    }

    @Override
    public ReservationRepo reservationRepo() {
        return new BasicReservationRepo(() -> entityOps);
    }

    @Override
    public RoomRepo roomRepo() {
        return new RoomRepoImpl();
    }

    @Override
    public void close() throws Exception {
        entityOps.close();
    }
}
