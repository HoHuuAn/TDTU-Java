package  com.MainComponet ; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomFrameExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Main Frame");
        JButton openButton = new JButton("Open Custom Frame");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomFrame(frame);
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(openButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void openCustomFrame(JFrame parentFrame) {
        JFrame customFrame = new JFrame("Custom Frame");
        JTextField textField = new JTextField(10);
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Process the entered value (you can do something with it)
                String enteredValue = textField.getText();
                System.out.println("Entered value: " + enteredValue);

                // Close the custom frame
                customFrame.dispose();

                // Set focus back to the parent frame
                parentFrame.requestFocus();
            }
        });

        customFrame.setLayout(new FlowLayout());
        customFrame.add(new JLabel("Enter a value: "));
        customFrame.add(textField);
        customFrame.add(okButton);

        customFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        customFrame.setSize(300, 150);
        customFrame.setLocationRelativeTo(parentFrame);
        customFrame.setVisible(true);

        // Set focus to the text field when the custom frame is opened
        textField.requestFocus();
    }
}
