package service;

import java.sql.Connection;
import java.util.function.Supplier;

public class EntityOpManagementFactory implements OperationManagementFactory<EntityOpManagement> {


    private Supplier<Connection> sc;

    public EntityOpManagementFactory(Supplier<Connection> sc) {
        this.sc = sc;
    }


    @Override
    public EntityOpManagement newManagement() {
        return null;
    }
}
