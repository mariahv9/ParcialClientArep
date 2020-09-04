package ed.escuelaing.arep;

import spark.Request;
import spark.Response;

import java.io.*;
import java.net.*;

import static spark.Spark.*;

public class App {
    public static void main (String[] args) {
        port (getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> {
            res.type("application/json");
            String function = req.queryParams("data");
            String value = req.queryParams("value");
            return readURL("https://desolate-waters-64492.herokuapp.com/results?data="+function+"&value="+value);
        });
    }

    public static String readURL(String sitetoread) {
        String resData = null;
        try {
            URL siteURL = new URL(sitetoread);
            URLConnection urlConnection = siteURL.openConnection();
            System.out.println("-------message-body------");
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine = null;
            resData = "";
            while ((inputLine = reader.readLine()) != null) {
                resData += inputLine;
            }
        } catch (IOException x) {
            resData = "";
            System.err.println(x);
        }
        return resData;
    }

    public static String inputDataPage (Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculadora Trigonometrica</h2>"
                + "<h4>A continuacion ingrese valor que desea evaluar</h4>"
                + "<h4>NOTA: Por favor ingrese la funcion trigonometrica y a continuación el valor en radianes</h4>"
                + "<form action=\"/results\">"
                + "  Ingrese la funcion:"
                + "  <input type=\"text\" name=\"data\" size= 50 value=\"cos\n\">"
                + "  <br><br>"
                + "  Ingrese el valor:"
                + "  <input type=\"text\" name=\"value\" size= 50 value=\"45\n\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Evaluar\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * Method that returns port service
     * @return
     */
    public static int getPort() {
        if (System.getenv("PORT") != null)
        {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}