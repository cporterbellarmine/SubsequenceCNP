/**
 * This class accepts either a list of inputs or a file to determine if one string
 * is a subsequence of another string.
 * 
 * @author cporter
 * @version 10/03/2019
 * Programming Project 2
 * Fall 2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {

		String redo; //This variable indicates the response the user input as for whether or not they would like to submit another set of sequences.
		Scanner input = new Scanner(System.in); //This scanner will be used to read user responses.
		File file; //This file will be used to create a new File object based off user input.

		System.out.println("Would you like to enter sequences manually or from a file? (M/F):");

		String choice = input.next(); //This string is set to what the user inputs on the next line by using a scanner.

		System.out.println();

		//If the user inserts M for manually or F for file, the appropriate block will execute.
		if(choice.equals("M")) {

			//This will run at least once or more based on user input.
			do {

				boolean match = false;//This will be used to represent whether or not my end strings are the same.
				StackInterface<Character> subStack = new ArrayStack<>(); //This will be used for the stack representing my substring.
				StackInterface<Character> resultStack = new ArrayStack<>(); //This will be used to place characters from my sequence as they correspond to characters from my subsequence into a stack.

				System.out.println("Enter the first sequence:");
				String subsequence = input.next().toLowerCase(); //The subsequence will be the first string entered.

				System.out.println("Enter the second sequence:");
				String sequence = input.next().toLowerCase(); //The "full" sequence will be the second string entered.

				System.out.println();

				//This will create a stack representation of my substring by taking the indicies of the string starting at 0 and adding them to the stack.
				for(int sindex = 0; sindex < subsequence.length(); sindex++) {

					subStack.push(subsequence.charAt(sindex));

				}//end for

				int sindex = 0; //Since I want to reuse my sindex as the substring index, I am resetting it to 0.
				
				 //Here I am comparing my substring values with my fullstring values.
				for(int findex = 0; findex < sequence.length(); findex++) {

					//If the sindex is less than the length of the substring and the given indicies are the same for both subsequence
					//and sequence, then the character is pushed to the resultStack.
					if(sindex < subsequence.length() && subsequence.charAt(sindex) == sequence.charAt(findex)) {

						char letter = sequence.charAt(findex);
						match = true;
						sindex++;
						resultStack.push(letter);

					}else {

						match = false;

					}//end else
				}//end substring for

				String substackString = " "; //This initializes the empty string representation for the stack representing my substring.
				String resultString = " "; //This initializes the empty string representation for the stack representation of the results.

				//This checks to make sure that my stack is not empty before I try to pop something off of it, then turns my stack into a string.
				while(subStack.isEmpty() != true) {

					char newChar = subStack.pop();
					String newLetter = Character.toString(newChar);

					substackString = substackString + newLetter;

				}//end while

				//This checks to make sure that my stack is not empty before I try to pop something off of it, then turns my stack into a string.
				while(resultStack.isEmpty() != true) {

					char newChar = resultStack.pop();
					String newLetter = Character.toString(newChar);

					resultString = resultString + newLetter;

				}//end while

				//This checks to see if both the substackString and the resultString match. If they do, then it is a subsequence.
				if(substackString.equals(resultString)) {

					System.out.printf("%s IS A SUBSEQUENCE of %s.\n", subsequence, sequence);

				}else {

					System.out.printf("%s IS NOT A SUBSEQUENCE of %s.\n", subsequence, sequence);

				}//end else

				System.out.println();

				System.out.println("Would you like to enter more sequences? (Y/N):");
				redo = input.next(); //This sets redo based on the user input.

				System.out.println();

			}while(redo.equals("Y")); //If the user inserts Y for redo, then the do loop is repeated.

			System.out.println("<END RUN>");


		}else if(choice.equals("F")) {

			System.out.println("Enter the name of the file to process: ");
			
			String fileName = input.next(); //The file name is set to whatever the user inputs.
			file = new File(fileName); //A new File object is created based on the user input.
			Scanner read = new Scanner(file);//This is the scanner that will be used to read the file.

			System.out.println();

			//This code will run as long as there is content to read.
			while(read.hasNextLine()) {

				String[] fileArray = read.nextLine().split(", "); //This creates a string array based on the file input and separates the elements using the given delimeter.

				String subsequence = fileArray[0].toLowerCase();//Element 0 in my array is the substring
				String sequence = fileArray[1].toLowerCase();//Element 1 in my array is the "full" string.

				boolean match = false;
				StackInterface<Character> subStack = new ArrayStack<>(); //This will be used for the stack representing my substring.
				StackInterface<Character> resultStack = new ArrayStack<>(); //This will be used to place characters from my sequence as they correspond to characters from my subsequence into a stack.
				
				 //Here I am creating a stack for my substring.
				for(int sindex = 0; sindex < subsequence.length(); sindex++) {

					subStack.push(subsequence.charAt(sindex));

				}//end for

				int sindex = 0; //Since I want to reuse my sindex as the substring index, I am resetting it to 0.
				
				//If the sindex is less than the length of the substring and the given indicies are the same for both subsequence
				//and sequence, then the character is pushed to the resultStack.
				for(int findex = 0; findex < sequence.length(); findex++) {

					if(sindex < subsequence.length() && subsequence.charAt(sindex) == sequence.charAt(findex)) {

						char letter = sequence.charAt(findex);
						match = true;
						sindex++;
						resultStack.push(letter);

					}else {

						match = false;

					}//end else
				}//end substring for

				String substackString = " "; //This initializes the empty string representation for the stack representing my substring.
				String resultString = " "; //This initializes the empty string representation for the stack representation of the results.

				//This checks to make sure that my stack is not empty before I try to pop something off of it, then turns my stack into a string.
				while(subStack.isEmpty() != true) {

					char newChar = subStack.pop();
					String newLetter = Character.toString(newChar);

					substackString = substackString + newLetter;


				}//end while

				//This checks to make sure that my stack is not empty before I try to pop something off of it, then turns my stack into a string.
				while(resultStack.isEmpty() != true) {

					char newChar = resultStack.pop();
					String newLetter = Character.toString(newChar);

					resultString = resultString + newLetter;


				}//end while

				//This checks to see if both the substackString and the resultString match. If they do, then it is a subsequence.
				if(substackString.equals(resultString)) {

					System.out.printf("%s IS A SUBSEQUENCE of %s.\n", subsequence, sequence);

				}else {

					System.out.printf("%s IS NOT A SUBSEQUENCE of %s.\n", subsequence, sequence);

				}//end else
			}//end while

			System.out.println();
			System.out.println("<END RUN>");

		}//end else
	}//end main
}//end Test
