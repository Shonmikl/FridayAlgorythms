package unit.reactor;

public class ReactorCoolingSystem {

    private Thermometer thermometer;
    private double temperatureThreshold;
    private boolean isOn;

    public ReactorCoolingSystem() {
        isOn = false;
    }

    public void checkReactorCoolingSystem() {
        this.isOn = (thermometer.getTemperature() >= temperatureThreshold);
    }

    public boolean isOn() {
        return isOn;
    }

    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public void setTemperatureThreshold(double temperatureThreshold) {
        this.temperatureThreshold = temperatureThreshold;
    }
}