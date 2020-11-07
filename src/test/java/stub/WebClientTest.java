package stub;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WebClientTest {
	
	static Server server;

	@BeforeAll
	public static void setUp() throws Exception {
		
		server = new Server(8080);
		
		ContextHandler context = new ContextHandler();
		context.setContextPath("/testGetContentOk");
		context.setHandler(new TestHandler());
		
		server.setHandler(context);
		server.start();
		
	}
	
	@AfterAll
	public static void tearDown() throws Exception {
		server.stop();
	}

	@Test
	void testGetContentOk() throws MalformedURLException {
		WebClient client = new WebClient();
		String workingContent = client
				.getContent(new URL("http://localhost:8080/testGetContentOk"));
		assertEquals("<h1>It works</h1>", workingContent);
	}

}
