package Main.Controllers;

import Main.Human;
import Main.Liquid.Liquid;
import Main.Shop;
import Main.Vessel.Bottle;
import Main.Vessel.Vessel;
import Main.View.Actions;

/**
 * @author n.zhuchkevich
 * @version 1.0.0
 * controller for shop view
 */

public class ShopController {
    private Vessel vessel = new Bottle();
    private Liquid liquid = new Liquid();

    /**
     *
     * @param lic - what type of licquer you buy
     * @param vess - in what vessel
     * @param human - who buy
     */
    public ShopController(String lic, String vess, Human human) {
        Shop shop = new Shop();
        shop.setBuyer(human.getName());
        shop.getOutLiquid(lic, initString(lic));
        Actions actions = new Actions(human);
        actions.run();
    }

    /**
     *
     * @param lic - type licquer
     * @param vess - type vessel
     * @param human - who buy
     */
    public void buy(String lic, String vess, Human human) {
        human.buy();
        human.setProduct(lic);
        human.setJuiseTaste(initString(lic));
        human.setPrevBottle(vess);
    }

    /**
     * try to find type of juice
     * @param s - string from combo box
     * @return type of juice
     */
    private String initString(String s){
        if (s.contains("Orange")) {
            return "Orange";
        }
        if (s.contains("Apple")){
            return "Apple";
        }
        return "";
    }
}
