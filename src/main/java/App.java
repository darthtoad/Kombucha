import java.util.ArrayList;
import java.util.HashMap;

import models.Kombucha;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import java.util.Map;

/**
 * Created by Guest on 1/9/18.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Kombucha.clearAllKombucha();
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String color = request.queryParams("color");
            String taste = request.queryParams("taste");
            String smell = request.queryParams("smell");
            int price = Integer.parseInt(request.queryParams("price"));
            Kombucha newKombucha = new Kombucha(name, color, taste, smell, price);
            ArrayList allKombucha = Kombucha.getAll();
            model.put("allKombucha", allKombucha);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList allKombucha = Kombucha.getAll();
            model.put("allKombucha", allKombucha);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
