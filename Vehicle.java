package carsrentalsystem;

public abstract class Vehicle implements Rentable {

    private String registrationNumber;
    private String brand;
    private String model;
    private int year;
    private double dailyRate;
    private VehicleStatus status;
    private FuelType fuelType;

    public Vehicle(String registrationNumber, String brand,
                   String model, int year, double dailyRate,
                   FuelType fuelType) {

        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.fuelType = fuelType;
        this.status = VehicleStatus.AVAILABLE;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    @Override
    public void rent() {
        if (isAvailable()) {
            status = VehicleStatus.RENTED;
            System.out.println("Vehicle rented successfully.");
        } else {
            System.out.println("Vehicle is not available.");
        }
    }

    @Override
    public void returnVehicle() {
        if (status == VehicleStatus.RENTED) {
            status = VehicleStatus.AVAILABLE;
            System.out.println("Vehicle returned successfully.");
        } else {
            System.out.println("Vehicle was not rented.");
        }
    }

    @Override
    public boolean isAvailable() {
        return status == VehicleStatus.AVAILABLE;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0;
        }

        return dailyRate * days;
    }

    public String displayInfo() {
        return "Registration: " + registrationNumber +
               "\nBrand: " + brand +
               "\nModel: " + model +
               "\nYear: " + year +
               "\nDaily Rate: " + dailyRate +
               "\nStatus: " + status +
               "\nFuel Type: " + fuelType;
    }
}