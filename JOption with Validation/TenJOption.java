import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class TenJOption {

    public static void main(String[] args) {
        String menu = "1. Dollar Conversion\n" 
                    + "2. Multiplication Table\n"
                    + "3. Pattern\n" 
                    + "4. Even or Odd\n"
                    + "5. Dashes in Rows\n" 
                    + "6. Grade\n"
                    + "7. Number to Weekly\n"
                    + "8. Leap Year\n"
                    + "9. Profile of User\n"
                    + "10. Vowel or Consonant\n"
                    + "----------------------------\n\n"
                    + "Enter your choice (1-10):";

        int choices = -1;
        boolean valid = false;

        while (!valid) {
            String input = JOptionPane.showInputDialog(menu);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.");
                return;
            }

            try {
                choices = Integer.parseInt(input);
                if (choices >= 1 && choices <= 10) {
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 10.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }

        switch (choices) {
            case 1:
                Dollar_Conversion.Dollar_Conversion();
                break;
            case 2:
                Multiplication_Table.Multiplication_Table();
                break;
            case 3:
                Pattern.Pattern();
                break;
            case 4:
                Even_or_Odd.Even_or_Odd();
                break;
            case 5:
                Dashes_in_Rows.Dashes_in_Rows();
                break;
            case 6:
                Grade.Grade();
                break;
            case 7:
                Number_to_Weekly.Number_to_Weekly();
                break;
            case 8:
                LeapYear.LeapYear();
                break;
            case 9:
                Profile_of_User.Profile_of_User();
                break;
            case 10:
                Vowel_or_Consonant.Vowel_or_Consonant();
                break;
        }
    }
}
