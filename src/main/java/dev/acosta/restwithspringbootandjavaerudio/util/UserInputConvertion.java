package dev.acosta.restwithspringbootandjavaerudio.util;

public class UserInputConvertion {

    public static Double convertNumericInputToDouble(String userInput) {
        if (userInput == null) return 0D;
        return Double.parseDouble(UserInputCheck.correctUserNumberInput(userInput));
    }

}
