package Main.View;

import Main.Human;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class MainWindow extends JDialog implements Runnable {
    private JButton signUpButton = new JButton("Ok");
    private JTextField nameTextField = new JTextField();
    private JLabel nameLabel = new JLabel("Input your name:");
    private List<ActionListener> actionListeners = new ArrayList<>();

    public JTextField getNameTextField() {
        return nameTextField;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private String name;

    public MainWindow() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(nameTextField)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(signUpButton, nameTextField, LayoutStyle.ComponentPlacement.INDENT, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                        .addComponent(signUpButton)
                                )
                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(nameLabel)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(signUpButton)
                        )
        );

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setName(nameTextField.getText());
                setVisible(false);
                dispose();
            }
        });
        setResizable(false);
        setPreferredSize(new Dimension(400, 115));
        setLocation(750, 400);
        setTitle("Sign up");
        setModal(true);
        pack();

    }


    @Override
    public void run() {
        setVisible(true);
    }

}
