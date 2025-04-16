package testcases.genericProgram.Programs_on_String;

public class PrimeNumber_from_Array {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8,9,10};

        for(int i=1;i<a.length;i++) {
            int count=0;
            for (int j = 1; j <= a[i]; j++) {
                if (a[i] % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println("Prime number is: "+a[i]);
            }
        }
    }
}
