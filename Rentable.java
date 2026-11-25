package carsrentalsystem;

public interface Rentable {

    void rent();

    void returnVehicle();

    boolean isAvailable();

    double calculateRentalCost(int days);
}