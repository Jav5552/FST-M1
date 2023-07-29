package Activities;

public class Activity1  {

    public static void main(String[] args){
        Car MB=new Car();
        MB.color="Black";
        MB.make=2014;
        MB.transmission="Manual";

        MB.accelarate();;
        MB.brake();
        MB.displayCharacteristics();

    }


}
