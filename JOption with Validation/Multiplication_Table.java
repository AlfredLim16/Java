
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Multiplication_Table {
    
    public static void Multiplication_Table() {
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Enter a number:", "Multiplication Table", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                num = Integer.parseInt(input);
                if (num <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid whole number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        StringBuilder table = new StringBuilder("Multiplication Table for " + num + ":\n");

        for (int i = 1; i <= num; i++) {
            table.append(num).append(" x ").append(i).append(" = ").append(num * i).append("\n");
        }
        JOptionPane.showMessageDialog(null, table.toString(), "Result", JOptionPane.INFORMATION_MESSAGE);
    }  
}
