
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Number_to_Weekly {
    
    public static void Number_to_Weekly() {
        int number = 0;
        boolean valid = false;

        while (!valid) {
            String input = JOptionPane.showInputDialog(null, "Enter a number (1-7):", "Day of the Week", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                number = Integer.parseInt(input);
                if (number < 1 || number > 7) {
                    JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 7.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a whole number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        String day;
        switch (number) {
            case 1: 
                day = "Monday"; 
                break;
            case 2: 
                day = "Tuesday"; 
                break;
            case 3: 
                day = "Wednesday"; 
                break;
            case 4: 
                day = "Thursday"; 
                break;
            case 5: 
                day = "Friday"; 
                break;
            case 6: 
                day = "Saturday"; 
                break;
            case 7: 
                day = "Sunday"; 
                break;
            default: 
                day = "Invalid";
        }
        JOptionPane.showMessageDialog(null, "Day: " + day, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
