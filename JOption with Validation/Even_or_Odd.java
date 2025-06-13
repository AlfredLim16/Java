
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Even_or_Odd {
    
    public static void Even_or_Odd(){
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Enter a number:", "Even or Odd", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                num = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String result = (num % 2 == 0) ? "Number is Even" : "Number is Odd";

        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
