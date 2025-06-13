import java.awt.*;
import java.awt.event.*;

public class LeapYear extends Frame implements ActionListener {

    private TextField yearField;
    private Label resultLbl;

    public void Components() {
        setTitle("Leap Year");
        setSize(350, 200);
        setVisible(true);
        setLayout(new GridLayout(4, 1, 10, 5));
        setLocationRelativeTo(null);

        Panel inputPanel = new Panel();
        inputPanel.add(new Label("Enter a year:"));
        yearField = new TextField(15);
        inputPanel.add(yearField);
        add(inputPanel);

        Panel btnPanel = new Panel();
        Button checkBtn = new Button("Check");
        Button cancelBtn = new Button("Cancel");

        checkBtn.addActionListener(this);
        cancelBtn.addActionListener(e -> dispose());

        btnPanel.add(checkBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel);

        resultLbl = new Label("Result will be shown here.", Label.CENTER);
        add(resultLbl);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = yearField.getText().trim();

        try {
            int year = Integer.parseInt(input);
            if (year < 1) {
                MyDialog.ShowDialog(this,"Invalid Year", "Please enter a positive year.");
                return;
            }

            boolean isLeap = (year % 4 == 0);
            resultLbl.setText(year + (isLeap ? " is a leap year." : " is not a leap year."));

        } catch (NumberFormatException ex) {
            MyDialog.ShowDialog(this,"Invalid Input", "Please enter a valid whole number.");
        }
    }
    
    public static void start(){
        new LeapYear().Components();
    }
}
