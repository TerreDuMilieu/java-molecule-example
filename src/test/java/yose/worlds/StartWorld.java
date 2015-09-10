package yose.worlds;

import com.sun.source.tree.AssertTree;
import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;
import static org.junit.Assert.*;

public class StartWorld {

    YoseDriver yose = new YoseDriver(8080);

    HttpRequest request = new HttpRequest(8080);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yose.start();
    }

    @After
    public void stopGame() throws Exception {
        yose.stop();
    }

    @Test
    public void firstWebPageChallenge() throws IOException {
        yose.home().displaysGreeting("Hello Yose");
    }

    @Test
	public void checkRefToSource() throws IOException {
		yose.home().displaysGreeting("href=\"https://github.com/TerreDuMilieu/java-molecule-example\"");
	}
    
    @Test
	public void checkRefToSourceID() throws IOException {
		yose.home().displaysGreeting("id=\"repository-link\"");		
	}
    
    @Test
    public void firstWebServiceChallenge() throws IOException {
        response = request.get("/ping");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"alive\":true}");
    }

    @Test
    public void identifierAvailability() throws IOException {

        response = request.get("/");

        Assert.assertTrue(yose.findIdentifier("contact-me-link"));
    }
}
