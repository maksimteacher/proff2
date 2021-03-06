package AndreyKukuruzaHomeWork.Homework3.Task2;

import AndreyKukuruzaHomeWork.Homework3.Task2.Body.Body;
import AndreyKukuruzaHomeWork.Homework3.Task2.Computer.Computer;
import AndreyKukuruzaHomeWork.Homework3.Task2.Engine.Engine;

public class CarBuilder {
    Car car;

    public CarBuilder setBody(Body body) {
        car.setBody(body);
        return this;
    }

    public CarBuilder setEngine(Engine engine) {
        car.setEngine(engine);
        return this;
    }

    public CarBuilder setComputer(Computer computer) {
        car.setComputer(computer);
        return this;

    }

    public Car build() {
        return car;
    }


}
