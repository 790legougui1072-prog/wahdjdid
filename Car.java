package carsrentalsystem;

public class Car extends Vehicle implements Insurable {

    private int numberOfDoors;
    private boolean airConditioning;

    public Car(String registrationNumber, String brand,
               String model, int year, double dailyRate,
               FuelType fuelType, int numberOfDoors,
               boolean airConditioning) {

        super(registrationNumber, brand, model,
              year, dailyRate, fuelType);

        this.numberOfDoors = numberOfDoors;
        this.airConditioning = airConditioning;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public boolean hasAirConditioning() {
        return airConditioning;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0;
        }

        double cost = getDailyRate() * days;

        if (airConditioning) {
            cost += cost * 0.10;
        }

        return cost;
    }

    @Override
    public double calculateInsurance() {
        return getDailyRate() * 0.05;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
               "\nNumber of Doors: " + numberOfDoors +
               "\nAir Conditioning: " + airConditioning;
    }
}