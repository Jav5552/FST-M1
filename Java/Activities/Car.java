package Activities;

public class Car {

    Car(){

        tyres=4;
        doors=4;
    }
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public void displayCharacteristics(){

        System.out.println("color is "+color);
        System.out.println("make - "+make);
        System.out.println("tyres -"+tyres);
        System.out.println("Doors -"+doors);
    }

    public void accelarate() {

        System.out.println("car is moving forward");
    }
public void brake(){
    System.out.println("car is stopped");
}
}
