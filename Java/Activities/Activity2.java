package Activities;

import org.apache.commons.io.filefilter.TrueFileFilter;

public class Activity2
{

    public static void main(String[] args) {

        int Arr[] = {10, 77, 10, 54, -11, 10};

        System.out.println(verifySum(Arr));


    }
        public static boolean verifySum(int ArrNum[]) {
            int Total = 0;
            for (int num : ArrNum) {

                //System.out.println(num);
                if (num == 10) {
                    Total = Total + num;
                }

            }
            if (Total == 30) {
                return true;

            } else {
                return  false;
            }

        }


}
