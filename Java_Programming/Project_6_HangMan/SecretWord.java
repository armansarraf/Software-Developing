/**
 * Class Name: SecretWord
 * Role: This class is like a version of Hangman game. We choose a specific word which is hidden from user and they should guess it character by character.
 * We have a secretWord which is our real word, and a displayedWord which is * for the length of our real word. 
 *  
 * Attributes: String secretWord, displayedWord
 * Behaviors: Constructor, getDisplayedWord(), getSecretWord(), replaceChars() with two signatures, makeGuess()
 *  
 * @author Arman Sarraf
 */

public class SecretWord {
	
	private String secretWord;
	private String displayedWord;
	
	public SecretWord(String newWord) {
		this.secretWord = newWord;
		displayedWord = replaceChars(newWord, '*');
	} // Constructor, we have set the displayedWord value with the return value of the replaceChars() method. 
	
	public String getDisplayedWord() {
		return displayedWord; 
			} // returns the value of displayedWord which is a string 

		public String getSecretWord(){
			return secretWord;
		} // returns the value of secretWord which is a string
		
		/**
		 * replaceChars() method puts star(*) for each character of secretWord. A for-loop has been defined to set '*' for the length of the word. The new string which contains only '*' is kept in result.  
		 * @param word
		 * @param star
		 * @return (String) result
		 */
		public String replaceChars(String word, char star) {
			String result = "";
			for(int i = 0; i<word.length(); i++) {
				result += star;
			}
			return result;
		} // for-loop used to set star for each character exist in our word.
		
		/**
		 * This method which is an overloaded method of above method, gets two instances as String, and one instance as char. 
		 * s1 is our secret word, s2 is what displayed to user and 'ch' is character guessed by user.
		 * for-loop goes through each character exits in s1 (s1.length), if guessed char exists in the s1 then, it is replaced with the exact location character in s2.
		 * So, if char exist in s1 index(x) the char will be replaced with s2 index(x).  
		 * @param s1
		 * @param s2
		 * @param ch
		 * @return newdisplay
		 */
		public String replaceChars(String s1, String s2, char ch) {
			String newdisplay = "";
			for (int i = 0; i<s1.length(); i++) {
				if (s1.charAt(i) == ch) {
				 newdisplay += s1.charAt(i);
				}
				else {
					newdisplay += s2.charAt(i);
				}
			} // for-loop loops over all the characters in s1. if statement determines if char ch exist in s1 index(i) if true, the char ch will be replaced with s2(i). 
			return newdisplay;
		}
		
		/**
		 * makeGuess() method gets only the character guessed and entered by user. After that, it checks if that character exists in the secret word or not. If yes, it calls replaceChars() method, 
		 * updates displayedWord, and returns true. Otherwise, it returns false.
		 * @param ch
		 * @return boolean
		 */
		public boolean makeGuess(char ch) {
			for (int i = 0; i<secretWord.length(); i++) {
				if (secretWord.charAt(i) == ch) {
					displayedWord = replaceChars(secretWord, displayedWord, ch);
			return true;
					}
			}return false;
	}
}