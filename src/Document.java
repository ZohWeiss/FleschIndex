import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Document {
		
	// Constructor
	public Document(String fileName) throws FileNotFoundException {
		currentFile  = fileName + ".txt";
	}

	// Fields
	String currentFile;
	Scanner inputFile;

	String currentWord;

	public int countSentences() throws FileNotFoundException {
		int sentenceCount = 0;

		inputFile = new Scanner(new File(currentFile));
		inputFile.useDelimiter("[\\.:;!?]");
		
		
		while (inputFile.hasNext() == true) {
			currentWord = inputFile.next();
			if (currentWord.trim().length() > 1) {
				sentenceCount++;
			}
		}
		
		inputFile.close();
		return sentenceCount;
	}
	
	public int countWords() throws FileNotFoundException {
		int wordCount = 0;
		

		inputFile = new Scanner(new File(currentFile));
		
		while (inputFile.hasNext() == true) {
			inputFile.next();
			wordCount++;
		}
		
		inputFile.close();		
		return wordCount;
	}
	
	public int countSyllables() throws FileNotFoundException {	
		int syllableCount = 0;
		
		inputFile = new Scanner(new File(currentFile));

		while (inputFile.hasNext() == true) {
			currentWord = inputFile.next();
			syllableCount += Word.countSyllables(currentWord);		
		}
		
		inputFile.close();
		return syllableCount;
	}
	
	public int getFleschIndex() throws FileNotFoundException {
		int index = (int) Math.round(206.835 
				 - (84.6 * ((float)countSyllables()/countWords())) 
				 - (1.015 * ((float)countWords()/countSentences()))); 		
		return index;
	}
	
	public String getEducationLevel(int fleschIndex) {
		String educationLevel = null;
		
		if (fleschIndex >= 91) {
			educationLevel = "5th Grader";
		}
		else if (fleschIndex >= 81 && fleschIndex <= 90) {
			educationLevel = "6th Grader";
		}
		else if (fleschIndex >= 71 && fleschIndex <= 80) {
			educationLevel = "7th Grader";
		}
		else if (fleschIndex >= 66 && fleschIndex <= 70) {
			educationLevel = "8th Grader";
		}
		else if (fleschIndex >= 61 && fleschIndex <= 65) {
			educationLevel = "9th Grader";
		}
		else if (fleschIndex >= 51 && fleschIndex <= 60) {
			educationLevel = "High School Student";
		}
		else if (fleschIndex >= 31 && fleschIndex <= 50) {
			educationLevel = "College Student";
		}
		else if (fleschIndex >= 0 && fleschIndex <= 30) {
			educationLevel = "College Graduate";
		}
		else {
			educationLevel = "Law School Graduate";
		}
		
		return educationLevel;
	}
	
	public String toString() {
		String fileText = "";
		
		try {
			System.out.println("Words in file: " + countWords());
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		try {
			System.out.println("Syllables in file: " + countSyllables());
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		try {
			System.out.println("Sentences in file: " + countSentences());
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		try {
			System.out.println("Flesch Readability Index: " + getFleschIndex());
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		try {
			System.out.println("Education Level: " + getEducationLevel(getFleschIndex()));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		try {
			inputFile = new Scanner(new File(currentFile));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		while (inputFile.hasNextLine() == true) {
			fileText += inputFile.nextLine() + "\n";
		}
		
		inputFile.close();
		return fileText;
	}
}
