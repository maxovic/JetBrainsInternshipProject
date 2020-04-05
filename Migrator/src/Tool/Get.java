package Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

public class Get {
	private static HttpURLConnection connection;
	public static Vector<String> getFiles(String urlink) {
		BufferedReader reader;
		String line;
		Vector<String> responseContent = new Vector<String>();
		try {
			URL url = new URL(urlink);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			int status = connection.getResponseCode();
			if(status > 299)
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			else 
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while((line = reader.readLine()) != null) {
				responseContent.add(line);
			}
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		return responseContent;
	}
	public static String getFile(String urlink, String name) {
		BufferedReader reader;
		String line;
		String urLink = urlink + '/' + name;
		StringBuffer responseContent = new StringBuffer();
		try {
			URL url = new URL(urLink);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			int status = connection.getResponseCode();
			if(status > 299)
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			else 
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		return responseContent.toString();
	}
}
