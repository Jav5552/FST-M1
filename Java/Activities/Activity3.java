package Activities;

public class Activity3 {


    public static void main(String[] args){

        int ageSec=1000000000;
        double earthSec=31557600;
        double mercurySec=0.2408467;
        double venusSec=0.61519726;
        double marsSec=1.8808158;
        double jupiterSec=11.862615;
        double saturnSec=29.447498;
        double uranusSec=84.016846;
        double neptuneSec=164.79132;

        System.out.println("Age on earth "+ageSec/earthSec);
        System.out.println("Age on mercury "+ageSec/earthSec/mercurySec);
        System.out.println("Age on venus "+ageSec/earthSec/venusSec);
        System.out.println("Age on mars "+ageSec/earthSec/marsSec);
        System.out.println("Age on jupiter "+ageSec/earthSec/jupiterSec);
        System.out.println("Age on saturn "+ageSec/earthSec/saturnSec);
        System.out.println("Age on uranus "+ageSec/earthSec/uranusSec);
        System.out.println("Age on neptune "+ageSec/earthSec/neptuneSec);

    }




}
