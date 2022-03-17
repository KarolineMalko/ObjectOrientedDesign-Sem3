package model;

/**
 * invoked when a new update to registry made
 */
public interface RegisterObserver {
    void newSale(int updatedAmountInReg);
}
