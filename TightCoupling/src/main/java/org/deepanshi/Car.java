package org.deepanshi;

public class Car {

    private PetroEngine engine;

    public Car() {
        engine = new PetroEngine();
    }

    public void startCar(){
        engine.start();
    }
}
