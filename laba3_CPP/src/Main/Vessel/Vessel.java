package Main.Vessel;

import Main.Liquid.Liquid;

/**
 * @author n.zhuchkevich
 * class of all typrs of vessels
 * @version 1.0.0
 */

public abstract class Vessel {

    private Cup cup;
    private Bottle bottle;
    private Kettle kettle;
    private boolean full;

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    /**
     * @param type - type of needed vessel
     * @return needed vessel
     */
    public Vessel initVess(String type) {
        switch (type) {
            case "Cup":
                return new Cup();
            case "Bottle":
                return new Bottle();
            case "Kettle":
                return new Kettle();
            default:
                return null;
        }
    }

    /**
     * @param vessel - previus vessel
     * @param nextVessel - new vessel
     */
    public void puorOutLic(Liquid liquid, Vessel vessel,
                           String taste, String nextVessel) {
        vessel.setFull(false);
        vessel = initVess(nextVessel);
        vessel.setFull(true);
    }
}
