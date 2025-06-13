
import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class LeapYear {
    public static void LeapYear(){
        
        int year = input("Enter a year: ");
        
        if (isLeapYear(year)) {
            JOptionPane.showMessageDialog(null, year + " is a leap year.");
        } else {
            JOptionPane.showMessageDialog(null, year + " is not a leap year.");
        }
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0);
    }
    
    private static int input(String message){
        int value = -1;
        boolean valid = false;
        
        while(!valid){
            String input = JOptionPane.showInputDialog(message);
            
            if(input == null){
                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    System.exit(0);           
                }else continue;
            }
            
            input = input.trim();
            
            if(input.isEmpty()){
                JOptionPane.showMessageDialog(null, "Input cannot be empty.", "Warning!", JOptionPane.WARNING_MESSAGE);
                continue;
            }
            
            try {
                value = Integer.parseInt(input);
                if (value < 1) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive year.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else {
                    valid = true;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter a valid whole number.", "Exception!", JOptionPane.WARNING_MESSAGE);
            }
        }
        return value;
    }
}
