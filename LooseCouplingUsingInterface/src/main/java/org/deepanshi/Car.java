package org.deepanshi;

public class Car {
    private Engine engine;

    public void start() {
        this.engine = new PetrolEngine();
        System.out.println("Car started");
    }
}
