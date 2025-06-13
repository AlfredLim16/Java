
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Dollar_Conversion {
    
    public static void Dollar_Conversion() {
        double conversionRate = 56;
        double pesoAmt = 0;

        boolean validInput = false;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Enter amount in Peso:", "Dollar Conversion", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                pesoAmt = Double.parseDouble(input);

                if (pesoAmt < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a non-negative value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        double dollarAmt = pesoAmt * conversionRate;

        JOptionPane.showMessageDialog(null, String.format("Equivalent in Dollar: $%.2f", dollarAmt), "Conversion Result", JOptionPane.INFORMATION_MESSAGE);
    }    
}
