package Activities;

import java.util.Arrays;

public class Activity4 {



    public static void main(String[] args) {
        int Arr[]={4,2,3,1};
        int newArr[];
        System.out.println("Before sorting :"+ Arrays.toString(Arr));

        for(int i=Arr.length-1; i>=0; i--){
        //   System.out.println("i "+i);
               for(int j=0;j<i;j++){
                 //System.out.println("j "+j);
                   if (Arr[j]>Arr[j+1]){
                       int temp = Arr[j + 1];
                       Arr[j+1]=Arr[j];
                       Arr[j]=temp;

                   }

               }
        }
        System.out.println("After sorting :"+Arrays.toString(Arr));
}}
