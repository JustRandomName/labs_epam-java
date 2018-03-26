package sample;

import sample.ves.Cup;
import sample.ves.Vessel;

/**
 * @author n.zhuchkevich
 * @version 1.0.0
 */

public class Human {
    private String name;
    private Vessel vessel = new Vessel();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cup pour(String type, String taste) {
        return vessel.puorOutLic(type, taste);
    }

    public String drinkLiq() {
        return vessel.emptyCup();
    }

    public void initBottle() {
        vessel.initBottle(true);
    }
}
