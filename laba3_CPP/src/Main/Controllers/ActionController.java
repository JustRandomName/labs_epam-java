package Main.Controllers;

import Main.Human;

/**
 * @author n.zhuchkevich
 * @version 1.0.0
 * controller for work with human
 */
public class ActionController {
    /**
     *
     * @param action what you wont to do
     * @param vesselNext - for pour out new vessel
     * @param human - who do actions
     */
    public ActionController(String action, String vesselNext,Human human) {
        switch (action) {
            case "Drink" :  human.drink();
                break;
            case "Pour out" : human.pour(human.getVessel(), vesselNext);
                break;
            case "Pour" : human.empty();
                break;
            default: break;
        }
    }
}
