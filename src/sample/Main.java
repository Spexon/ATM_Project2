/**
 * @Author Vladimir Hardy
 * @TODO Make the ATM a GUI interface instead of console based
 */
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;


public class Main extends Application {

    /**
     * @param primaryStage
     * @throws Exception
     * @brief Gets styles from sample.fxml and prints hello World
     */
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    /**
     * @param args
     * @throws SQLException
     * @brief the main method for the ATM, calls other classes here
     */
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        //launch(args);
        Login lg = new Login();
        MainMenu mm = new MainMenu();
        boolean access = lg.userCredentials(input);
        if (access) {
            mm.displayOptions(input);
        }
        input.close();
    }
}