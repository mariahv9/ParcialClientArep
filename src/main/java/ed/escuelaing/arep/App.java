package ed.escuelaing.arep;

import ed.escuelaing.arep.calculator.Calculate;
import org.primefaces.shaded.json.JSONObject;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class App {
    public static void main (String[] args) {
        port (getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> {
            res.type("application/json");
            return resultsPage(req, res);
        });
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
                + "  Ingrese la funcion:"
                + "  <input type=\"text\" name=\"value\" size= 50 value=\"45\n\">"
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
    private static JSONObject resultsPage(Request req, Response res) {
        String function = req.queryParams("data");
        String value = req.queryParams("value");
        double tr = getFunction(function, value);
        JSONObject ans = new JSONObject();
        ans.put("Funcion", function);
        ans.put("Valor", value);
        ans.put("Respuesta", tr);
        return ans;
    }

    /**
     * Method that returns the values
     * @param function, value
     * @return
     */
    public static double getFunction (String function, String value){
        Calculate cal = new Calculate();
        double ans = 0;
        if (function.equals("sin")){
            ans = cal.sin(Double.parseDouble(value));
        }
        else if (function.equals("cos")){
            ans = cal.cos(Double.parseDouble(value));
        }
        else if (function.equals("tan")){
            ans = cal.tan(Double.parseDouble(value));
        }
        return ans;
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