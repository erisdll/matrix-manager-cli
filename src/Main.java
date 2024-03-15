import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        MatrixManager matrixManager = new MatrixManager();
        MainMenuHandler mainMenuHandler = new MainMenuHandler(matrixManager, scanner);
        mainMenuHandler.startMainMenu();
        scanner.close();
    }
}