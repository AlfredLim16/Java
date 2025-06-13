import java.awt.*;
import java.awt.event.*;

public class Number_to_Weekly extends Frame {

    private TextField inputField;
    private Label resultLabel;

    private void Components() {
        setTitle("Number to Weekly");
        setSize(400, 250);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        Label title = new Label("Enter a number (1-7):");
        title.setBounds(50, 50, 300, 20);

        inputField = new TextField();
        inputField.setBounds(50, 80, 300, 25);

        Button convertBtn = new Button("Convert");
        convertBtn.setBounds(150, 115, 100, 30);

        resultLabel = new Label("", Label.CENTER);
        resultLabel.setBounds(50, 160, 300, 20);

        add(title);
        add(inputField);
        add(convertBtn);
        add(resultLabel);

        convertBtn.addActionListener(e -> processInput());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    private void processInput() {
        String input = inputField.getText().trim();

        if (input.isEmpty()) {
            MyDialog.ShowDialog(this,"Invalid Input","Invalid Input cannot be Empty");
            return;
        }

        try {
            int number = Integer.parseInt(input);
            if (number < 1 || number > 7) {
                MyDialog.ShowDialog(this,"Invalid Input","Please enter a number between 1 and 7.");
                return;
            }

            String day;
            switch (number) {
                case 1: day = "Monday"; break;
                case 2: day = "Tuesday"; break;
                case 3: day = "Wednesday"; break;
                case 4: day = "Thursday"; break;
                case 5: day = "Friday"; break;
                case 6: day = "Saturday"; break;
                case 7: day = "Sunday"; break;
                default: day = "Invalid";
            }

            resultLabel.setText("Day: " + day);
        } catch (NumberFormatException e) {
            MyDialog.ShowDialog(this,"Invalid input", "Please enter a whole number.");
        }
    }
    
    public static void start(){
        new Number_to_Weekly().Components();
    }
}
