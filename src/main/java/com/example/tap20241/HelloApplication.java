package com.example.tap20241;

import com.example.tap20241.Vistas.Calculadora;
import com.example.tap20241.Vistas.EmpleadoTaqueria;
import com.example.tap20241.Vistas.Memorama;
import com.example.tap20241.Vistas.Pista;
import com.example.tap20241.components.Hilo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.example.tap20241.modelos.Conexion;

import java.io.IOException;

public class HelloApplication extends Application {
    private MenuBar principal;
    private Menu menParcial1, menParcial2, menSalir;
    private MenuItem mitCalculadora, mitSalir, mitMemorama, mitEmpleado, mitPista;

    private BorderPane bdpPanel;

    @Override
    public void start(Stage stage) throws IOException {
        CrearMenu();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        bdpPanel = new BorderPane();
        bdpPanel.setTop(principal);

        Scene scene = new Scene(bdpPanel);
        scene.getStylesheets().add(getClass().getResource("/Styles/main.css").toString());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);


        Conexion.crearConexion();

        //new Calculadora();
    }

    private void CrearMenu() {

        //Menu primer parcial
        mitCalculadora = new MenuItem("Calculadora");
        mitCalculadora.setOnAction((event)->new Calculadora());
        mitMemorama = new MenuItem("Memorama");
        mitMemorama.setOnAction((event)->new Memorama());
        mitEmpleado = new MenuItem("EmpleadoTaqueria");
        mitEmpleado.setOnAction((event) -> new EmpleadoTaqueria());


        menParcial1 = new Menu("Primer parcial");
        menParcial1.getItems().addAll(mitCalculadora, mitMemorama, mitEmpleado);




        //Segundo parcial
        menParcial2 = new Menu("Segundo parcial");
        mitPista = new MenuItem("Manejo de Hilos");
        mitPista.setOnAction(event -> new Pista());
        menParcial2.getItems().add(mitPista);

        //Menu salir
        mitSalir = new MenuItem("Salir");
        menSalir = new Menu("Salir");
        menSalir.getItems().add(mitSalir);
        mitSalir.setOnAction(actionEvent -> System.exit(0));

        principal = new MenuBar();
        principal.getMenus().addAll(menParcial1, menParcial2, menSalir);
    }

    public static void main(String[] args) {
        launch();
    }
}