
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Pattern {
    
    public static void Pattern(){
        String[] options = {"Right Triangle", "Inverted Triangle", "Pyramid", "Diamond", "Square", "Hollow Square", "X Pattern", "Checkerboard"};

        int choice = JOptionPane.showOptionDialog(null,"Choose a pattern to display:", "Pattern Selector", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "Exit the program?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) System.exit(0);
        }

        int rows = getValidatedInput("Enter number of rows (1–20):");

        String pattern = "";

        switch (choice) {
            case 0:
                pattern = rightTriangle(rows);
                break;
            case 1:
                pattern = invertedTriangle(rows);
                break;
            case 2:
                pattern = pyramid(rows);
                break;
            case 3:
                pattern = diamond(rows);
                break;
            case 4:
                pattern = square(rows);
                break;
            case 5:
                pattern = hollowSquare(rows);
                break;
            case 6:
                pattern = xPattern(rows);
                break;
            case 7:
                pattern = checkerboard(rows);
                break;
            default:
                pattern = "Invalid pattern selection.";
        }

        JOptionPane.showMessageDialog(null, pattern);
    }

    private static int getValidatedInput(String message) {
        int value = -1;
        boolean valid = false;

        while (!valid) {
            String input = JOptionPane.showInputDialog(message);

            if (input == null) {
                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) System.exit(0);
                else continue;
            }

            input = input.trim();

            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty.");
                continue;
            }

            try {
                value = Integer.parseInt(input);
                if (value < 1 || value > 20) {
                    JOptionPane.showMessageDialog(null, "Please enter a number from 1 to 20.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid whole number.");
            }
        }

        return value;
    }

    private static String rightTriangle(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            sb.append(repeat("*",i)).append("\n");
        }
        return sb.toString();
    }

    private static String invertedTriangle(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = rows; i >= 1; i--) {
            sb.append(repeat("*",i)).append("\n");
        }
        return sb.toString();
    }

    private static String pyramid(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            sb.append(repeat("*",rows - i));
            sb.append(repeat("*",2 * i - 1)).append("\n");
        }
        return sb.toString();
    }

    private static String diamond(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            sb.append(repeat("*",rows - i));
            sb.append(repeat("*",2 * i - 1)).append("\n");
        }
        for (int i = rows - 1; i >= 1; i--) {
            sb.append(repeat("*",rows - i));
            sb.append(repeat("*",2 * i - 1)).append("\n");
        }
        return sb.toString();
    }

    private static String square(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(repeat("*",size)).append("\n");
        }
        return sb.toString();
    }

    private static String hollowSquare(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) {
                sb.append(repeat("*",size)).append("\n");
            } else {
                sb.append("*");
                sb.append(repeat("",size - 2));
                sb.append("*\n");
            }
        }
        return sb.toString();
    }

    private static String xPattern(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j || j == (size - i - 1)) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String checkerboard(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append((i + j) % 2 == 0 ? "*" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    private static String repeat(String s, int count) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
        sb.append(s);
    }
    return sb.toString();
    }
}
