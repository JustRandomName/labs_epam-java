package Main;

import Main.View.MainWindow;
import Main.View.ShopView;

public class Main {
    private static Human human;
    public static void main(String[] args){
        MainWindow mainWindow = new MainWindow();
        mainWindow.run();
        human = new Human(mainWindow.getName());
        ShopView shopView = new ShopView(human);
        shopView.run();

    }
}
