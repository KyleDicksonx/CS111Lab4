/*
 * Kyle Dickson
 * 50116781
 * I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
 */

package cs111Lab2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Decryptor {
	
	public static void main(String[] args) throws IOException{
		
		//takes the file and returns its single line as a string
			String inputText = readMessage("EncryptedMessage.txt");
		
		/*decrypt level two serves 4 functions
		 * 1. replace ! with a and { with x
		 * 2. removes *@ from the start and end
		 * 3. inverts the order of the chars
		 * 4. switch the case of all letters
		 */
			inputText = decryptLevelTwo(inputText);
			//System.out.println("main lvl 2 done: " + inputText);//debug
		
		//adds 13 to the ascii value of the chars and rebuilds the string
			inputText = decryptLevelOne(inputText);
			//System.out.println("main lvl 1 done: " + inputText);
		
		//outputs the final  string to the console
			System.out.println(inputText);
	}
		
	public static String decryptLevelOne(String inputText) {
		
		
		StringBuilder codePointString = new StringBuilder(inputText); //the input string as a string builder
		StringBuilder newString = new StringBuilder(); //this will be the final string that gets built
		char codePoint;
		
		//takes each char in the input text and adds 13 to the code point value and rebuilds a new string
		for (int i = 0; i < codePointString.length(); i++) {
			//find the code point
			codePoint = (char) (codePointString.codePointAt(i));
			//add 13 to the code point
			codePoint += 13;
			//append the value onto the new string
			newString.append(codePoint);
		}
		
		//System.out.println("Lvl 1 end:  " + newString.toString()); //debug
		return newString.toString();
		
	}
	public static String decryptLevelTwo(String inputText) {
		
		//unused
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
		
		//replaces ! with a and { with x
			inputText = inputText.replace('!', 'a');
			inputText = inputText.replace('{', 'x');
		
		//creates a new string builder with the modified inputs from the .replace
		StringBuilder modifiedInput = new StringBuilder(inputText);
		
		//removes the first and last two chars from the string
			modifiedInput = modifiedInput.delete(0, 2);
			//System.out.println("del section 1 end: " + modifiedInput); //debug
			modifiedInput = modifiedInput.delete(modifiedInput.length()-2, modifiedInput.length());
			//System.out.println("del section 2 end: " + modifiedInput); //debug
			
		//inverts the order of the chars in the string
		modifiedInput = modifiedInput.reverse();
		
		//creates an array of chars from the reversed input 
		char[] switchCaseString = modifiedInput.toString().toCharArray();
		
		//switches the case of all letters
		for (int i = 0; i < modifiedInput.length(); i++) {
			
			//checks for an lower case letter and switches it to upper case
			if (Character.isLowerCase(switchCaseString[i])) {
				
				//switches the case of the letter at i and reassigns it to the same position 
				switchCaseString[i] = Character.toUpperCase(switchCaseString[i]);
				//System.out.println("Switch a lower"); //debug
			}
			//if no lower case is found, checks for an upper case letter and switches it to lower case
			else if (Character.isUpperCase(switchCaseString[i])) {
				
				//switches the case of the letter at i and reassigns it to the same position 
				switchCaseString[i] = Character.toLowerCase(switchCaseString[i]);
				//System.out.println("Switch an upper"); //debug
			}
		}
		
		//System.out.println("lvl 2 end: " + switchCaseString.toString()); //debugS
		
		//building a new string out of the char array because switchCaseString.toString() didnt work
		//it was a headache finding that one
		StringBuilder returnString = new StringBuilder();
		
		//rebuilds the string 
		for (int i = 0; i < switchCaseString.length; i++) {
			returnString.append(switchCaseString[i]);
			//System.out.println("level 2 return string build stages: " + returnString.toString());
		}
		return returnString.toString();
		
		
		
		
	}
	
	//takes the file name as input and returns 
	public static String readMessage(String fileName) throws IOException{
		
		//new file object
		File inputFile = new File(fileName);
		
		//scanner for file object
		Scanner inputFileScanner = new Scanner(inputFile);
		String outputString = inputFileScanner.nextLine();
		inputFileScanner.close();
		return outputString;
		
	}
	
	
	
}
