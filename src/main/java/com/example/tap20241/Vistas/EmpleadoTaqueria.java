package com.example.tap20241.Vistas;

import com.example.tap20241.components.ButtonCell;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.example.tap20241.modelos.EmpleadosDAO;
import javafx.util.Callback;

public class EmpleadoTaqueria extends Stage {

    private VBox vbxPrincipal;
    private ToolBar tlbMenu;
    private  Button btnAgregarEmpleado;
    private Scene escena;
    private TableView<EmpleadosDAO> tbvEmpleados;
    public  EmpleadoTaqueria(){
        CrearUI();
        this.setTitle("Taqueria Los Inges :D");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI(){
        btnAgregarEmpleado = new Button();
        ImageView imvEmp = new ImageView(getClass().getResource("/images/Empleyee.png").toString());
        imvEmp.setFitWidth(50);
        imvEmp.setFitHeight(50);
        btnAgregarEmpleado.setOnAction(event -> new EmpleadosForm(tbvEmpleados, null));
        tlbMenu = new ToolBar(btnAgregarEmpleado);
        btnAgregarEmpleado.setGraphic(imvEmp);

        CreateTable();
        vbxPrincipal = new VBox(tlbMenu, tbvEmpleados);
        escena = new Scene(vbxPrincipal, 700, 400);
    }

    private void CreateTable(){
        EmpleadosDAO objEmpleado = new EmpleadosDAO();
        tbvEmpleados = new TableView<EmpleadosDAO>();
        TableColumn<EmpleadosDAO, String> tbcNombreEmp = new TableColumn<>("Empleado");
        tbcNombreEmp.setCellValueFactory(new PropertyValueFactory<>("nomEmpleado"));


        TableColumn<EmpleadosDAO, String> tbcRfcEmp = new TableColumn<>("RFC");
        tbcRfcEmp.setCellValueFactory(new PropertyValueFactory<>("rfcEmpleado"));

        TableColumn<EmpleadosDAO, Float> tbcSueldoEmp = new TableColumn<>("Sueldo");
        tbcSueldoEmp.setCellValueFactory(new PropertyValueFactory<>("salario"));

        TableColumn<EmpleadosDAO, String> tbcTelEmp = new TableColumn<>("Telefono");
        tbcTelEmp.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<EmpleadosDAO, String> tbcDirEmp = new TableColumn<>("Direccion");
        tbcDirEmp.setCellValueFactory(new PropertyValueFactory<>("direccion"));

        TableColumn<EmpleadosDAO,String> tbcEditar = new TableColumn<EmpleadosDAO,String>("EDITAR");
        TableColumn<EmpleadosDAO,String> tbcEliminar = new TableColumn<>("ELIMINAR");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<EmpleadosDAO, String>, TableCell<EmpleadosDAO, String>>() {
                    @Override
                    public TableCell<EmpleadosDAO, String> call(TableColumn<EmpleadosDAO, String> empleadosDAOStringTableColumn) {
                        return new ButtonCell(1);
                    }
                }
        );
        tbcEliminar.setCellFactory(
                new Callback<TableColumn<EmpleadosDAO, String>, TableCell<EmpleadosDAO, String>>() {
                    @Override
                    public TableCell<EmpleadosDAO, String> call(TableColumn<EmpleadosDAO, String> empleadosDAOStringTableColumn) {
                        return null;
                    }
                }

        );


        ///...
        tbvEmpleados.getColumns().addAll(tbcNombreEmp,tbcRfcEmp,tbcSueldoEmp,tbcTelEmp,tbcDirEmp,tbcEditar);
        tbvEmpleados.setItems(objEmpleado.CONSULTAR());

    }

}
