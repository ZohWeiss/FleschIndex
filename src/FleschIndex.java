import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class FleschIndex {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		String fileName;
		boolean keepGoing = true;
		
		while(keepGoing) {
			System.out.println("What file would you like to use? (Do not include the file extension. For example: For HelloWorld.txt, enter HelloWorld)");
			fileName = keyboard.nextLine().trim();
			Document currentDoc = new Document(fileName);
			System.out.println("\nFile Text:\n" + currentDoc.toString() + "\n");
			System.out.println("Would you like to try another file? (Y/N)");
			String anotherFile = keyboard.nextLine().trim();
			if (anotherFile.toUpperCase().charAt(0) == 'N') {
				keepGoing = false;
			}
		}	
	}
}
