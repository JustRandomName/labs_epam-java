package Main.View;

import Main.Controllers.ShopController;
import Main.Human;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ShopView extends JDialog implements Runnable {

    private JButton buy = new JButton("Buy");
    private String[] strings = {"Tea", "Water", "Orange Juice", "Apple Juice", "Coffe"};
    private String[] vessel = {"Cup", "Bottle", "Kettle"};
    private JComboBox vessels = new JComboBox(vessel);
    private JComboBox choise_product = new JComboBox(strings);


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private String name;

    public ShopView(Human human) {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(buy)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(vessels)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(choise_product, vessels, LayoutStyle.ComponentPlacement.INDENT, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                        .addComponent(choise_product)
                                )
                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(buy)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(vessels, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(choise_product)
                        )
        );

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShopController shopController = new ShopController(choise_product.getSelectedItem().toString(), vessels.getSelectedItem().toString(), human);
                shopController.buy(choise_product.getSelectedItem().toString(), vessels.getSelectedItem().toString(), human);
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
