package AndreyKukuruzaHomeWork.Homework3.Task2;

import AndreyKukuruzaHomeWork.Homework3.Task2.Body.Body;
import AndreyKukuruzaHomeWork.Homework3.Task2.Computer.Computer;
import AndreyKukuruzaHomeWork.Homework3.Task2.Engine.Engine;

public class Car {
    private Engine engine;
    private Computer computer;
    private Body body;

    public Body getBody() {
        return body;
    }

    public Car setBody(Body body) {
        this.body = body;
        return this;
    }

    public Computer getComputer() {
        return computer;
    }

    public Car setComputer(Computer computer) {
        this.computer = computer;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public Car setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

}