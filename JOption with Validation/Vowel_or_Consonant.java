
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Vowel_or_Consonant {
    
    public static void Vowel_or_Consonant() {
        boolean validInput = false;
        char ltr = ' ';

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Enter a letter:", "Vowel or Consonant", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a single letter.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ltr = input.charAt(0);
                validInput = true;
            }
        }

        char lower = Character.toLowerCase(ltr);

        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            JOptionPane.showMessageDialog(null, ltr + " is a Vowel", "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, ltr + " is a Consonant", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
