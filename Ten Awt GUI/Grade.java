import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Alfred Lim
 */

public class Grade extends Frame implements ActionListener {

    private TextField prelimField, midtermField, finalField;
    private Label resultLabel;

    public void Components() {
        setTitle("Grade");
        setSize(400, 300);
        setLayout(new GridLayout(5, 1, 5, 5));
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        
        Panel prelimPanel = new Panel();
        prelimPanel.add(new Label("Enter Prelim:"));
        prelimField = new TextField(10);
        prelimPanel.add(prelimField);
        
        Panel midtermPanel = new Panel();
        midtermPanel.add(new Label("Enter Midterm:"));
        midtermField = new TextField(10);
        midtermPanel.add(midtermField);
        
        Panel finalPanel = new Panel();
        finalPanel.add(new Label("Enter Final:"));
        finalField = new TextField(10);
        finalPanel.add(finalField);
        

        Panel buttonPanel = new Panel();
        Button computeBtn = new Button("Compute Average");
        computeBtn.addActionListener(this);
        buttonPanel.add(computeBtn);

        Button cancelBtn = new Button("Cancel");
        cancelBtn.addActionListener(e -> {
            boolean confirm = MyDialog.ConfirmDialog(this,"Confirm", "Are you sure you want to cancel?");
            if (confirm) {
                dispose();
            }
        });
        buttonPanel.add(cancelBtn);
        
        add(prelimPanel);
        add(midtermPanel);
        add(finalPanel);
        add(buttonPanel);

        resultLabel = new Label("Your average will appear here.", Label.CENTER);
        add(resultLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double prelim = Input(prelimField.getText(), "Prelim");
            double midterm = Input(midtermField.getText(), "Midterm");
            double fin = Input(finalField.getText(), "Final");

            double average = (prelim + midterm + fin) / 3;
            resultLabel.setText(String.format("Your average grade is: %.2f", average));

        } catch (IllegalArgumentException ex) {
            MyDialog.ShowDialog(this,"Invalid Input", ex.getMessage());
        }
    }

    private double Input(String input, String fieldName) {
        input = input.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " field cannot be empty.");
        }
        
        try {
            double grade = Double.parseDouble(input);
            if (grade < 70 || grade > 100) {
                throw new IllegalArgumentException(fieldName + " must be between 70 and 100.");
            }
            return grade;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid number.");
        }
    }
    
    public static void start(){
        new Grade().Components();
    }
}
