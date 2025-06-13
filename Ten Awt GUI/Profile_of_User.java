import java.awt.*;
import java.awt.event.*;

public class Profile_of_User extends Frame {

    private TextField nameField, ageField, weightField;
    private CheckboxGroup genderGroup;
    private Checkbox maleOption, femaleOption;
    private Button submitBtn;

    private void Components() {
        setTitle("User Profile");
        setSize(400, 300);
        setLayout(null);
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        
        Label nameLbl = new Label("Name:");
        nameLbl.setBounds(50, 50, 80, 20);
        nameField = new TextField();
        nameField.setBounds(150, 50, 180, 30);

        Label ageLbl = new Label("Age:");
        ageLbl.setBounds(50, 90, 80, 20);
        ageField = new TextField();
        ageField.setBounds(150, 90, 180, 30);

        Label weightLbl = new Label("Weight (kg):");
        weightLbl.setBounds(50, 130, 80, 20);
        weightField = new TextField();
        weightField.setBounds(150, 130, 180, 30);

        Label genderLbl = new Label("Gender (M/F):");
        genderLbl.setBounds(50, 165, 100, 20);
        
        genderGroup = new CheckboxGroup();
        maleOption = new Checkbox("Male", genderGroup, false);
        maleOption.setBounds(150, 160, 60, 30);
        femaleOption = new Checkbox("Female", genderGroup, false);
        femaleOption.setBounds(220, 160, 60, 30);

        submitBtn = new Button("Submit");
        submitBtn.setBounds(150, 200, 80, 30);
        submitBtn.addActionListener(e -> Submit());

        add(nameLbl); add(nameField);
        add(ageLbl); add(ageField);
        add(weightLbl); add(weightField);
        add(genderLbl); add(maleOption); add(femaleOption);
        add(submitBtn);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    private void Submit() {
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String weightText = weightField.getText().trim();
        Checkbox selectedGender = genderGroup.getSelectedCheckbox();

        
        if (name.isEmpty()) {
            MyDialog.ShowDialog(this, "Input Error", "Name cannot be empty.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0) {
                MyDialog.ShowDialog(this, "Invalid Input", "Age must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            MyDialog.ShowDialog(this, "Format Error", "Please enter a valid whole number for age.");
            return;
        }

        double weight;
        try {
            weight = Double.parseDouble(weightText);
            if (weight <= 0) {
                MyDialog.ShowDialog(this, "Invalid Input", "Weight must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            MyDialog.ShowDialog(this, "Format Error", "Please enter a valid number for weight.");
            return;
        }

        if (selectedGender == null) {
            MyDialog.ShowDialog(this, "Missing Input", "Please select a gender.");
            return;
        }

        String summary = "Name: " + name + "\nAge: " + age + "\nWeight: " + weight + " kg" + "\nGender: " + selectedGender;
        MyDialog.ShowDialog(this, "User Profile Summary", summary);
    }

    public static void start(){
        new Profile_of_User().Components();
    }
}
