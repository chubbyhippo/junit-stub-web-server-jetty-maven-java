package stub;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Test;

class WebClientTest {

	@Test
	void testGetContentOk() throws MalformedURLException {
		WebClient client = new WebClient();
		String workingContent = client
				.getContent(new URL("http://localhost:8080/"));
		assertEquals("<h1>It works</h1>", workingContent);
	}

}
