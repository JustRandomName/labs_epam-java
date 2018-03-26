package sample.ves;

import sample.lic.Liquer;

/**
 * @author n.zhuchkevich
 * @version 1.0.0
 */
public class Vessel {
    private String taste = "";
    private String type = "";
    private Cup cup;
    private Bottle bottle;
    public Liquer liquer = new Liquer(type, taste);

    /**
     *
     * @param _type - type of liquer
     * @param _taste -taste for juise
     * @return cup with new liquer
     */
    public Cup puorOutLic(String _type, String _taste) {
        if (bottle.isItFull()) {
            taste = _taste;
            type = _type;
            emptyCup();
            initLicquer();
            return cup;
        } else {
            return null;
        }
    }

    /**
     *
     * @param flag - full or empty bottle
     */
    public void initBottle(boolean flag) {
        bottle = new Bottle();
        cup = new Cup();
        bottle.setItFull(flag);
    }

    /**
     *
     * @return cup with liquer
     */
    private Cup initLicquer() {
        cup.setFull(true);
        if (type.equals("Juise")) {
            cup.setLic(type + " " + taste);
        } else {
            cup.setLic(type);
        }
        return cup;
    }

    /**
     *
     * @return make cup empty
     */
    public String emptyCup() {
        cup.setFull(false);
        String str = cup.getLic();
        cup.setLic("");
        return str;
    }
}
