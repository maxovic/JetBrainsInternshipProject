package Main;

import java.util.Vector;

import Tool.Delete;
import Tool.Get;
import Tool.Put;

public class Main {
	public static void main(String[] args) {
		Vector<String> names = Get.getFiles("http://localhost:8080/oldStorage/files");
		
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println(Get.getFile("http://localhost:8080/oldStorage/files", "1223.txt"));
		
		for(String name : names) {
			String url = "http://localhost:8080/oldStorage/files/" + name;
			Put.postFile(url);
		}
		
		for(String name : names) {
			String url = "http://localhost:8080/oldStorage/files/" + name;
			Delete.deleteFile(url);
		}
	}
}
