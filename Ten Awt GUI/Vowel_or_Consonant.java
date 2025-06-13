import java.awt.*;
import java.awt.event.*;

public class Vowel_or_Consonant extends Frame {

    private TextField inputField;
    private Label resultLbl;
    private Button checkBtn;

    private void Components() {
        setTitle("Vowel or Consonant");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        Label instruction = new Label("Enter a single letter:");
        instruction.setBounds(20, 55, 130, 20);
        instruction.setFont(new Font("Tahoma",0,14));

        inputField = new TextField();
        inputField.setBounds(160, 50, 100, 30);
        inputField.setFont(new Font("Tahoma",0,18));
        
        checkBtn = new Button("Check");
        checkBtn.setBounds(100, 100, 80, 30);

        resultLbl = new Label("", Label.CENTER);
        resultLbl.setBounds(50, 130, 300, 20);

        checkBtn.addActionListener(e -> Input());

        add(instruction);
        add(inputField);
        add(checkBtn);
        add(resultLbl);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void Input() {
        String input = inputField.getText().trim();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            resultLbl.setText("");
            MyDialog.ShowDialog(this, "Invalid Input", "Please enter a single letter.");
            return;
        }

        char ltr = Character.toLowerCase(input.charAt(0));
        boolean isVowel = ltr == 'a' || ltr == 'e' || ltr == 'i' || ltr == 'o' || ltr == 'u';

        resultLbl.setText("'" + input + "' is a " + (isVowel ? "Vowel" : "Consonant"));
    }

    public static void start(){
        new Vowel_or_Consonant().Components();
    }
}
