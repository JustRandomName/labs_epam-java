package Main;

import Main.Liquid.*;

public class Shop {
    private String buyer;

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Liquid getOutLiquid(String liq, String taste){
        return Liquid.initLiq(liq, taste);
    }
}
