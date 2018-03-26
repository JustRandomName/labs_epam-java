package sample.lic;

/**
 * @author n.zhuchkevich
 * @version 1.0.0
 * base class
 * */

public class Liquer {
    private Juise juise;
    private Water water;
    private boolean flag = false;
    /**
     * @param s - type of liquer, String taste - for juise
    * */
    public Liquer(String s, String taste) {
        if (s.equals("juise")) {
            juise = new Juise(taste);
            flag = true;
        } else {
            water = new Water();
            flag = false;
        }
    }

    public Juise getJuise() {
        return juise;
    }

    public Water getWater() {
        return water;
    }

}
