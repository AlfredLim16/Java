
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Profile_of_User {
    
    public static void Profile_of_User() {
        String name;
        int age = 0;
        double weight = 0.0;
        char gender = ' ';

        name = JOptionPane.showInputDialog(null, "Enter your name:", "User Profile", JOptionPane.QUESTION_MESSAGE);
        if (name == null) {
            JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean valid = false;
        while (!valid) {
            String input = JOptionPane.showInputDialog(null, "Enter your age:", "User Profile", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                age = Integer.parseInt(input);
                if (age <= 0) {
                    JOptionPane.showMessageDialog(null, "Age must be a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid whole number for age.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        valid = false;
        while (!valid) {
            String input = JOptionPane.showInputDialog(null, "Enter your weight (kg):", "User Profile", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                weight = Double.parseDouble(input);
                if (weight <= 0) {
                    JOptionPane.showMessageDialog(null, "Weight must be a positive number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for weight.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        valid = false;
        while (!valid) {
            String input = JOptionPane.showInputDialog(null, "Enter your gender (M/F):", "User Profile", JOptionPane.QUESTION_MESSAGE);         
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                gender = input.charAt(0);
                valid = true;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a single letter (M/F).", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
        String profile = "Name: " + name + "\nAge: " + age + "\nWeight: " + weight + " kg" + "\nGender: " + gender;
        JOptionPane.showMessageDialog(null, profile, "User Profile Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
