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
     * This method takes the first Number, second number and input numbr as the input and finds the fibonacci number at that place.
     * This method returns the fibonacci number as the output.
     */

    public static void fibonacci(long firstNumber, long secondNumber, int inputNumber, int count){
        if(count == inputNumber){
            System.out.println(constant.OUTPUT1 + secondNumber);
        }else{
            count++;
            long sumOfNumbers = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = sumOfNumbers;
            fibonacci(firstNumber, secondNumber, inputNumber, count);
        }
    }

    /***
     * Method to convert snake case into camel case.
     * This
     */

    public static void snakeToCamel(String newstring ,String OutputString, int index) {
        if (index >= newstring.length()) {
            System.out.println(OutputString);
            return ;
        }
        if (newstring.charAt(index) != '_' && newstring.charAt(index) != ' ') {
            OutputString += Character.toLowerCase(newstring.charAt(index));
        }
        else{
            if (newstring.charAt(index + 1) != '_' && newstring.charAt(index + 1) != ' ') {
                OutputString += Character.toUpperCase(newstring.charAt(index + 1));
                index++;
            }
        }
       snakeToCamel(newstring,  OutputString ,index+1);

    }

    /***
     * Method to convert Binary number to Decimal.
     * This method takes the binary number, decimal number for saving result and index as the input and converts the input binary number into decimal number by using math.pow .
     * This method returns the decimal number as the output.
     */

    public static void binaryToDecimal(long binaryNumber, long decimalNumber,int index){
        if(binaryNumber > 0){
            long lastElement = (binaryNumber % 10);
            if(lastElement != 0 && lastElement != 1 ){
                System.out.println(constant.INVALID1);
                return;
            }
            decimalNumber = decimalNumber + lastElement * (int)(Math.pow(2, index));
            binaryNumber = binaryNumber/10;
            binaryToDecimal(binaryNumber, decimalNumber, ++index);
        }else{
            System.out.println(constant.OUTPUT2 + decimalNumber);
            return;
        }
    }

    /***
     * Method to find the number of Consonants in the given string.
     * This method takes the input String as the input and finds if it contains or else prints the number of constants.
     * This method returns number of consonants as the output.
     */

    private static int consonants(String inputString) {
        if(inputString.isEmpty()){
            return 0;
        }else{
            char firstChar = inputString.charAt(0);
            if (Character.isLetter(firstChar)){
                if("aeiou".indexOf(firstChar) == -1){
                    return 1 + consonants(inputString.substring(1));
                }else{
                    return consonants(inputString.substring(1));
                }
            }else{
                return consonants(inputString.substring(1));
            }
        }
    }

    public static void countPalindromes(String INPUT_STRING, int count) {
        if (INPUT_STRING.isEmpty()) {
            System.out.println(count);
            return;
        }
        if (INPUT_STRING.length() == 1) {
            count += 1;
            System.out.println(count);
            return;
        } else {
            if (isPalindrome(INPUT_STRING)) {
                count += 2;
            } else {
                count += 1;
            }
        }
        countPalindromes(INPUT_STRING.substring(1, INPUT_STRING.length() - 1), count);
    }

    // To check whether a given string is a palindrome or not
    // Return type --> void
    // Parameters --> String, Integer
    public static boolean isPalindrome(String string) {
        if (string.length() == 1 || string.isEmpty()) {
            return true;
        }
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            isPalindrome(string.substring(1, string.length() - 1));
        } else {
            return false;
        }
        return true;
    }

    

    public static void main(String[] args) throws Exception {
        System.out.println(constant.WELCOME_PROMPT);
        System.out.println(constant.OPERATIONS);
        System.out.print(constant.CHOICE_PROMPT);
        String choice = input.next();
        boolean quit = true;
        do {
            switch (choice) {
                case "1":
                    boolean continuecase = true;
                    while(continuecase){
                        System.out.println(constant.INPUT4);
                        String inputString = input.next();
                        countPalindromes(inputString, 0);
                        System.out.println(constant.CONTINUECASE_PROMPT);
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
                            System.out.print(constant.INPUT1);
                            int inputNumber = input.nextInt();
                            if(inputNumber < 0 || inputNumber > 92){
                                System.out.println(constant.INVALID1);
                            }
                            else if(inputNumber == 0 || inputNumber == 1){
                                System.out.println(inputNumber);
                            }
                            else{int count = 1; 
                                fibonacci(0,1, inputNumber, count);
                            }
                            System.out.println(constant.CONTINUECASE_PROMPT);
                            char choicecase = input.next().charAt(0);
                            if(choicecase == 'y'){
                                continue;
                            }else{
                                continuecase2 = false;
                            }
                        }
                        catch(Exception e){
                            System.out.println(constant.INVALID1);
                            System.out.println(constant.CONTINUECASE_PROMPT);
                            char choicecase = input.next().charAt(0);
                            choicecase = input.next().charAt(0);
                            if(choicecase == 'y'){
                                continue;
                            }else{
                                continuecase2 = false;
                            }
                        }
                    }
                    break;

                case "3":
                    boolean continuecase3 = true;
                    while(continuecase3){
                        try{
                            System.out.print(constant.INPUT4);
                            String inputString = input.next();
                            String outputString = "";
                            snakeToCamel(inputString,outputString,0);
                        } catch(Exception e){
                            System.out.println(constant.INVALID1);
                        }
                        System.out.println(constant.CONTINUECASE_PROMPT);
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
                        try{
                            System.out.print(constant.INPUT4);
                            String inputString = input.nextLine();
                            inputString = input.nextLine().toLowerCase();
                            int consonantCount = consonants(inputString);
                            System.out.println(constant.OUTPUT4 + consonantCount);
                            System.out.println(constant.CONTINUECASE_PROMPT);
                            char choicecase = input.next().charAt(0);
                            if(choicecase == 'y'){
                                continue;
                            }else{
                                continuecase4 = false;
                            }
                        }catch(Exception e){
                            System.out.println(constant.INVALID1);
                            System.out.println(constant.CONTINUECASE_PROMPT);
                            char choicecase = input.next().charAt(0);
                            choicecase = input.next().charAt(0);
                            if(choicecase == 'y'){
                                continue;
                            }else{
                                continuecase4 = false;
                            }
                        }
                    }
                    break;

                case "5":
                    boolean continuecase5 = true;
                    long inputNumber;
                    while(continuecase5){
                        try{
                            System.out.print(constant.INPUT2);
                            inputNumber = input.nextLong();
                            if(inputNumber < 0) {
                                System.out.println(constant.INVALID1);
                            }else{
                                binaryToDecimal(inputNumber, 0, 0);
                            }
                            System.out.println(constant.CONTINUECASE_PROMPT);
                            char choicecase = input.next().charAt(0);
                            if(choicecase == 'y'){
                                continue;
                            }else{
                                continuecase5 = false;
                            }
                        }catch(Exception e){
                            System.out.println(constant.INVALID1);
                            System.out.println(constant.CONTINUECASE_PROMPT);
                            char choicecase = input.next().charAt(0);
                            choicecase = input.next().charAt(0);
                            if(choicecase == 'y'){
                                continue;
                            }else{
                                continuecase5 = false;
                            }
                        }
                    }
                    break;

                case "0":
                    quit = false;
                    break;

                default:
                    System.out.println(constant.INVALID);
                    break;
            }
            if (quit) {
                System.out.print(constant.CHOICE_PROMPT);
                input.nextLine();
                choice = input.next();
            }
        } while (quit);
        input.close();    
    }
}
