package ed.escuelaing.arep.calculator;
import spark.Request;
import spark.Response;
import ed.escuelaing.arep.resources.*;

import static spark.Spark.*;

/**
 * Class that deploy on web
 * @author Maria Hernandez
 */
public class App {
    public static void main(String[] args) {
        port (getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    /**
     * Method that show the first page
     * @param req
     * @param res
     * @return
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculadora de la Media y Desviacion Estandar</h2>"
                + "<h4>A continuacion ingrese el grupo de datos que desea evaluar</h4>"
                + "<h4>NOTA: Por favor solo ingrese numeros reales, no son validas las letras</h4>"
                + "<form action=\"/results\">"
                + "  Ingrese los datos separados por un espacio:"
                + "  <input type=\"text\" name=\"data\" size= 50 value=\"4.5 12 16 138.6 98 116.5 48.9 64 91 84.3\n\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Evaluar\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * Method that reads the file with the data input
     * @param req
     * @param res
     * @return
     */
    private static String resultsPage(Request req, Response res) {
        String dataFrame;
        LinkedList data;
        Double number;
        double m = 0, s = 0;

        if ((dataFrame = req.queryParams("data")) != null) {
            String[] list = dataFrame.split(" ");
            data = new LinkedList();
            for (String elemento: list) {
                number = Double.parseDouble(elemento);
                data.insertTail(number);
            }
            m = getMean(data);
            s = getStd(data);
        }

        return "Los datos que fueron evaluados son: [" + req.queryParams("data") +
                "] Y el resultado de la Media es: " + m + " y de la Desviación Estándar es: "+ s;
    }

    /**
     * Method that returns Mean of a data list
     * @param data
     * @return
     */
    public static double getMean (LinkedList data){
        Calculator results = new Calculator();
        return results.mean(data);
    }

    /**
     * Method that returns Standard Deviation of a data list
     * @param data
     * @return
     */
    public static double getStd (LinkedList data){
        Calculator results = new Calculator();
        return results.standardDev(data);
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