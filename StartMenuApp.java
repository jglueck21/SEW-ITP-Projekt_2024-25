public class StartMenuApp {
    public static void main(String[] args) {
        StartMenuModel model = new StartMenuModel();
        StartMenuView view = new StartMenuView();
        new StartMenuController(model, view);
    }
}
