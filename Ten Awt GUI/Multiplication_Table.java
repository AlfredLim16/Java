import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Alfred Lim
 */

public class Multiplication_Table extends Frame implements ActionListener {

    private TextField inputField;
    private TextArea resultArea;
    private Button createBtn, cancelBtn;

    public void Components() {
        setTitle("Multiplication Table");
        setSize(500, 450);
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        setLayout(new BorderLayout(10, 10));

        Panel inputPanel = new Panel();
        inputPanel.setLayout(new FlowLayout());

        inputPanel.add(new Label("Enter a number:"));
        inputField = new TextField(10);
        inputPanel.add(inputField);

        createBtn = new Button("Create");
        createBtn.addActionListener(this);
        inputPanel.add(createBtn);

        cancelBtn = new Button("Cancel");
        cancelBtn.addActionListener(e -> {
            boolean confirm = MyDialog.ConfirmDialog(this,"Confirm", "Are you sure you want to cancel?");
            if (confirm) {
                dispose();
            }
        });
        inputPanel.add(cancelBtn);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new TextArea();
        resultArea.setEditable(false);
        add(resultArea, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });     
    }
       
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText().trim();

        if (input.isEmpty()) {
            MyDialog.ShowDialog(this,"Invalid Input", "Please enter a number.");
            return;
        }

        try {
            int num = Integer.parseInt(input);
            if (num <= 0) {
                MyDialog.ShowDialog(this,"Invalid Input", "Please enter a positive number.");
                return;
            }

            StringBuilder table = new StringBuilder("Multiplication Table for " + num + ":\n\n");
            for (int i = 1; i <= num; i++) {
                table.append(num).append(" x ").append(i).append(" = ").append(num * i).append("\n");
            }
            resultArea.setText(table.toString());

        } catch (NumberFormatException ex) {
            MyDialog.ShowDialog(this,"Error", "Invalid input. Please enter a valid whole number.");
        }
    }
    
    public static void start() {
        new Multiplication_Table().Components();
    }
}
