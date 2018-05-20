package debug.textProcesser;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		SearchEngine google = new SearchEngine();
		google.processText("src\\debug\\textProcesser\\testText.txt");
		System.out.println("\n");
		System.out.println(google.map.toString());				
	}
}
