public class Word {
	
	public static int countSyllables(String currentWord) {
		
		boolean prevCharIsVowel = false; // Boolean to indicate if the previous char is a vowel
		int syllableCount = 0; // Syllable count for current word
		
		
		// Scan the word one char at a time and increment the syllable count if the char is a vowel and the previous char was not a vowel
		for (int i = 0; i < currentWord.length(); i++) {	
			if (prevCharIsVowel == false) {	
					switch (currentWord.toLowerCase().charAt(i)) {
						case 'a':
						case 'e':
						case 'i':
						case 'o':
						case 'u':
						case 'y': prevCharIsVowel = true; syllableCount++; break;
						default: break;
					}
			}
			else {
					switch (currentWord.toLowerCase().charAt(i)) {
						case 'a':
						case 'e':
						case 'i':
						case 'o':
						case 'u':
						case 'y': break;
						default: prevCharIsVowel = false; break;
					}
			}
		}
		
		
		if (currentWord.toLowerCase().endsWith("e")) {
			syllableCount--;
		}
		
		
		if (syllableCount == 0) {
			syllableCount = 1;
		}
		
		return syllableCount;
	}
}