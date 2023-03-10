package unit.reactor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Thermometer {
    private double temperature;

    private Sensor sensor;

    public double getTemperature() {
        if (sensor.isBlocked()) {
            throw new RuntimeException("Sensor is blocked");
        }
        return temperature;
    }
}