package Tool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Delete {
	private static HttpURLConnection connection;
	static int status;
	public static int deleteFile(String urlink) {
		try {
			URL url = new URL(urlink);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty(
				    "Content-Type", "application/x-www-form-urlencoded" );
			connection.setRequestMethod("DELETE");
			connection.connect();
			status = connection.getResponseCode();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		return status;
	}
}
