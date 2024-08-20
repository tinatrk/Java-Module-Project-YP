public class RacingCar {
    private final String name;
    private final double speed;

    public RacingCar (String name, double speed){
        this.name = name;
        this.speed = speed;
    }

    public String getName(){
        return this.name;
    }

    public double getSpeed(){
        return this.speed;
    }
}
