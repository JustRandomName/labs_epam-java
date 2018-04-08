package Main;

import Main.Liquid.Liquid;
import Main.Vessel.Bottle;
import Main.Vessel.Vessel;

/**
 * who buy)
 * include main method to work with shop and liquet
 * @author n.zhuchkevich
 * @version 1.0.0
 */
public class Human {
    private String name;
    private String product;
    private String juiseTaste;

    private String prevBottle;
    private Liquid liquid = new Liquid();
    private Shop shop = new Shop();

    public Vessel getVessel() {
        return vessel;
    }

    private Vessel vessel = new Bottle();

    public String getPrevBottle() {
        return prevBottle;
    }

    public void setPrevBottle(String prevBottle) {
        this.prevBottle = prevBottle;
    }

    public String getName() {
        return name;
    }

    public Human(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void pour(Vessel vessel, String nextVessel) {
        vessel.puorOutLic(liquid, vessel, juiseTaste, nextVessel);
    }

    public void drink() {
        vessel.setFull(false);
    }

    public String getJuiseTaste() {
        return juiseTaste;
    }

    public void setJuiseTaste(String juiseTaste) {
        this.juiseTaste = juiseTaste;
    }

    /**
     *  get licquid from shop
     */
    public void buy() {
        shop.setBuyer(name);
        liquid = shop.getOutLiquid(product, juiseTaste);
        vessel = vessel.initVess(prevBottle);
    }

    public void empty() {
        vessel = null;
        liquid = null;
        setJuiseTaste("");
    }
}
