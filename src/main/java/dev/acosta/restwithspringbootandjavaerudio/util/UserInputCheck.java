package dev.acosta.restwithspringbootandjavaerudio.util;

public class UserInputCheck {

    public static boolean isNumeric(String userInput) {
        if (userInput == null) return false;
        return correctUserNumberInput(userInput).matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private static String correctUserNumberInput(String userInput) {
        return userInput.replaceAll(",", ".");
    }

}
