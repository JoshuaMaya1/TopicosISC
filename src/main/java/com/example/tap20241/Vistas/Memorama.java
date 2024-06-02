package com.example.tap20241.Vistas;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Memorama extends Stage{
    private Scene escena;
    private VBox vContenedor;
    private VBox vPlayers;
    private GridPane gdrPane;
    private HBox hBox;
    private HBox hBoxScore1;
    private HBox hBoxScore2;
    private HBox hBox2;
    private TextField txt;
    private Button[][] arBotones = new Button[4][4];
    private Button boton;
    private char[] arrEtiquetas = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;

    public Memorama(){
        CrearUI();
        this.setTitle("Memorama ;)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI(){
        gdrPane = new GridPane();

        label1 = new Label("Numero de pares");
        txt = new TextField("0");
        boton = new Button("Iniciar Juego");
        label2 = new Label("time 00:00");
        hBox = new HBox(label1,txt,boton,label2);


        label4 = new Label("Jugador 1:");
        label3 = new Label("0");
        hBoxScore1 = new HBox(label4, label3);


        label5 = new Label("Jugador 2:");
        label6 = new Label("0");
        hBoxScore2 = new HBox(label5, label6);

        vPlayers = new VBox(hBoxScore1, hBoxScore2);
        CrearCartas();
        //RevolverCartas();
        hBox2 = new HBox(gdrPane, vPlayers);

        vContenedor = new VBox(hBox, hBox2);

        escena = new Scene(vContenedor, 400, 300);
    }
    
    private void CrearCartas(){
        int pos = 0;
        char simbolo;
        for (int i = 0; i<4 ; i++){
            for(int j = 0; j < 4; j++){
                arBotones[i][j] = new Button(arrEtiquetas[pos]+"");
                arBotones[i][j].setPrefSize(50,50);
                int finalPos = pos;
                arBotones[i][j].setOnAction(event -> setValue(arrEtiquetas[finalPos]));
                gdrPane.add(arBotones[i][j],j,i);
                pos++;
            }
        }
        
    }

    private void setValue(char arrEtiqueta) {
    }

    public void RevolverCartas(){
        String[] arImagenes = {"Numero1.PNG","Numero2.PNG","Numero3.PNG","Numero4.PNG"};
        gdrPane = new GridPane();
        Image[][] arCartas = new Image[2][4];
        Button[][] arBtnCartas = new Button[2][4];

        ImageView imvCarta;
        int posx = 0;
        int posy = 0;
        int cont = 0;
        for(int i = 0; i<arImagenes.length; ){
            posx =(int) (Math.random()*2);
            posy =(int) (Math.random()*4);
            if (arBtnCartas[posx][posy] == null){
                arBtnCartas[posx][posy] = new Button();
                imvCarta = new ImageView(getClass().getResource("/images/"+arImagenes[i]).toString());
                imvCarta.setFitHeight(150);
                imvCarta.setFitWidth(100);
                arBtnCartas[posx][posy].setGraphic(imvCarta);
                arBtnCartas[posx][posy].setPrefSize(100, 150);
                gdrPane.add(arBotones[posx][posy],posy, posx);
                cont++;
                if(cont == 2) {
                    i++;
                    cont = 0;
                }
                }
            }


        }

    }





