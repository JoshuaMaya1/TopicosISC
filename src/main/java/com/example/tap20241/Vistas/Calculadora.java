package com.example.tap20241.Vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage{

    private Scene escena;
    private VBox vContenedor;
    private GridPane grindPane;
    private TextField txtPantalla;
    private Button[][] arBotones = new Button[4][4];

    private char[] arrEtiquetas = {'7','8','9','/','4','5','6','*','1','2','3','-','0','.',',','=','+'};


    public Calculadora(){
        CrearUI();
        this.setTitle("Mi primer calculadora :D");
        this.setScene(escena);
        this.show();

    }

    private void CrearUI(){
        txtPantalla = new TextField("0");
        grindPane = new GridPane();
        CrearTeclado();
        vContenedor = new VBox(txtPantalla,grindPane);
        vContenedor.setSpacing(5);

        escena = new Scene (vContenedor, 200, 200);
    }

    private void CrearTeclado(){
        int pos = 0;
        char simbolo;
        for (int i = 0; i<4 ; i++){
            for(int j = 0; j < 4; j++){
                arBotones[i][j] = new Button(arrEtiquetas[pos]+"");
                arBotones[i][j].setPrefSize(50,50);
                int finalPos = pos;
                arBotones[i][j].setOnAction(event -> setValue(arrEtiquetas[finalPos]));
                grindPane.add(arBotones[i][j],j,i);
                pos++;
            }
        }
    }

    private  void setValue(char simbolo){
        txtPantalla.appendText(simbolo+"");
    }
}
//manejadores de eventos o laminas, buscar manejadores de eventos lambdas