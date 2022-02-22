package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.*;
import java.util.ArrayList;

public class Controller {

    Bd bd = new Bd();

    // label de las preguntas
    @FXML
    private Label Pregunta1;
    @FXML
    private Label Pregunta2;
    @FXML
    private Label Pregunta3;
    @FXML
    private Label Pregunta4;
    @FXML
    private Label Pregunta5;

    // radio button de todas las posibles respuestas
    @FXML
    private RadioButton btn1;
    @FXML
    private RadioButton btn2;
    @FXML
    private RadioButton btn3;
    @FXML
    private RadioButton btn4;
    @FXML
    private RadioButton btn5;
    @FXML
    private RadioButton btn6;
    @FXML
    private RadioButton btn7;
    @FXML
    private RadioButton btn8;
    @FXML
    private RadioButton btn9;
    @FXML
    private RadioButton btn10;
    @FXML
    private RadioButton btn11;
    @FXML
    private RadioButton btn12;
    @FXML
    private RadioButton btn13;
    @FXML
    private RadioButton btn14;
    @FXML
    private RadioButton btn15;
    @FXML
    private RadioButton btn16;
    @FXML
    private RadioButton btn17;
    @FXML
    private RadioButton btn18;
    @FXML
    private RadioButton btn19;
    @FXML
    private RadioButton btn20;

    // botón comprobar solución
    @FXML
    private Button btnComprobarSolucion;

    // label donde aparecerá la nota
    @FXML
    private Label labelSolucion;

    // label de la frase de si eres fan de marvel
    @FXML
    private Label labelFanMarvel;

    // método que carga el contenido del test
    @FXML
    void cargarContenido() throws ClassNotFoundException, SQLException {

        // preguntas
        ArrayList<String> listaPreguntasBuenas = new ArrayList<String>();
        listaPreguntasBuenas = bd.listaPreguntas();

        Pregunta1.setText(listaPreguntasBuenas.get(0));
        Pregunta2.setText(listaPreguntasBuenas.get(1));
        Pregunta3.setText(listaPreguntasBuenas.get(2));
        Pregunta4.setText(listaPreguntasBuenas.get(3));
        Pregunta5.setText(listaPreguntasBuenas.get(4));

        // respuestas
            // respuesta 1
            ArrayList<String> listaRespuestasPorPreguntas1 = new ArrayList<String>();
            listaRespuestasPorPreguntas1 = bd.listaRespuestasPorPregunta1(bd.listaIdPreguntas(listaPreguntasBuenas), 0);
            btn1.setText(listaRespuestasPorPreguntas1.get(0));
            btn2.setText(listaRespuestasPorPreguntas1.get(1));
            btn3.setText(listaRespuestasPorPreguntas1.get(2));
            btn4.setText(listaRespuestasPorPreguntas1.get(3));

            // respuesta 2
            ArrayList<String> listaRespuestasPorPreguntas2 = new ArrayList<String>();
            listaRespuestasPorPreguntas2 = bd.listaRespuestasPorPregunta1(bd.listaIdPreguntas(listaPreguntasBuenas), 1);
            btn5.setText(listaRespuestasPorPreguntas2.get(0));
            btn6.setText(listaRespuestasPorPreguntas2.get(1));
            btn7.setText(listaRespuestasPorPreguntas2.get(2));
            btn8.setText(listaRespuestasPorPreguntas2.get(3));

            // respuesta 3
            ArrayList<String> listaRespuestasPorPreguntas3 = new ArrayList<String>();
            listaRespuestasPorPreguntas3 = bd.listaRespuestasPorPregunta1(bd.listaIdPreguntas(listaPreguntasBuenas), 2);
            btn9.setText(listaRespuestasPorPreguntas3.get(0));
            btn10.setText(listaRespuestasPorPreguntas3.get(1));
            btn11.setText(listaRespuestasPorPreguntas3.get(2));
            btn12.setText(listaRespuestasPorPreguntas3.get(3));

            // respuesta 4
            ArrayList<String> listaRespuestasPorPreguntas4 = new ArrayList<String>();
            listaRespuestasPorPreguntas4 = bd.listaRespuestasPorPregunta1(bd.listaIdPreguntas(listaPreguntasBuenas), 3);
            btn13.setText(listaRespuestasPorPreguntas4.get(0));
            btn14.setText(listaRespuestasPorPreguntas4.get(1));
            btn15.setText(listaRespuestasPorPreguntas4.get(2));
            btn16.setText(listaRespuestasPorPreguntas4.get(3));

            // respuesta 5
            ArrayList<String> listaRespuestasPorPreguntas5 = new ArrayList<String>();
            listaRespuestasPorPreguntas5 = bd.listaRespuestasPorPregunta1(bd.listaIdPreguntas(listaPreguntasBuenas), 4);
            btn17.setText(listaRespuestasPorPreguntas5.get(0));
            btn18.setText(listaRespuestasPorPreguntas5.get(1));
            btn19.setText(listaRespuestasPorPreguntas5.get(2));
            btn20.setText(listaRespuestasPorPreguntas5.get(3));
    }

