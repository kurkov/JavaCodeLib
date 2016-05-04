package JVT.JVT16_JavaObjectAndClass;

import JVT.JVT15_InterfacesAbstract.Crashable;
import JVT.JVT15_InterfacesAbstract.Drivable;

public class Vehicle extends Crashable implements Drivable, Cloneable {

    int numOfWheels = 2;
    double theSpeed = 0;

    int carStrength = 0;

    public int getWheels() {
        return this.numOfWheels;
    }

    public void setWheels(int numWheels) {
        this.numOfWheels = numWheels;
    }

    public double getSpeed() {
        return this.theSpeed;
    }

    public void setSpeed(double speed) {
        this.theSpeed = speed;
    }

    public Vehicle() {

    }

    public Vehicle(int wheels, double speed) {
        this.numOfWheels = wheels;
        this.theSpeed = speed;
    }

    public void setCarStrength(int carStrength) {
        this.carStrength = carStrength;
    }

    public int getCarStrength() {
        return this.carStrength;
    }

    public String toString() {
        return "Num of Wheels: " + this.numOfWheels;
    }

    public Object clone() {
        Vehicle car;

        try {
            car = (Vehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
        return car;
    }

}