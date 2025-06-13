import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Alfred Lim
 */

public class Dollar_Conversion extends Frame implements ActionListener {

    private TextField pesoField;
    private Label resultLabel;

    private static final double CONVERSION_RATE = 56;

    public void Components() {
        setTitle("Dollar Conversion");
        setSize(350, 200);
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        setLayout(new GridLayout(4, 1, 10, 5));

        Panel inputPanel = new Panel();
        inputPanel.add(new Label("Enter amount in Peso:"));
        pesoField = new TextField(15);
        inputPanel.add(pesoField);
        add(inputPanel);

        Button convertBtn = new Button("Convert");
        convertBtn.addActionListener(this);
        Panel btnPanel = new Panel();
        btnPanel.add(convertBtn);
        add(btnPanel);

        resultLabel = new Label("Equivalent in Dollar: ");
        resultLabel.setAlignment(Label.CENTER);
        add(resultLabel);

        Button cancelBtn = new Button("Cancel");
        cancelBtn.addActionListener(e -> {
        boolean confirm = MyDialog.ConfirmDialog(this,"Confirm", "Are you sure you want to cancel?");
            if (confirm) {
                dispose();
            }
        });

        Panel cancelPanel = new Panel();
        cancelPanel.add(cancelBtn);
        add(cancelPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = pesoField.getText().trim();
        double pesoAmt;

        try {
            pesoAmt = Double.parseDouble(input);
            if (pesoAmt < 0) {
                MyDialog.ShowDialog(this,"Invalid Input", "Please enter a non-negative value.");
                return;
            }

            double dollarAmt = pesoAmt * CONVERSION_RATE;
            resultLabel.setText(String.format("Equivalent in Dollar: $%.2f", dollarAmt));

        } catch (NumberFormatException ex) {
            MyDialog.ShowDialog(this,"Error", "Invalid input. Please enter a valid number.");
        }
    }
    
    public static void start() {
        new Dollar_Conversion().Components();
    }
}
