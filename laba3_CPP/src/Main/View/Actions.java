package Main.View;

import Main.Controllers.ActionController;
import Main.Human;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Actions extends JDialog implements Runnable {

    private JLabel jLabel = new JLabel("frkgfliur");
    private JButton justDoIt = new JButton("just do it!");
    private String[] actions = {"Drink", "Pour out", "Pour"};
    private String[] vessel = {"Cup", "Bottle", "Kettle"};
    private JComboBox vessels = new JComboBox(vessel);
    private JComboBox choiseAction = new JComboBox(actions);

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private String name;

    public Actions(Human human) {
        vessels.setEnabled(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(justDoIt)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(vessels)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(choiseAction, vessels, LayoutStyle.ComponentPlacement.INDENT, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                        .addComponent(choiseAction)

                                )
                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(justDoIt)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(vessels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(choiseAction)
                        )
        );

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        justDoIt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActionController actionController = new ActionController(choiseAction.getSelectedItem().toString(), vessels.getSelectedItem().toString(), human);
                if (!choiseAction.getSelectedItem().toString().equals("Pour out")) {
                    ShopView shopView = new ShopView(human);
                    shopView.run();
                    setVisible(false);
                    dispose();
                }
            }
        });
        choiseAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (choiseAction.getSelectedItem().toString().equals("Pour out")) {
                    vessels.setEnabled(true);
                } else {
                    vessels.setEnabled(false);
                }
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
