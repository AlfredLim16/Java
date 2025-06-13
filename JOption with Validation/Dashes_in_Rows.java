import javax.swing.JOptionPane;

/**
 *
 * @author Alfred Lim
 */

public class Dashes_in_Rows {

    public static void Dashes_in_Rows() {
        Integer rows = Input("Enter number of rows:", "Dashes in Rows", 1);
        if (rows == null) return;

        int[] dashes = new int[rows];

        for (int i = 0; i < rows; i++) {
            Integer dashCount = Input( "Enter number of dashes for Row " + (i + 1) + ":", "Row Input", 0);
            if (dashCount == null) return;
            dashes[i] = dashCount;
        }

        StringBuilder result = new StringBuilder("Dashes in Rows:\n");
        for (int rowCount : dashes) {
            for (int j = 0; j < rowCount; j++) {
                result.append("- ");
            }
            result.append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString(), "Output", JOptionPane.INFORMATION_MESSAGE);
    }

    private static Integer Input(String message, String title, int minAllowed) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operation cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }

            try {
                int value = Integer.parseInt(input);
                if (value < minAllowed) {
                    JOptionPane.showMessageDialog(null, "Please enter a number >= " + minAllowed + ".", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a whole number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
