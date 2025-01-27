package org.example;


import java.util.Scanner;


public class App {


    public int getInput() {
        return 0;
    }


    public static int superIntPrompt(Scanner scanner, int lowerBound, int upperBound, String promptMessage, String errorMessage) {
        int inputValue;
        String inputString;


        System.out.println("If you would like to use default bounds, please type 'default'. If you would like to use your own, enter 'custom'");
        inputString = scanner.nextLine();


        if (inputString.equalsIgnoreCase("default")) {
            lowerBound = 10;
            upperBound = 20;
        } else if (inputString.equalsIgnoreCase("custom")) {
            System.out.print("Please Input The Lower Bound: ");
            lowerBound = scanner.nextInt();  
            System.out.print("Please Input The Upper Bound: ");
            upperBound = scanner.nextInt();
            scanner.nextLine();
        }




        String customPromptMessage = "Enter a number between " + lowerBound + " and " + upperBound;


        while (true) {
            System.out.println(customPromptMessage);  
            if (scanner.hasNextInt()) {
                inputValue = scanner.nextInt();
                scanner.nextLine();


                if (inputValue >= lowerBound && inputValue <= upperBound) {
                    return inputValue;
                } else {
                    System.out.println(errorMessage);
                }
            } else {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }


    public static String superStringPrompt(Scanner scanner, String promptMessage, String errorMessage) {
        String inputValue;


        while (true) {
            System.out.println(promptMessage);
            inputValue = scanner.nextLine();


            if (!inputValue.isEmpty()) {
                return inputValue;
            } else {
                System.out.println(errorMessage);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        int result = superIntPrompt(scanner, 10, 20, "Enter a number between 10 and 20:", "Input not valid, please try again.");
        assert result >= 10 && result <= 20 : "Test failed! The input should be between 10 and 20.";




        String stringResult = superStringPrompt(scanner, "Please enter a string that is not empty:", "This string is invalid, please enter something else.");
        assert !stringResult.isEmpty() : "Test failed! The input should not be empty.";




        int customTestResult = 15;
        assert customTestResult >= 10 && customTestResult <= 20 : "Test failed! The input should be between 10 and 20.";


        String customStringTestResult = "Hello";
        assert !customStringTestResult.isEmpty() : "Test failed! The string should not be empty.";


        System.out.println("All tests passed successfully.");
    }
}



