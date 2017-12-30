package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SearchEngine {

	public SearchEngine(String fileLocation) {
		try {
			Scanner scan = new Scanner(new File(fileLocation));
			lineCount=0;
			while(scan.hasNextLine()) {
				scan.nextLine();
				lineCount++;
			}
			scan.close();
			fileToStringArray = new String[lineCount];
			setStringArray(fileLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void setStringArray(String fileLocation) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileLocation));
		int index=0;
		while(scan.hasNextLine())
			fileToStringArray[index++]=scan.nextLine();
	}
	
	private static int countMatches(String searchTerm) { 
		int count=0;
		for(int i=0;i<lineCount-1;i++)
			if(fileToStringArray[i].toLowerCase().contains(searchTerm))
				count++;
		return count;
	}
	
	public String[] search(String searchTerm) {
		searchTerm=searchTerm.toLowerCase();
		String[] relatedSearchTerms = new String[countMatches(searchTerm)];
		int index=0;
		for(int i=0;i<lineCount;i++)
			if(fileToStringArray[i].toLowerCase().contains(searchTerm))
				relatedSearchTerms[index++]=fileToStringArray[i];
		return relatedSearchTerms;
	}
	
	private static int lineCount;
	private static String[] fileToStringArray;
}
