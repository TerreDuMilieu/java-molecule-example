package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.routing.DynamicRoutes;

import java.io.IOException;
import java.net.URI;

public class Yose {

    private final WebServer server;

    public Yose(int port) {
        this.server = WebServer.create(port);
    }

    public void start() throws IOException {
        final Gson gson = new Gson();

        server.start(new DynamicRoutes() {{
            get("/").to((request, response) -> response.body(homePage()));
            get("/contactme").to((request, response) -> response.body("<a href=\"mailto:terredumilieu22@gmail.com\">Click here !</a>"));
            get("/ping").to(new Ping(gson)::pong);
            get("/primefactor").to(new PrimeFactorWeb(gson)::Decomposition);

           
            
            ;
        }});
    }

    public URI uri() {
        return server.uri();
    }

    public void stop() throws IOException {
        server.stop();
    }

    private String homePage() {
        String htmlBody = "<html><head></head><body>";
        htmlBody += "Hello Yose";
        htmlBody += "<br/><a id=\"contact-me-link\" href=\"contactme\">Contact us</a>";
        htmlBody += "<br/><a id=\"repository-link\" href=\"https://github.com/TerreDuMilieu/java-molecule-example\">GitHub link</a>";
        htmlBody += "<br/>Team members:";
        htmlBody += "<br/>Philippe";
        htmlBody += "<br/>Sandrine";
        htmlBody += "<br/>Balazs";
        htmlBody += "<br/>Claude";
        htmlBody += "<br/>Xavier";
        htmlBody += "<br/>Anthony";
        htmlBody += "</body>";
        return htmlBody;
    }

    private static final int PORT = 0;

    private static int port(String[] args) {
        return args.length > 0 ? Integer.parseInt(args[PORT]) : 8080;
    }

    public static void main(String[] args) throws IOException {
        Yose yose = new Yose(port(args));
        yose.start();
        System.out.print("To play the game visit  URL" + yose.uri());
    }
}