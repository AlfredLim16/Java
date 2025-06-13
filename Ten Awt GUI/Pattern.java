import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Alfred Lim
 */

public class Pattern extends Frame implements ActionListener {

    private Choice choice;
    private TextField rowInput;
    private TextArea outputArea;
    private Button createBtn, cancelBtn;

    public void Components() {
        setTitle("Pattern");
        setSize(450, 450);
        setLayout(new BorderLayout(10, 10));
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);

        Panel panel = new Panel(new GridLayout(2, 2, 5, 5));
        choice = new Choice();
        choice.add("Right Triangle");
        choice.add("Inverted Triangle");
        choice.add("Pyramid");
        choice.add("Diamond");
        choice.add("Square");
        choice.add("Hollow Square");
        choice.add("X Pattern");
        choice.add("Checkerboard");

        panel.add(new Label("Select Pattern:"));
        panel.add(choice);
        panel.add(new Label("Enter rows (1-20):"));
        rowInput = new TextField();
        panel.add(rowInput);

        add(panel, BorderLayout.NORTH);

        outputArea = new TextArea();
        outputArea.setEditable(false);
        add(outputArea, BorderLayout.CENTER);

        Panel btnPanel = new Panel();
        createBtn = new Button("Create");
        cancelBtn = new Button("Cancel");
        createBtn.addActionListener(this);
        cancelBtn.addActionListener(e -> {
            if (MyDialog.ConfirmDialog(this,"Confirm", "Are you sure you want to cancel?")) {
                dispose();
            }
        });
        btnPanel.add(createBtn);
        btnPanel.add(cancelBtn);

        add(btnPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = choice.getSelectedItem();
        String input = rowInput.getText().trim();

        try {
            int rows = Integer.parseInt(input);
            if (rows < 1 || rows > 20) {
                MyDialog.ShowDialog(this,"Invalid Input", "Please enter a number from 1 to 20.");
                return;
            }

            String result;
    switch (selected) {
        case "Right Triangle":
            result = rightTriangle(rows);
            break;
        case "Inverted Triangle":
            result = invertedTriangle(rows);
            break;
        case "Pyramid":
            result = pyramid(rows);
            break;
        case "Diamond":
            result = diamond(rows);
            break;
        case "Square":
            result = square(rows);
            break;
        case "Hollow Square":
            result = hollowSquare(rows);
            break;
        case "X Pattern":
            result = xPattern(rows);
            break;
        case "Checkerboard":
            result = checkerboard(rows);
            break;
        default:
            result = "Invalid pattern.";
        }   
            outputArea.setText(result);

        } catch (NumberFormatException ex) {
            MyDialog.ShowDialog(this,"Error", "Please enter a valid whole number.");
        }
    }

    private static String repeat(String s, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private String rightTriangle(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) sb.append(repeat("*", i)).append("\n");
        return sb.toString();
    }

    private String invertedTriangle(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = rows; i >= 1; i--) sb.append(repeat("*", i)).append("\n");
        return sb.toString();
    }

    private String pyramid(int rows) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            sb.append(repeat(" ", rows - i)).append(repeat("*", 2 * i - 1)).append("\n");
        }
        return sb.toString();
    }

    private String diamond(int rows) {
        StringBuilder sb = new StringBuilder(pyramid(rows));
        for (int i = rows - 1; i >= 1; i--) {
            sb.append(repeat(" ", rows - i)).append(repeat("*", 2 * i - 1)).append("\n");
        }
        return sb.toString();
    }

    private String square(int size) {
        return repeat(repeat("*", size) + "\n", size);
    }

    private String hollowSquare(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) sb.append(repeat("*", size));
            else sb.append("*").append(repeat(" ", size - 2)).append("*");
            sb.append("\n");
        }
        return sb.toString();
    }

    private String xPattern(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append((i == j || j == (size - i - 1)) ? "*" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private String checkerboard(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(((i + j) % 2 == 0) ? "*" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static void start() {
        new Pattern().Components();
    }
}