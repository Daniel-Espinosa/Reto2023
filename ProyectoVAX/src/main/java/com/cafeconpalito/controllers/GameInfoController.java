/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author produccion
 */
public class GameInfoController extends HBox {

    @FXML
    private Label infoGameTitle;
    @FXML
    private ImageView infoGameImage;
    @FXML
    private Label infoGameDownloads;
    @FXML
    private Label infoGamePrice;

    //Para almacenar el id del juego con eso se puede crear la pantalla del juego al comprarlo!
    private int idGame;

    @FXML
    private HBox BackGroundTrans;

    public GameInfoController() throws IOException {

        System.out.println("Construyendo");

        //ORIGINAL
        //Get Location a Null
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameInfoGood.fxml"));
        //FXMLLoader fxmlLoader =new FXMLLoader(getClass().getClassLoader().getResource("gameInfoGood.fxml"));
        //GET LOCATION A NULL
        //FXMLLoader fxmlLoader =new FXMLLoader();
        //fxmlLoader.setLocation(getClass().getResource(App.rutaRecursos("gameInfoGood")));
        //Revienta porque el Root y el Controller ya estan seteados!
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader = App.getFXMLLoader("gameInfo");

        System.out.println("1");
        fxmlLoader.setRoot(this);
        System.out.println("2");
        fxmlLoader.setControllerFactory(GameInfoController -> this);
        System.out.println("3");

        System.out.println("\nIMPORTANTE QUE SALGA BIEN");
        System.out.println(fxmlLoader.getLocation());
        System.out.println("");

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            System.err.println("AHHHHHHHHH\n");
            System.err.println(exception.getMessage());
            System.err.println("AHHHHHHHHH\n");

            System.out.println("peta el load");
            throw new RuntimeException(exception);
        }

        System.out.println("Construido");

    }

    /**
     * Constructor con parametros para crear el objeto
     *
     * @param idGame
     * @param title
     * @param numDownloads
     * @param price
     * @param urlImage
     * @throws IOException
     */
    public GameInfoController(int idGame, String title, String numDownloads, String price, String urlImage) throws IOException {

        //Construyo el objeto
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader = App.getFXMLLoader("gameInfo");
        fxmlLoader.setRoot(this);

        fxmlLoader.setControllerFactory(GameInfoController -> this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            throw new RuntimeException(exception);
        }

        //Seteo los parametros
        this.idGame = idGame;
        infoGameTitle.setText(title);
        infoGameDownloads.setText(numDownloads);
        infoGamePrice.setText(price);

        //Comprueba si la URL DE LA IMAGEN ES CORRECTA si es asi carga la imagen sino pa fuera!
        if (exists(urlImage)) {
            infoGameImage.setImage(new Image(urlImage));
        }

    }

    /**
     * Comprobar la URL de una imagen si es correcta deja continuar
     *
     * @param URLName
     * @return
     */
    public static boolean exists(String URLName) {

        //Comprueba el tipo de archivo si es correcto continua
        if (URLName.endsWith(".jpg") || URLName.endsWith(".png") || URLName.endsWith(".gif") || URLName.endsWith(".bmp") || URLName.endsWith(".jpeg")) {
            try {
                new URL(URLName).toURI();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        
        return false;

        // PRUEBAS
        /*
        InputStream input = null;
        try {

            input = (new URL(urlImage)).openStream();
            input.close();
            infoGameImage.setImage(new Image(urlImage));
            System.out.println("imagen correcta carago la del la BBDD");
            
        } catch (IOException ex) {
            System.out.println("la imagen no va bien cargo dejo la de serie");
        } finally {
            if (input != null) {
                input.close();
            }

        }
         */
 /*
        Image image = new Image(urlImage);
        if (image.isError()) {
            System.out.println("error al leer la imagen");
            
        } else {
            System.out.println("imagen ok");
        }
         */
 /*
        boolean result = false;
        try {
            InputStream input = (new URL(URLName)).openStream();
            result = true;
        } catch (IOException ex) {
            System.out.println("Image doesnot exits :");
        }
        return result;
         */
    }

    /**
     * Al precionar el Boton de compra deveria de pillar la ide del juego y
     * generar una nueva hoja de juego para mostrarla preguntando primero en la
     * BBDD por los juegos
     *
     * @param event
     */
    @FXML
    private void switchToPurchase(ActionEvent event) throws IOException {

        GameController gc = new GameController(idGame);

        MainView.main.setCenter(gc);

    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public Label getInfoGameTitle() {
        return infoGameTitle;
    }

    public void setInfoGameTitle(Label infoGameTitle) {
        this.infoGameTitle = infoGameTitle;
    }

    public ImageView getInfoGameImage() {
        return infoGameImage;
    }

    public void setInfoGameImage(ImageView infoGameImage) {
        this.infoGameImage = infoGameImage;
    }

    public Label getInfoGameDownloads() {
        return infoGameDownloads;
    }

    public void setInfoGameDownloads(Label infoGameDownloads) {
        this.infoGameDownloads = infoGameDownloads;
    }

    public Label getInfoGamePrice() {
        return infoGamePrice;
    }

    public void setInfoGamePrice(Label infoGamePrice) {
        this.infoGamePrice = infoGamePrice;
    }

}