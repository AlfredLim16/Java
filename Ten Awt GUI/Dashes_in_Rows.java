import java.awt.*;
import java.awt.event.*;

public class Dashes_in_Rows extends Frame {
    private TextArea outputArea;
    private Button startBtn, cancelBtn;

    public void Components() {
        setTitle("Dashes in Rows");
        setSize(500, 400);
        setVisible(true);
        setLayout(new BorderLayout(10, 15));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);

        Label heading = new Label("Dashes in Rows", Label.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        add(heading, BorderLayout.NORTH);

        outputArea = new TextArea();
        outputArea.setEditable(false);
        add(outputArea, BorderLayout.CENTER);

        Panel bottomPanel = new Panel(new FlowLayout());
        startBtn = new Button("Start");
        cancelBtn = new Button("Cancel");
        bottomPanel.add(startBtn);
        bottomPanel.add(cancelBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        startBtn.addActionListener(e -> Input());
        cancelBtn.addActionListener(e -> {
            boolean confirm = MyDialog.ConfirmDialog(this,"Confirm", "Are you sure you want to cancel?");
            if (confirm) {
                dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    private void Input() {
        int totalRows = promptForInteger("Enter number of rows:");
        if (totalRows <= 0) return;

        int[] dashes = new int[totalRows];

        for (int i = 0; i < totalRows; i++) {
            int dashCount = promptForInteger("Enter number of dashes for Row " + (i + 1) + ":");
            if (dashCount < 0) return;
            dashes[i] = dashCount;
        }

        StringBuilder result = new StringBuilder("Dashes in Rows:\n");
        for (int row : dashes) {
            for (int i = 0; i < row; i++) {
                result.append("- ");
            }
            result.append("\n");
        }

        outputArea.setText(result.toString());
    }

    private int promptForInteger(String message) {
        while (true) {
            Dialog dialog = new Dialog(this, "Input", true);
            dialog.setLayout(new FlowLayout());
            dialog.setSize(300, 120);

            Label label = new Label(message);
            TextField inputField = new TextField(10);
            Button okBtn = new Button("OK");
            cancelBtn = new Button("Cancel");

            final int[] result = {-1};

            okBtn.addActionListener(e -> {
                try {
                    result[0] = Integer.parseInt(inputField.getText().trim());
                    dialog.dispose();
                } catch (NumberFormatException ex) {
                    MyDialog.ShowDialog(this,"Invalid Input","Please enter a valid whole number.");
                }
            });

            cancelBtn.addActionListener(e -> {
                result[0] = -1;
                dialog.dispose();
            });

            dialog.add(label);
            dialog.add(inputField);
            dialog.add(okBtn);
            dialog.add(cancelBtn);

            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);

            return result[0];
        }
    }

    public static void start(){
        new Dashes_in_Rows().Components();
    }
}
