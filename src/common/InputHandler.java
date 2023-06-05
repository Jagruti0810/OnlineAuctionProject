package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    public static int takeNumberInput() {
        int value = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();
        } catch (InputMismatchException ime) {
            takeNumberInput();
        }
        return value;
    }

    public static String takeStringInput() {
        return takeStringInput(false);
    }

    public static String takeStringInput(boolean isOptional) {
        String value = null;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        if (!isOptional) {
            if (value == null || value.trim().isEmpty()) {
                System.out.println("Invalid input, enter again");
                return takeStringInput(false);
            }
        }
        return value;
    }
}
