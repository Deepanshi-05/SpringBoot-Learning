package org.deepanshi;

import org.springframework.stereotype.Component;

@Component
public class EngineFactory {

    private final PetrolEngine petrolEngine;
    private final DieselEngine dieselEngine;

    public EngineFactory(
            PetrolEngine petrolEngine,
            DieselEngine dieselEngine) {

        this.petrolEngine = petrolEngine;
        this.dieselEngine = dieselEngine;
    }

    public Engine getEngine(String type) {

        if (type.equalsIgnoreCase("petrol")) {
            return petrolEngine;
        }

        if (type.equalsIgnoreCase("diesel")) {
            return dieselEngine;
        }

        throw new IllegalArgumentException(
                "Invalid engine type. Choose petrol or diesel."
        );
    }
}