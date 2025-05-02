package cs111Lab2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Decryptor {
	public String decryptLevelOne(String inputText) {
		
	}
	public String decryptLevelTwo(String inputText) {
		
		
		/* using String's replace looks simpler than this
		 * I made this before reading all of the lab
		 * Idk if it even works, never tested this section before 
		 * removing it
	 	StringBuilder input = new StringBuilder(inputText);
		for (int i = 0; i < input.length(); i++) {
			
			if (input.charAt(i) == '!') {
				input.replace(i, i, "a");
			}
			else if (input.charAt(i) == '{') {
				input.replace(i, i, "x");
			}	
		}
		*/
		
		inputText.replace('!', 'a');
		inputText.replace('{', 'x');
		
		
		StringBuilder modifiedInput = new StringBuilder(inputText);
		modifiedInput.delete(0, 1);
		modifiedInput.delete(modifiedInput.length()-2, modifiedInput.length()-1);
		
		modifiedInput.reverse();
		
		
		
		for (int i = 0; i < modifiedInput.length(); i++) {
			
			modifiedInput.
			
		}
		
		
		
		
		
		
	}
	public String readMessage(String fileName) throws IOException{
		File inputFile = new File(fileName);
		Scanner inputFileScanner = Scanner(inputFile);
		String outputString = inputFileScanner.nextLine();
		inputFileScanner.close();
		return outputString;
		
	}
	public static void main(String[] args) throws IOException{
		
		
		
		
	}
}
