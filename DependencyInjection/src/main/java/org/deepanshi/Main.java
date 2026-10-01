package org.deepanshi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final EngineFactory engineFactory;

    public Main(EngineFactory engineFactory) {
        this.engineFactory = engineFactory;
    }

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose engine (petrol/diesel): ");

        String type = scanner.nextLine();

        Engine engine = engineFactory.getEngine(type);

        Car car = new Car(engine);

        car.startCar();

        scanner.close();
    }
}