package testcases.genericProgram;

import org.testng.annotations.Test;

import java.util.Scanner;

public class PrimeNumber {

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
