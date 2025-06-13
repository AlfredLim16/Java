import java.awt.*;
import java.awt.event.*;

public class MyDialog {

    public static void ShowDialog(Frame parent, String title, String message) {
        Dialog dialog = new Dialog(parent, title, true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 120);

        Point location = parent.getLocation();
        Dimension parentSize = parent.getSize();
        Dimension dialogSize = dialog.getSize();

        dialog.setLocation(
            location.x + (parentSize.width - dialogSize.width) / 2,
            location.y + (parentSize.height - dialogSize.height) / 2
        );

        Label msg = new Label(message, Label.CENTER);
        dialog.add(msg, BorderLayout.CENTER);

        Button okButton = new Button("OK");
        okButton.addActionListener(e -> dialog.dispose());

        Panel buttonPanel = new Panel();
        buttonPanel.add(okButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
    }
    
    static boolean ConfirmDialog(Frame parent, String title, String message) {
        final boolean[] result = new boolean[1];
        Dialog dialog = new Dialog(parent, title, true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 130);

        Point location = parent.getLocation();
        Dimension parentSize = parent.getSize();
        Dimension dialogSize = dialog.getSize();

        dialog.setLocation(
            location.x + (parentSize.width - dialogSize.width) / 2,
            location.y + (parentSize.height - dialogSize.height) / 2
        );

        Label msg = new Label(message, Label.CENTER);
        dialog.add(msg, BorderLayout.CENTER);

        Panel buttonPanel = new Panel();

        Button yesButton = new Button("Yes");
        yesButton.addActionListener(e -> {
            result[0] = true;
            dialog.dispose();
        });
        buttonPanel.add(yesButton);

        Button noButton = new Button("No");
        noButton.addActionListener(e -> {
            result[0] = false;
            dialog.dispose();
        });
        buttonPanel.add(noButton);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);

        return result[0];
    }
}
