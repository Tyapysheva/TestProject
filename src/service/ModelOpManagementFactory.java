package service;

public class ModelOpManagementFactory implements OperationManagementFactory<ModelOpManagement>{
    private OperationManagementFactory<EntityOpManagement> eopF;

    public ModelOpManagementFactory(OperationManagementFactory<EntityOpManagement> eopF) {
        this.eopF = eopF;
    }

    @Override
    public ModelOpManagement newManagement() {
        return null;
    }
}
