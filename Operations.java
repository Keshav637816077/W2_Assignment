/***
 * Java Programming Assignment - Week-2, Assignment-2
 * 
 * This Program runs the five operations according to the user's choice.
 * 1. CountPalindromes - Write a Java program that takes a string as input and calculates the number of unique combinations where a palindrome is formed.
 * 2. NthFibonacci - Write a Java program to print the nth number in the Fibonacci series without using loops.
 * 3. SnakeToCamel - Write a Java program where the user inputs a string in snake_case. If the string is not in snake_case, first convert it to snake_case, and then to camelCase.
 * 4. CountConsonants - Write a Java program that takes a string as input and finds the number of consonants in the string. 
 * 5. BinaryToDecimal - Write a Java program that takes an integer in binary format and converts it to its decimal representation.
 * 
 * Program Owner - Keshav Kumar
 * Date - 11/09/2024
 * 
 */

import java.util.Scanner;

public class Operations {
    static Constant constant = new Constant();
    public static Scanner input = new Scanner(System.in);

    /***
     * Method to find the Nth Fibonacci Series.
     */

    public static void fibonacci(long firstNumber, long secondDigit, int inputNumber, int count){
        if(count == inputNumber){
            System.out.println(constant.Output1 + secondDigit);
        }else{
            count++;
            long sumOfDigits = firstNumber + secondDigit;
            firstNumber = secondDigit;
            secondDigit = sumOfDigits;
            fibonacci(firstNumber, secondDigit, inputNumber, count);
        }
    }

    /***
     * Method to convert Binary number to Decimal.
     */

    public static void BinarytoDecimal(long binaryNumber, long decimalNumber,int index){
        if(binaryNumber > 0){
            long lastElement = (binaryNumber % 10);
            if(lastElement != 0 && lastElement != 1 ){
                System.out.println(constant.Invalid1);
                return;
            }
            decimalNumber = decimalNumber + lastElement*(int)(Math.pow(2, index));
            binaryNumber = binaryNumber/10;
            BinarytoDecimal(binaryNumber, decimalNumber, ++index);
        }else{
            System.out.println(constant.Output2 + decimalNumber);
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(constant.WelcomePrompt);
        System.out.println(constant.Operations);
        System.out.print(constant.ChoicePrompt);
        String choice = input.next();
        boolean quit = true;
        do {
            switch (choice) {
                case "1":
                    boolean continuecase = true;
                    while(continuecase){
                        System.out.println("code");
                        System.out.println(constant.ContinuecasePrompt);
                        char choicecase = input.next().charAt(0);
                        if(choicecase == 'y'){
                            continue;
                        }else{
                            continuecase = false;
                        }
                    }
                    break;

                case "2":
                    boolean continuecase2 = true;
                    while(continuecase2){
                        try{
                            System.out.print(constant.Input1);
                            int inputNumber = input.nextInt();
                            if(inputNumber < 0 || inputNumber > 92){
                                System.out.println(constant.Invalid);
                            }
                            else if(inputNumber == 0 || inputNumber == 1){
                                System.out.println(inputNumber);
                            }
                            else{int count = 1; 
                                fibonacci(0,1, inputNumber, count);
                            }
                        }
                        catch(Exception e){
                            System.out.println(constant.Invalid);
                        }
                        System.out.println(constant.ContinuecasePrompt);
                        char choicecase = input.next().charAt(0);
                        if(choicecase == 'y'){
                            continue;
                        }else{
                            continuecase2 = false;
                        }
                    }
                    break;

                case "3":
                    boolean continuecase3 = true;
                    while(continuecase3){
                        System.out.println("code");
                        System.out.println(constant.ContinuecasePrompt);
                        char choicecase = input.next().charAt(0);
                        if(choicecase == 'y'){
                            continue;
                        }else{
                            continuecase3 = false;
                        }
                    }
                    break;

                case "4":
                    boolean continuecase4 = true;
                    
                    while(continuecase4){
                        System.out.println(constant.ContinuecasePrompt);
                        char choicecase = input.next().charAt(0);
                        if(choicecase == 'y'){
                            continue;
                        }else{
                            continuecase4 = false;
                        }
                    }
                    break;

                case "5":
                    boolean continuecase5 = true;
                    long inputNumber;
                    while(continuecase5){
                        try{
                            System.out.print(constant.Input2);
                            inputNumber = input.nextLong();
                            if(inputNumber < 0) {
                                System.out.println(constant.Invalid1);
                                input.close();
                                return;
                            }
                            BinarytoDecimal(inputNumber, 0, 0);
                        }catch(Exception e){
                            System.out.println(constant.Invalid1);
                        }
                        System.out.println(constant.ContinuecasePrompt);
                        char choicecase = input.next().charAt(0);
                        if(choicecase == 'y'){
                            continue;
                        }else{
                            continuecase5 = false;
                        }
                    }
                    break;

                case "0":
                    quit = false;
                    break;

                default:
                    System.out.println(constant.Invalid);
                    break;
            }
            if (quit) {
                System.out.print(constant.ChoicePrompt);
                input.nextLine();
                choice = input.next();
            }
        } while (quit);
        input.close();    
    }
}
