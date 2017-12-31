package Search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Ramon Deniz 12/30/17
 * 
 * Sample Code
 * 
 * Create an instance
 * 		SearchEngine engine = new SearchEngine("file.txt");
 * 
 * Search by item name
 * 		engine.search("name");
 * 
 * Search by item ID
 * 		engine.search(1234);
 */
public class SearchEngine {
	/**
	 * Constructor
	 * 
	 * @param fileLocation
	 */
	public SearchEngine(String fileLocation) {
		try {
			Scanner scan = new Scanner(new File(fileLocation));
			while (scan.hasNextLine()) {
				String[] lineSplit = scan.nextLine().split(",");
				fileToArrayList.add(new SearchResult(Integer.parseInt(lineSplit[0]), lineSplit[1]));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Searches for item name or related terms. Returns empty list if match is not
	 * found.
	 * 
	 * @param searchTerm
	 * @return ArrayList<SearchResult>
	 */
	public ArrayList<SearchResult> search(String searchTerm) {
		searchTerm = searchTerm.toLowerCase();
		ArrayList<SearchResult> relatedTerms = new ArrayList<SearchResult>();

		for (SearchResult item : fileToArrayList)
			if (item.name.toLowerCase().contains(searchTerm))
				relatedTerms.add(new SearchResult(item.ID, item.name));

		return relatedTerms;
	}

	/**
	 * Searches for specific ID. Returns null if ID is not found.
	 * 
	 * @param ID
	 * @return SearchResult
	 */
	public SearchResult search(int ID) {
		for (SearchResult item : fileToArrayList)
			if (item.ID == ID)
				return new SearchResult(item.ID, item.name);
		return null;
	}

	private static ArrayList<SearchResult> fileToArrayList = new ArrayList<SearchResult>();

}
