package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;
    private int speed;
    private int maxSpeed;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
        this.speed = model.getSpeed();
        this.maxSpeed = model.getMaxSpeed();
    }

    public void speedUp(int seconds) {
        if (model.getSpeed() < maxSpeed) {
            speed += (3.5 * seconds);
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
        model.setSpeed(speed);
    }

    public void speedDown(int seconds) {
        if (speed > 0) {
            speed -= (12 * seconds);
        }
        if (speed < 0) {
            speed = 0;
        }
        model.setSpeed(speed);
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }
}