    // método que comprueba la solución del usuario y saca una nota
    @FXML
    void comprobarSolucion() throws ClassNotFoundException, SQLException {
        
        int resultado = 0; // donde almacenaremos los puntos del usuario

        ArrayList<String>listaRespuestas=new ArrayList<>(); // arraylist que llenaremos con las respuestas marcadas por el usuario
        if(btn1.isSelected()){
            listaRespuestas.add(btn1.getText());
        } else if(btn2.isSelected()){
            listaRespuestas.add(btn2.getText());
        } else if(btn3.isSelected()){
            listaRespuestas.add(btn3.getText());
        } else if(btn4.isSelected()){
            listaRespuestas.add(btn4.getText());
        } if(btn5.isSelected()){
            listaRespuestas.add(btn5.getText());
        } else if(btn6.isSelected()){
            listaRespuestas.add(btn6.getText());
        } else if(btn7.isSelected()){
            listaRespuestas.add(btn7.getText());
        } else if(btn8.isSelected()){
            listaRespuestas.add(btn8.getText());
        } if(btn9.isSelected()){
            listaRespuestas.add(btn9.getText());
        } else if(btn10.isSelected()){
            listaRespuestas.add(btn10.getText());
        } else if(btn11.isSelected()){
            listaRespuestas.add(btn11.getText());
        } else if(btn12.isSelected()){
            listaRespuestas.add(btn12.getText());
        } if(btn13.isSelected()){
            listaRespuestas.add(btn13.getText());
        } else if(btn14.isSelected()){
            listaRespuestas.add(btn14.getText());
        } else if(btn15.isSelected()){
            listaRespuestas.add(btn15.getText());
        } else if(btn16.isSelected()){
            listaRespuestas.add(btn16.getText());
        } if(btn17.isSelected()){
            listaRespuestas.add(btn17.getText());
        } else if(btn18.isSelected()){
            listaRespuestas.add(btn18.getText());
        } else if(btn19.isSelected()){
            listaRespuestas.add(btn19.getText());
        } else if(btn20.isSelected()) {
            listaRespuestas.add(btn20.getText());
        }

        ArrayList<String>respuestasCorrectas=new ArrayList<>();
        respuestasCorrectas = bd.listaRespuestasCorrectas(); // arraylist con todas las respuestas correctas dentro
        for(int i=0;i<respuestasCorrectas.size();i++){
            if(listaRespuestas.contains(respuestasCorrectas.get(i))){
                resultado++;
            }
        }
        String cadena = String.valueOf(resultado); // pasamos el resultado a String para poder cargarlo en la interfaz

        // dependiendo del resultado, cargaremos una frase u otra
        if(resultado==5){
            labelFanMarvel.setText("No eres un fan, eres un vengador");
        } else if(resultado>2){
            labelFanMarvel.setText("Eres un auténtico fan");
        } else {
            labelFanMarvel.setText("Lamentamos decirte que tienes mucho que aprender aún");
        }

        // cargamos la nota del usuario sobre 5
        labelSolucion.setText("El resultado es ".concat(cadena).concat("/5"));
    }
}
