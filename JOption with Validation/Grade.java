
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Grade {
    public static void Grade(){
        	
        double prelim, midterm, fin, result;
        
        prelim = Input("Enter Prelim: ");
        midterm = Input("Enter Midterm: ");
        fin = Input("Enter Final: ");
                
        result = (prelim + midterm + fin) / 3;

        JOptionPane.showMessageDialog(null, "Your average grade is: " + result);
    }
    
    private static double Input(String message) {
        double grade = -1;
        boolean valid = false;

        while (!valid) {
            String input = JOptionPane.showInputDialog(message);

            if (input == null) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    continue;
                }
            }

            input = input.trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty. Please enter a valid grade.", "Empty Field", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            try {
                grade = Double.parseDouble(input);
                if (grade < 50 || grade > 100) {
                    JOptionPane.showMessageDialog(null, "Please enter a grade between 50 and 100.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number. Please enter a numeric value.");
            }
        }

        return grade;
    }
}
