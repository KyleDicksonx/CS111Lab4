package cs111Lab2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Decryptor {
	
	public static void main(String[] args) throws IOException{
		
		String inputText = readMessage("EncryptedMessage.txt");
		
		inputText = decryptLevelTwo(inputText);
		//System.out.println("main lvl 2 done: " + inputText);
		inputText = decryptLevelOne(inputText);
		//System.out.println("main lvl 1 done: " + inputText);
		System.out.println(inputText);
		
		
	}
	
	
	
	
	public static String decryptLevelOne(String inputText) {
		
		StringBuilder codePointString = new StringBuilder(inputText);
		StringBuilder newString = new StringBuilder();
		char codePoint;
		
		
		for (int i = 0; i < codePointString.length(); i++) {
			codePoint = (char) (codePointString.codePointAt(i));
			codePoint += 13;
			newString.append(codePoint);
		}
		
		//System.out.println("Lvl 1 end:  " + newString.toString());
		return newString.toString();
		
	}
	public static String decryptLevelTwo(String inputText) {
		
		
		/* using String's replace looks simpler than this
		 * I made this before reading all of the lab
		 * Idk if it even works, never tested this section before removing it
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
		
		inputText = inputText.replace('!', 'a');
		inputText = inputText.replace('{', 'x');
		
		
		StringBuilder modifiedInput = new StringBuilder(inputText);
		modifiedInput = modifiedInput.delete(0, 2);
		//System.out.println("del section 1 end: " + modifiedInput);
		modifiedInput = modifiedInput.delete(modifiedInput.length()-2, modifiedInput.length());
		//System.out.println("del section 2 end: " + modifiedInput);
		modifiedInput = modifiedInput.reverse();
		
		
		char[] switchCaseString = modifiedInput.toString().toCharArray();
		for (int i = 0; i < modifiedInput.length(); i++) {
			if (Character.isLowerCase(switchCaseString[i])) {
				switchCaseString[i] = Character.toUpperCase(switchCaseString[i]);
				//System.out.println("Switch a lower");
			}
			else if (Character.isUpperCase(switchCaseString[i])) {
				switchCaseString[i] = Character.toLowerCase(switchCaseString[i]);
				//System.out.println("Switch an upper");
			}
		}
		
		//System.out.println("lvl 2 end: " + switchCaseString.toString());
		
		//building a new string out of the char array because switchCaseString.toString() didnt work
		//it was a headache finding that one
		StringBuilder returnString = new StringBuilder();
		for (int i = 0; i < switchCaseString.length; i++) {
			returnString.append(switchCaseString[i]);
			//System.out.println("level 2 return string build stages: " + returnString.toString());
		}
		return returnString.toString();
		
		
		
		
	}
	
	
	public static String readMessage(String fileName) throws IOException{
		File inputFile = new File(fileName);
		Scanner inputFileScanner = new Scanner(inputFile);
		String outputString = inputFileScanner.nextLine();
		inputFileScanner.close();
		return outputString;
		
	}
	
	
	
}
