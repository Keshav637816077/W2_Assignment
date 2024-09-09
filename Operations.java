/***
 * Java Programming Assignment - Week-2, Assignment-1
 * 
 * This Program runs the five operations according to the user's choice.
 * 1. Parentheses Combination Generator. 
 * 2. Digit Sum Loop. 
 * 3. Consecutive Number Summer. 
 * 4. Caesar Cipher with Shift Variability.
 * 5. Encoding Challenge with ASCII Conversion.
 * 
 * Program Owner - Keshav Kumar
 * Date - 09/09/2024
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations {

    static Constant constant = new Constant();
    public static Scanner input = new Scanner(System.in);

    public static void consecutive_generator(){
        System.out.println(constant.Input1);

    }

    /***
     * Method to Sum the digits of a number in Loop.
     * This takes input integer as the input and finds the sum of all digits in the number.
     * This method returns the sum of the digits as the Output.
     */

    public static void Digit_sum(){
        System.out.print(constant.Input2);
        try{
            long number = input.nextLong();
            if(number < 0){
                System.out.println(constant.Wrong2);
            }else{
                while (number >= 10) {
                    int sum = 0;
                    while (number > 0) {
                        sum += number % 10; 
                        number /= 10;
                    }
                    number = sum;
                }
                System.out.println(constant.Output2 + number);
            }
        }catch(InputMismatchException e){
            System.out.println(constant.Wrong2);
        }
    }

    /***
     * Method to find the Consecutive Number Summer
     * This method takes the input number as the input and finds the consecutive number that gives the sum thatr is equal to the number.
     * The method printCombination prints the numbers in the + form.
     * This method gives the numbers that give the sum as the Output.
     */

    public static void ConsecutiveSum() {
        System.out.print(constant.Number);
        try{
            int number = input.nextInt();
            if(number < 0){
                System.out.println(constant.Wrong2);
            }else{
                for (int i = 1; i <= number / 2; i++) {
                    int sum = 0;
                    int current = i;
                    while (sum < number) {
                        sum += current;
                        current++;
                        if (sum == number) {
                            printCombination(i, current - 1);
                            break;
                        }
                    }
                }
            }
        }catch(InputMismatchException e){
            System.out.println(constant.Wrong2);
        }
    }

    public static void printCombination(int i, int end) {
        System.out.print(constant.Combination);
        for (int j = i; j <= end; j++) {
            System.out.print(j);
            if (j < end) {
                System.out.print(constant.Plus);
            }
        }
        System.out.println();
    }

    

    public static void main(String[] args){
        System.out.println(constant.Welcome);
        System.out.println(constant.Operations);
        System.out.print(constant.Choice);
        String choice = input.next();
        boolean quit = true;
        do{
            switch (choice) {
                case "1":
                    
                    break;
                
                case "2":
                    Digit_sum();
                    break;

                case "3":
                    ConsecutiveSum();
                    break;

                case "4":
                    System.out.println("4");
                    break;

                case "5":
                    System.out.println("5");
                    break;

                case "0":
                    quit = false;
                    break;
            
                default:
                    System.out.println(constant.Invalid);
                    break;
            }
            if(quit){
                System.out.print(constant.Choice);
                input.nextLine();
                choice = input.next();
            }
        } while (quit);
        input.close();  
    }
}
