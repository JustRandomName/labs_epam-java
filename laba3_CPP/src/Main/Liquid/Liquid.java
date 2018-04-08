package Main.Liquid;

/**
 * @version 1.0.0
 * @author n.zhuchvech
 *  class for all type of liquer
 */
public class Liquid {
    /**
     * create needed class of liquer
     * @param liq type of liquer
     * @param taste it's taste  of juise
     * @return needed type of liquer
     */
    public static Liquid initLiq(String liq, String taste) {
        switch (liq) {
            case "Tea":
                return new Tea();
            case "Coffe":
                return new Coffe();
            case "Juice":
                return new Juise(taste);
            case "Water":
                return new Water();
            default:
                return null;
        }
    }
}
