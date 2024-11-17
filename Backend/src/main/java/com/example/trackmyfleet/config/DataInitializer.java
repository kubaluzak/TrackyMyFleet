package com.example.trackmyfleet.config;

import com.example.trackmyfleet.entity.*;
import com.example.trackmyfleet.service.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    private final DriverService driverService;

    private final VehicleService vehicleService;
    private final LocationService locationService;
    private final VehicleAssignmentService vehicleAssignmentService;


    @Override
    public void run(String... args) throws Exception {
        User admin = new User(null, "admin", "admin123", "admin@example.com", Role.ADMIN);
        User manager = new User(null, "manager", "manager123", "manager@example.com", Role.MANAGER);
        userService.saveUser(admin);
        userService.saveUser(manager);

        Driver driver1 = new Driver(null, "John", "Doe", "B", "123456789", "john.doe@example.com");
        Driver driver2 = new Driver(null, "Jane", "Smith", "C", "987654321", "jane.smith@example.com");
        driverService.saveDriver(driver1);
        driverService.saveDriver(driver2);

        Vehicle vehicle1 = new Vehicle(null, "ABC123", "Toyota", "Corolla", 2020, VehicleStatus.AVAILABLE, 15000);
        Vehicle vehicle2 = new Vehicle(null, "XYZ789", "Ford", "Focus", 2018, VehicleStatus.IN_USE, 30000);
        Vehicle vehicle3 = new Vehicle(null, "LMN456", "Honda", "Civic", 2022, VehicleStatus.AVAILABLE, 5000);
        Vehicle vehicle4 = new Vehicle(null, "PQR678", "BMW", "X5", 2021, VehicleStatus.IN_USE, 25000);
        Vehicle vehicle5 = new Vehicle(null, "JKL234", "Audi", "A4", 2019, VehicleStatus.AVAILABLE, 22000);
        Vehicle vehicle6 = new Vehicle(null, "MNO345", "Mercedes", "E-Class", 2018, VehicleStatus.AVAILABLE, 35000);
        Vehicle vehicle7 = new Vehicle(null, "STU567", "Tesla", "Model 3", 2023, VehicleStatus.IN_USE, 10000);
        Vehicle vehicle8 = new Vehicle(null, "VWX890", "Chevrolet", "Malibu", 2017, VehicleStatus.AVAILABLE, 80000);
        Vehicle vehicle9 = new Vehicle(null, "DEF901", "Hyundai", "Elantra", 2020, VehicleStatus.AVAILABLE, 12000);
        Vehicle vehicle10 = new Vehicle(null, "GHI012", "Kia", "Optima", 2021, VehicleStatus.IN_USE, 18000);
        Vehicle vehicle11 = new Vehicle(null, "JKL345", "Nissan", "Altima", 2022, VehicleStatus.AVAILABLE, 15000);
        Vehicle vehicle12 = new Vehicle(null, "XYZ234", "Mazda", "CX-5", 2019, VehicleStatus.AVAILABLE, 45000);
        Vehicle vehicle13 = new Vehicle(null, "LMN567", "Subaru", "Forester", 2018, VehicleStatus.AVAILABLE, 30000);
        Vehicle vehicle14 = new Vehicle(null, "PQR890", "Volkswagen", "Golf", 2020, VehicleStatus.IN_USE, 25000);
        Vehicle vehicle15 = new Vehicle(null, "STU234", "Ford", "Fusion", 2021, VehicleStatus.AVAILABLE, 14000);
        Vehicle vehicle16 = new Vehicle(null, "DEF678", "Chrysler", "Pacifica", 2022, VehicleStatus.IN_USE, 20000);
        Vehicle vehicle17 = new Vehicle(null, "GHI345", "Jeep", "Grand Cherokee", 2023, VehicleStatus.AVAILABLE, 5000);
        Vehicle vehicle18 = new Vehicle(null, "JKL678", "Ram", "1500", 2020, VehicleStatus.AVAILABLE, 60000);
        Vehicle vehicle19 = new Vehicle(null, "VWX123", "Toyota", "Highlander", 2021, VehicleStatus.AVAILABLE, 15000);
        Vehicle vehicle20 = new Vehicle(null, "ABC456", "Ford", "Escape", 2019, VehicleStatus.IN_USE, 35000);

        vehicleService.saveVehicle(vehicle1);
        vehicleService.saveVehicle(vehicle2);
        vehicleService.saveVehicle(vehicle3);
        vehicleService.saveVehicle(vehicle4);
        vehicleService.saveVehicle(vehicle5);
        vehicleService.saveVehicle(vehicle6);
        vehicleService.saveVehicle(vehicle7);
        vehicleService.saveVehicle(vehicle8);
        vehicleService.saveVehicle(vehicle9);
        vehicleService.saveVehicle(vehicle10);
        vehicleService.saveVehicle(vehicle11);
        vehicleService.saveVehicle(vehicle12);
        vehicleService.saveVehicle(vehicle13);
        vehicleService.saveVehicle(vehicle14);
        vehicleService.saveVehicle(vehicle15);
        vehicleService.saveVehicle(vehicle16);
        vehicleService.saveVehicle(vehicle17);
        vehicleService.saveVehicle(vehicle18);
        vehicleService.saveVehicle(vehicle19);
        vehicleService.saveVehicle(vehicle20);


        Location location1 = new Location(null, vehicle1, BigDecimal.valueOf(52.2297), BigDecimal.valueOf(21.0122), LocalDateTime.now().minusMinutes(10)); // Warszawa
        Location location2 = new Location(null, vehicle2, BigDecimal.valueOf(52.4064), BigDecimal.valueOf(16.9252), LocalDateTime.now().minusMinutes(5));  // Poznań
        Location location3 = new Location(null, vehicle3, BigDecimal.valueOf(50.0647), BigDecimal.valueOf(19.9450), LocalDateTime.now().minusMinutes(15)); // Kraków
        Location location4 = new Location(null, vehicle4, BigDecimal.valueOf(51.1079), BigDecimal.valueOf(17.0385), LocalDateTime.now().minusMinutes(20)); // Wrocław
        Location location5 = new Location(null, vehicle5, BigDecimal.valueOf(53.0116), BigDecimal.valueOf(18.6023), LocalDateTime.now().minusMinutes(30)); // Gdańsk
        Location location6 = new Location(null, vehicle6, BigDecimal.valueOf(51.7592), BigDecimal.valueOf(19.4572), LocalDateTime.now().minusMinutes(25)); // Łódź
        Location location7 = new Location(null, vehicle7, BigDecimal.valueOf(52.2298), BigDecimal.valueOf(21.0118), LocalDateTime.now().minusMinutes(35)); // Warszawa
        Location location8 = new Location(null, vehicle8, BigDecimal.valueOf(53.4289), BigDecimal.valueOf(14.5530), LocalDateTime.now().minusMinutes(40)); // Szczecin
        Location location9 = new Location(null, vehicle9, BigDecimal.valueOf(50.1183), BigDecimal.valueOf(19.6720), LocalDateTime.now().minusMinutes(45)); // Katowice
        Location location10 = new Location(null, vehicle10, BigDecimal.valueOf(51.9194), BigDecimal.valueOf(19.1348), LocalDateTime.now().minusMinutes(50)); // Piotrków Trybunalski
        Location location11 = new Location(null, vehicle11, BigDecimal.valueOf(52.2396), BigDecimal.valueOf(21.0224), LocalDateTime.now().minusMinutes(55)); // Warszawa
        Location location12 = new Location(null, vehicle12, BigDecimal.valueOf(53.5080), BigDecimal.valueOf(13.9407), LocalDateTime.now().minusMinutes(60)); // Świnoujście
        Location location13 = new Location(null, vehicle13, BigDecimal.valueOf(50.4695), BigDecimal.valueOf(19.1059), LocalDateTime.now().minusMinutes(65)); // Bielsko-Biała
        Location location14 = new Location(null, vehicle14, BigDecimal.valueOf(51.3784), BigDecimal.valueOf(17.0503), LocalDateTime.now().minusMinutes(70)); // Legnica
        Location location15 = new Location(null, vehicle15, BigDecimal.valueOf(52.2825), BigDecimal.valueOf(19.6930), LocalDateTime.now().minusMinutes(75)); // Kalisz
        Location location16 = new Location(null, vehicle16, BigDecimal.valueOf(50.9500), BigDecimal.valueOf(19.3010), LocalDateTime.now().minusMinutes(80)); // Zabrze
        Location location17 = new Location(null, vehicle17, BigDecimal.valueOf(51.2485), BigDecimal.valueOf(22.5726), LocalDateTime.now().minusMinutes(85)); // Lublin
        Location location18 = new Location(null, vehicle18, BigDecimal.valueOf(52.0907), BigDecimal.valueOf(19.8590), LocalDateTime.now().minusMinutes(90)); // Radom
        Location location19 = new Location(null, vehicle19, BigDecimal.valueOf(51.7592), BigDecimal.valueOf(19.4572), LocalDateTime.now().minusMinutes(95)); // Łódź
        Location location20 = new Location(null, vehicle20, BigDecimal.valueOf(52.4064), BigDecimal.valueOf(16.9252), LocalDateTime.now().minusMinutes(100)); // Poznań

        locationService.saveLocation(location1);
        locationService.saveLocation(location2);
        locationService.saveLocation(location3);
        locationService.saveLocation(location4);
        locationService.saveLocation(location5);
        locationService.saveLocation(location6);
        locationService.saveLocation(location7);
        locationService.saveLocation(location8);
        locationService.saveLocation(location9);
        locationService.saveLocation(location10);
        locationService.saveLocation(location11);
        locationService.saveLocation(location12);
        locationService.saveLocation(location13);
        locationService.saveLocation(location14);
        locationService.saveLocation(location15);
        locationService.saveLocation(location16);
        locationService.saveLocation(location17);
        locationService.saveLocation(location18);
        locationService.saveLocation(location19);
        locationService.saveLocation(location20);

        VehicleAssignment assignment1 = vehicleAssignmentService.assignDriverToVehicle(vehicle1.getId(), driver1.getId());
        VehicleAssignment assignment2 = vehicleAssignmentService.assignDriverToVehicle(vehicle2.getId(), driver2.getId());


        System.out.println("Sample data initialized.");
    }
}
