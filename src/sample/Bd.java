package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Bd {

    private static Statement sentenciaSQL = null;
    private static Connection conexion = null;

    // método para conectar con la base de datos
    final void conectar() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/testpreguntas", "root", "1234");

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // método para desconectarse de la base de datos
    final void desconectar() {

        try {
            sentenciaSQL.close();
            conexion.close();

        } catch (SQLException ex) {
            System.out.println("ERROR");
        }
    }


    // hacemos una lista con las preguntas que pondremos en la interfaz
    public ArrayList<String> listaPreguntas() throws ClassNotFoundException {

        String sql1;
        ResultSet result;
        ArrayList<String>listaPreguntas= new ArrayList<String>();
        ArrayList<String>listaPreguntasBuenas= new ArrayList<String>();

        try {
            conectar();
            sentenciaSQL = conexion.createStatement();
            sql1 = "SELECT `pregunta` FROM `preguntas`";
            result = sentenciaSQL.executeQuery(sql1);

            if(result.next()) {
                while (result.next()) {
                    listaPreguntas.add(result.getString("pregunta"));
                }
                Collections.shuffle(listaPreguntas); // hacemos el shuffle para coger preguntas aleatorias sin repetirse

                for(int i=0; i<5; i++) {
                    listaPreguntasBuenas.add(listaPreguntas.get(i)); // añadimos las preguntas definitivas al arraylist preguntasBuenas
                }
            }
            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al cargar preguntas");
        }
        return listaPreguntasBuenas;
    }

    // lista con todas las respuestas
    public ArrayList<String> listaRespuestas() throws ClassNotFoundException {

        String sql1;
        ResultSet result;
        ArrayList<String>listaRespuestas=new ArrayList<String>();

        try {
            conectar();
            sentenciaSQL = conexion.createStatement();
            sql1 = "Select respuesta from respuestas";

            System.out.println(sql1);
            result = sentenciaSQL.executeQuery(sql1);
            while(result.next()){
                listaRespuestas.add(result.getString("respuesta"));
            }
            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al cargar respuestas");
        }
        return listaRespuestas;
    }

    // lista con las respuestas correctas
    public ArrayList<String> listaRespuestasCorrectas() throws ClassNotFoundException {

        String sql1;
        ResultSet result;
        ArrayList<String>listaRespuestasCorrectas=new ArrayList<String>();

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();
            sql1 = "Select respuesta from respuestas where correcta='S'";

            result = sentenciaSQL.executeQuery(sql1);
            while(result.next()){
                listaRespuestasCorrectas.add(result.getString("respuesta"));
            }
            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al cargar respuestas correctas");
        }
        return listaRespuestasCorrectas;
    }

    // lista con los IDs de las preguntas que han salido
    public ArrayList<Integer> listaIdPreguntas(ArrayList listaPreguntas) throws ClassNotFoundException {

        String sql1;
        ResultSet result=null;
        String titulo="";
        ArrayList<Integer>listaIdPreguntas=new ArrayList<Integer>();

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            for(int i=0; i<5; i++) {

                sql1 = "Select idpregunta from preguntas WHERE (`pregunta` ='" + listaPreguntas.get(i) + "');";

                result = sentenciaSQL.executeQuery(sql1);
                while(result.next()){
                    listaIdPreguntas.add(result.getInt("idpregunta"));
                }
            }
            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al cargar los IDs de las preguntas");
        }
        return listaIdPreguntas ;
    }


    // lista de las respuestas de las preguntas
    public ArrayList<String> listaRespuestasPorPregunta1(ArrayList listaIdPreguntas, int posicion) throws ClassNotFoundException, SQLException {

        String sql1;
        ResultSet result;
        ArrayList<String>listaRespuestasPorPregunta1=new ArrayList<String>();

        try {

            conectar();
            sentenciaSQL = conexion.createStatement();

            sql1 = "Select respuesta from respuestas WHERE (`fidpregunta` ='" + listaIdPreguntas.get(posicion) + "');";

            result = sentenciaSQL.executeQuery(sql1);
            while (result.next()) {
               listaRespuestasPorPregunta1.add(result.getString("respuesta"));

            }
            desconectar();

        } catch (SQLException ex) {
            System.out.println("ERROR al cargar respuestas de la pregunta");
        }
        return listaRespuestasPorPregunta1;
    }
}