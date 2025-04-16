package testcases.genericProgram.Programs_on_String;

import java.util.Scanner;

public class PrimeNumber_with_one_nmbr {

    public static void main(String[] args) {

        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int count =0;
        for(int i=1;i<=num;i++){
            if(num%i==0){
                count++;
            }
            if(count>2){
                break;
            }
        }
        if(count<=2){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not prime");
        }
    }
}
