package model;

/**
 * invoked when a new update to registry made
 */
public interface RegisterObserver {
    void newRegistryUpdate(int updatedAmountInReg);
}
