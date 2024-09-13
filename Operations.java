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
     * This method takes the input string and output string as input and index initially 0.
     * This method returns snke cse into camel as string.
     */

     public static void snakeToCamel(String originalString, int index, String output) {
        if (index == originalString.length()) {
            System.out.println(output);
            return;
        }
    
        char currentCharacter = originalString.charAt(index);
        
        if (currentCharacter != '_') {
            output += currentCharacter;
        } else {
            if (index + 1 < originalString.length()) {
                output += Character.toUpperCase(originalString.charAt(index + 1));
                index++;
            }
        }
        snakeToCamel(originalString, index + 1, output);
    }

    public static void normalToSnake(String originalString, int index, String output, boolean capitalizeNext) {
        
        if (index == originalString.length()) {
            System.out.println(output);
            System.out.print(constant.OUTPUT31);
            snakeToCamel(output, 0, "");
            return;  
        }

        String str2 = originalString.replaceAll("[^a-zA-Z0-9]+", " ").toLowerCase().trim();

        char currentCharacter = str2.charAt(index);

        if (currentCharacter == ' ') {
            if (!output.isEmpty() && output.charAt(output.length() - 1) != '_') {
                output += "_";
            }
            capitalizeNext = true;
        } else {
            if (capitalizeNext) {
                output += currentCharacter ; 
                capitalizeNext = false;  
            } else {
                output += currentCharacter;  
            }
        }
        normalToSnake(str2, index + 1, output, capitalizeNext);
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

    /***
     * Method to find the number of palindromes that can be made in the string.
     * In this method it takes the  input String as the input and finds if it is palindrome or not and then finds substrings and find if it is palindrome or not and stores it if it matches with previous stored string then count doesnot start.
     * In This method it returns the number of palindrome in the string.
     */

    public static boolean isPalindrome(String inputString, int i, int j) {
        if (i >= j) return true; 
        if (inputString.charAt(i) != inputString.charAt(j)) return false; 
        return isPalindrome(inputString, i + 1, j - 1); 
    }

    public static String formSubstring(String inputString, int i, int j) {
        if (i > j) return "";
        return inputString.charAt(i) + formSubstring(inputString, i + 1, j);
    }

    public static boolean isAlreadyPresent(String[] uniquePalindromes, String palindrome, int size) {
        if (size == 0) return false;
        if (uniquePalindromes[size - 1].equals(palindrome)) return true; 
        return isAlreadyPresent(uniquePalindromes, palindrome, size - 1); 
    }

    public static void findPalindromes(String inputString, int i, int j, String[] uniquePalindromes, int[] palindromeCount) {
        int n = inputString.length();
        if (i >= n) return;
        if (j > n) {
            findPalindromes(inputString, i + 1, i + 1, uniquePalindromes, palindromeCount);
            return;
        }

        String substring = formSubstring(inputString, i, j - 1); 
        if (!substring.isEmpty() && isPalindrome(inputString, i, j - 1)) {
            if (!isAlreadyPresent(uniquePalindromes, substring, palindromeCount[0])) {
                uniquePalindromes[palindromeCount[0]] = substring; 
                palindromeCount[0]++;
            }
        }
        findPalindromes(inputString, i, j + 1, uniquePalindromes, palindromeCount);
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
                        try{
                            System.out.print(constant.INPUT4);
                            String inpuString = input.nextLine();
                            inpuString = input.nextLine();
                            String[] uniquePalindromes = new String[15]; 
                            int[] palindromeCount = {0};
                            findPalindromes(inpuString, 0, 1, uniquePalindromes, palindromeCount);
                            System.out.println(constant.UNIQUE_PALINDROMES + palindromeCount[0]);
                        }catch(Exception e){
                            System.out.println(constant.INVALID1);
                        }
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
                            }else if(inputNumber == 0 || inputNumber == 1){
                                System.out.println(inputNumber);
                            }else{int count = 1; 
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
                        System.out.print(constant.INPUT4);
                        String orginalString = input.next();
                        System.out.print(constant.OUTPUT32);
                        normalToSnake(orginalString, 0, "", false);
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
