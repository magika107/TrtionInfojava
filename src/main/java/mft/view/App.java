package mft.view;

import lombok.extern.log4j.Log4j2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Log4j2

public class App extends Application {
    public void start(Stage primaryStage) throws Exception {
        try {
            Scene scene = new Scene(FXMLLoader
                    .load(getClass().getResource("/TransactionInfoView.fxml")));
            primaryStage.setScene(scene);
            primaryStage.setTitle("Financialdocument");
            log.info("App Started");
            primaryStage.show();
        } catch (Exception e) {
            log.error("Start App" + e.getMessage());
        }

    }
}



