import java.awt.*;
import java.awt.event.*;

public class Even_or_Odd extends Frame implements ActionListener {

    private TextField numberField;
    private Label resultLabel;

    public void Components() {
        setTitle("Even or Odd");
        setSize(350, 200);
        setVisible(true);
        setLayout(new GridLayout(4, 1, 10, 5));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);

        Panel inputPanel = new Panel();
        inputPanel.add(new Label("Enter a number:"));
        numberField = new TextField(15);
        inputPanel.add(numberField);
        add(inputPanel);

        Panel btnPanel = new Panel();
        Button checkBtn = new Button("Check");
        Button cancelBtn = new Button("Cancel");

        checkBtn.addActionListener(this);
        cancelBtn.addActionListener(e -> {
        boolean confirm = MyDialog.ConfirmDialog(this,"Confirm", "Are you sure you want to cancel?");
            if (confirm) {
                dispose();
            }
        });

        btnPanel.add(checkBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel);

        resultLabel = new Label("Result will appear here. :)", Label.CENTER);
        add(resultLabel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = numberField.getText().trim();

        try {
            int num = Integer.parseInt(input);
            String result = (num % 2 == 0) ? "Number is Even" : "Number is Odd";
            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            MyDialog.ShowDialog(this,"Invalid Input", "Please enter a valid integer.");
        }
    }
    
    public static void start(){
        new Even_or_Odd().Components();
    }
}
