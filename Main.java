package carsrentalsystem;

import java.util.ArrayList;

 class Main {

    public static void main(String[] args) {

        Car car1 = new Car(
            "12345", "Toyota", "Corolla",
            2022, 5000, FuelType.GASOLINE,
            4, true
        );

        Car car2 = new Car(
            "67890", "Hyundai", "i10",
            2021, 3500, FuelType.DIESEL,
            4, false
        );

        Car car3 = new Car(
            "11223", "Tesla", "Model 3",
            2024, 9000, FuelType.ELECTRIC,
            4, true
        );

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);

        // Display information
        for (Vehicle v : vehicles) {
            System.out.println("\n--------------------");
            System.out.println(v.displayInfo());
        }

        // Calculate rental and insurance costs
        System.out.println("\n===== COSTS =====");

        int days = 5;

        for (Vehicle v : vehicles) {

            System.out.println("\n" + v.displayInfo());

            System.out.println(
                "Rental Cost: " + v.calculateRentalCost(days)
            );

            if (v instanceof Car) {
                Car c = (Car) v;

                System.out.println(
                    "Insurance Cost: " + c.calculateInsurance()
                );
            }
        }

        // Test renting and returning
        System.out.println("\n===== RENTAL TEST =====");

        car1.rent();
        System.out.println(car1.isAvailable());

        car1.returnVehicle();
        System.out.println(car1.isAvailable());

        // Demonstrate polymorphism
        System.out.println("\n===== POLYMORPHISM =====");

        for (Vehicle v : vehicles) {
            System.out.println(
                v.calculateRentalCost(3)
            );
        }
    }

}