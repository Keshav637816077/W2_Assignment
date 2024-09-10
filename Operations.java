
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

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations {

    static Constant constant = new Constant();
    public static Scanner input = new Scanner(System.in);

    /***
     * This method is used to find all the possible combinatons of the string.
     * This method takes the input string as character array and stores the result
     * in character array, it also takes the index, boolean to find whether the
     * combination exists or not and length to find the length of the string.
     * This method gives the all possible combinations as the Output.
     */

    public static void Combination_generator(char[] array, char[] result, int position, boolean[] used, int length) {
        if (position == length) {
            for (int i = 0; i < length; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!used[i]) {
                used[i] = true;
                result[position] = array[i];
                Combination_generator(array, result, position + 1, used, length);
                used[i] = false;
            }
        }
    }

    /***
     * Method to Sum the digits of a number in Loop.
     * This takes input integer as the input and finds the sum of all digits in the
     * number.
     * This method returns the sum of the digits as the Output.
     */

    public static void Digit_sum() {
        System.out.print(constant.Input2);
        try {
            long inputnumber = input.nextLong();
            if (inputnumber < 0) {
                System.out.println(constant.Wrong);
            } else {
                while (inputnumber >= 10) {
                    int consecutivesum = 0;
                    while (inputnumber > 0) {
                        consecutivesum += inputnumber % 10;
                        inputnumber /= 10;
                    }
                    inputnumber = consecutivesum;
                }
                System.out.println(constant.Output2 + inputnumber);
            }
        } catch (InputMismatchException e) {
            System.out.println(constant.Wrong);
        }
    }

    /***
     * Method to find the Consecutive Number.
     * This method takes the input number as the input and finds the consecutive
     * number that gives the sum thatr is equal to the number.
     * The method "printCombination" prints the numbers in the + form.
     * This method gives the numbers that give the sum as the Output.
     */

    public static void ConsecutiveSum() {
        System.out.print(constant.Number);
        try {
            int inputnumber = input.nextInt();
            if (inputnumber <= 0) {
                System.out.println(constant.Wrong);
            } else {
                boolean Sum = true;
                for (int i = 1; i <= inputnumber / 2; i++) {
                    int consecutivesum = 0;
                    int currentnumber = i;
                    while (consecutivesum < inputnumber) {
                        consecutivesum += currentnumber;
                        currentnumber++;
                        if (consecutivesum == inputnumber) {
                            printCombination(i, currentnumber - 1);
                            Sum = false;
                            break;
                        }
                    }
                }
                if (Sum) {
                    System.out.println("No Consecutive Sum");

                }
            }
        } catch (InputMismatchException e) {
            System.out.println(constant.Wrong);
        }
    }

    // This method is the print function of above method.

    public static void printCombination(int i, int k) {
        System.out.print(constant.Combination);
        for (int j = i; j <= k; j++) {
            System.out.print(j);
            if (j < k) {
                System.out.print(constant.Plus);
            }
        }
        System.out.println();
    }

    /***
     * Method to find the Caesar Cipher with Shift Variability
     * This method takes the string as input and only takes alphabets as input and
     * sends all other as invalid input.
     * It then takes the number of shift patterns and the shift pattern as the
     * input.
     * In this method we take the input and then finds finds the shift pattern as
     * how many shift we have to do and then add that shift to the alphabet ASCII
     * number.
     * It gives the coded Caesar Cipher as the Output.
     */

    public static void Cipher() {
        System.out.print(constant.Input41);
        String input2 = input.next();

        boolean Valid = true;
        for (int i = 0; i < input2.length(); i++) {
            if (!Character.isLetter(input2.charAt(i)) && !Character.isWhitespace(input2.charAt(i))) {
                Valid = false;
                break;
            }
        }
        if (Valid) {
            System.out.print(constant.Input42);
            try {
                int patternLength = input.nextInt();
                int[] shiftPattern = new int[patternLength];
                System.out.println(constant.Input43);

                for (int i = 0; i < patternLength; i++) {
                    shiftPattern[i] = input.nextInt();
                }

                char[] result = new char[input2.length()];
                int shiftIndex = 0;

                for (int i = 0; i < input2.length(); i++) {
                    char currentChar = input2.charAt(i);

                    if (Character.isLetter(currentChar)) {
                        int shift = shiftPattern[shiftIndex % patternLength];
                        shiftIndex++;

                        if (Character.isUpperCase(currentChar)) {
                            result[i] = (char) ((currentChar - 'A' + shift) % 26 + 'A');
                        } else if (Character.isLowerCase(currentChar)) {
                            result[i] = (char) ((currentChar - 'a' + shift) % 26 + 'a');
                        }
                    } else {
                        result[i] = currentChar;
                    }
                }
                System.out.println(constant.Output4 + new String(result));
            } catch (Exception e) {
                System.out.println(constant.Wrong);
            }
        } else {
            System.out.println(constant.Wrong);
        }
    }

    /***
     * This method converts the largest number into ASCII number.
     * This method takes the array size , array , series size and series as the
     * input and the sort it.
     * After sorting it converts it into ASCII code and gives the result as the
     * string.
     */

    public static void asciiConversion() {
        System.out.print(constant.Array);
        int array_size;
        try {
            array_size = input.nextInt();
        } catch (Exception e) {
            System.out.println(constant.Wrong);
            return;
        }
        if (array_size <= 0) {
            System.out.println(constant.Wrong);
            return;
        }
        int[] array = new int[array_size];
        System.out.print(constant.Array1);
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = input.nextInt();
            } catch (Exception e) {
                System.out.println(constant.Wrong);
                return;
            }
        }
        Arrays.sort(array);
        System.out.print(constant.Series);
        int series_size;
        try {
            series_size = input.nextInt();
        } catch (Exception e) {
            System.out.println(constant.Wrong);
            return;
        }
        if (series_size <= 0) {
            System.out.println(constant.Wrong);
            return;
        }
        int[] series = new int[series_size];
        System.out.print(constant.Series2);
        for (int i = 0; i < series.length; i++) {
            try {
                series[i] = input.nextInt();
            } catch (Exception e) {
                System.out.println(constant.Wrong);
                return;
            }
        }
        String result = "";
        for (int i = 0; i < series.length; i++) {
            int position = series[i];
            if (position > 0 && position <= array.length) {
                int digit = array[array.length - position];
                result = result + (digit + '0');
            }
        }
        System.out.println(constant.Output4 + result);
    }

    public static void main(String[] args) {
        System.out.println(constant.Welcome);
        System.out.println(constant.Operations);
        System.out.print(constant.Choice);
        String choice = input.next();
        boolean quit = true;
        do {
            switch (choice) {
                case "1":
                    System.out.print(constant.Input1);

                    String inputString = input.nextLine();
                    inputString = input.nextLine();
                    char[] input1 = new char[inputString.length()];
                    boolean[] used = new boolean[input1.length];
                    for (int i = 0; i < inputString.length(); i++) {
                        input1[i] = inputString.charAt(i);
                    }
                    char[] result = new char[input1.length];
                    for (int length = 1; length <= input1.length; length++) {
                        Combination_generator(input1, result, 0, used, length);
                    }
                    break;

                case "2":
                    Digit_sum();
                    break;

                case "3":
                    ConsecutiveSum();
                    break;

                case "4":
                    Cipher();
                    break;

                case "5":
                    asciiConversion();
                    break;

                case "0":
                    quit = false;
                    break;

                default:
                    System.out.println(constant.Invalid);
                    break;
            }
            if (quit) {
                System.out.print(constant.Choice);
                input.nextLine();
                choice = input.next();
            }
        } while (quit);
        input.close();
    }
}
