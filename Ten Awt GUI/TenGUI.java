import java.awt.*;
import java.awt.event.*;

public class TenGUI extends Frame implements ActionListener {

    private final String[] options = {
        "1. Dollar Conversion", 
        "2. Multiplication Table", 
        "3. Pattern",
        "4. Even or Odd", 
        "5. Dashes in Rows", 
        "6. Grade",
        "7. Number to Weekly", 
        "8. Leap Year", 
        "9. Profile of User",
        "10. Vowel or Consonant"
    };

    public TenGUI() {
        setTitle("Menu Selection");
        setSize(300, 450);
        setLayout(null);
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        int x = 50, y = 40, width = 200, height = 30, gap = 10;

        for (int i = 0; i < options.length; i++) {
            Button btn = new Button(options[i]);
            btn.setBounds(x, y + (i * (height + gap)), width, height);
            btn.addActionListener(this);
            add(btn);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "1. Dollar Conversion":
                Dollar_Conversion.start();
                break;
            case "2. Multiplication Table":
                Multiplication_Table.start();
                break;
            case "3. Pattern":
                Pattern.start();
                break;
            case "4. Even or Odd":
                Even_or_Odd.start();
                break;
            case "5. Dashes in Rows":
                Dashes_in_Rows.start();
                break;
            case "6. Grade":
                Grade.start();
                break;
            case "7. Number to Weekly":
                Number_to_Weekly.start();
                break;
            case "8. Leap Year":
                LeapYear.start();
                break;
            case "9. Profile of User":
                Profile_of_User.start();
                break;
            case "10. Vowel or Consonant":
                Vowel_or_Consonant.start();
                break;
            default:
                MyDialog.ShowDialog(this, "Invalid", "Unknown choice");
        }
    }

    public static void main(String[] args) {
        new TenGUI().setVisible(true);
    }
}
