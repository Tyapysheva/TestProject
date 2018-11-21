package service;

import repository.ReservationRepo;
import repository.RoomRepo;

public class BasicModelOpManagement implements ModelOpManagement {

    private EntityOpManagement entityOps;

    public BasicModelOpManagement(EntityOpManagement entityOpsFactory) {
        this.entityOps = entityOpsFactory;
    }

    @Override
    public ReservationRepo reservationRepo() {
        return null;
    }

    @Override
    public RoomRepo roomRepo() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
