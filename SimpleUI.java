import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SimpleUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Botones en la parte superior
        Button btnPrev = new Button("<=");
        Button btnNext = new Button(">=");
        Button btnHome = new Button("Limpiar");
        Button btnSearch = new Button("Buscar");
        
        HBox buttonBox = new HBox(10, btnPrev, btnNext, btnHome, btnSearch);
        buttonBox.setStyle("-fx-padding: 10; -fx-alignment: center;");
        
        // Línea de entrada
        TextField inputField = new TextField();
        inputField.setPromptText("(Entrada)");
        
        // Área de salida
        TextArea outputArea = new TextArea();
        outputArea.setPromptText("(Salida)");
        outputArea.setPrefHeight(300);
        
        // Acción del botón Search
        btnSearch.setOnAction(e -> {
            String inputText = inputField.getText();
            if (!inputText.isEmpty()) {
                outputArea.appendText("Buscando: " + inputText + "...\n");
            }
        });
        
        // Acción del botón Home
        btnHome.setOnAction(e -> {
            inputField.clear();
            outputArea.clear();
        });
        
        // Organizar la interfaz
        VBox root = new VBox(10, buttonBox, inputField, outputArea);
        root.setStyle("-fx-padding: 10;");
        
        // Configurar escena y mostrar
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Interfaz de ejemplo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
