package slideMaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class encapsulates the process of parsing information from simple text files 
 * from April Eisman's 280 class to make the process of note card creation easier. 
 * @author Corbin K. Zahrt
 *
 */
public class StringParser {
	
	
	
	/**
	 * This array holds all the strings from handout. All significant manipulations are performed on it. 
	 */
	private ArrayList <String> stringBank = new ArrayList<>();
	
	/**
	 * This object represents the file which contains the handout. 
	 * The file object is passed to this class when instantiated via the constructor. 
	 */
	private File handout;
	
	/**
	 * This variable keeps the word which, when encountered, stops the program. 
	 */
	private static final String FULL_STOP_WORD = "corbinStop";
	//Do I need this?
	
	/**
	 * This variable keeps the word which indicates the period of the current stream of incoming strings. 
	 */
	private static final String NEW_PERIOD_WORD = "corbinPeriod";
	
	/**
	 * This might not be necessacary.  But it might be to totally stop all operations. 
	 */
	private boolean fullStop = false;
	
	
	/**
	 * This is the constructor for the StringParser. It accepts a file object as a parameter. This is 
	 * built to be used in conjunction with another class with a main method that creates the needed file object
	 * @param inputFile
	 */
	public StringParser(File inputFile){
		File file = inputFile;
		handout = file;
		
		
	}
	
	/**
	 * The foundation method. Invoking it will create an array which takes each line of text from the file 
	 * so it can be manipulated by the other methods. 
	 * @throws FileNotFoundException
	 */
	public void getAllStrings() throws FileNotFoundException{
		Scanner scanner = new Scanner(handout);
		String currentPeriod = "";
		fullStop = false;
	
		
		while(scanner.hasNext() && !fullStop){
			String currentItem = scanner.nextLine();
			
			if(currentItem.contains(FULL_STOP_WORD)){
				fullStop = true;
				break;
			}
			if (currentItem.contains(NEW_PERIOD_WORD)){
				currentPeriod = currentItem;
				Scanner quickLook = new Scanner(currentPeriod);
				quickLook.useDelimiter(NEW_PERIOD_WORD);
				currentPeriod = quickLook.next();
				currentPeriod = "," + currentPeriod;
			
			}
			if(currentItem.contains("*")){
				currentItem = currentItem.substring(0, currentItem.length()-1);
				stringBank.add(currentItem + currentPeriod);
				
			}
			
		}
	}
	
	/**
	 * Returns the array of all strings.
	 * @return stringBank
	 */
	public ArrayList<String> getArray(){
		return stringBank;
	}
	
	/**
	 * This method returns the contents of the array as a string.
	 * @return stringBank.toString();
	 */
	public String getArrayString(){
		//TODO 1 But this wouldn't quite work yet. This method, as currently written, would pass the entire array to the card method.
		
		return stringBank.toString();
		
	}
	
	
	/**
	 * This method returns the element of the array at the specified index. It's intended to be used in 
	 * conjunction with the length method in a loop to create the correct amount of card objects. 
	 * I made this method to fix the issue described in TODO 1.
	 * @param index
	 * @return stringBank.get(index)
	 */
	public String getIndex(int index){
		return stringBank.get(index);
	}
	
	/**
	 * This method creates a new file, with a name chosen by the user when invoked, that contains a list of each
	 * item contained in the handout. 
	 * @throws FileNotFoundException
	 */
	public void createListFile() throws FileNotFoundException {
		String list = "";
		
		Scanner userIn = new Scanner(System.in);
		System.out.println("What would you like to name the file?\n(use the format 'name.txt')");
		String nameOfFile = userIn.next();
		PrintWriter output = new PrintWriter(nameOfFile);
		
		for(int i = 0; i < stringBank.size(); i++){
			String currentItem = stringBank.get(i);
			list = currentItem;
			output.print(list + "\n");
			
		}
		
		
		output.close();
		userIn.close();
		
		
	}
	
	/**
	 * This method creates a file with the contents of the array.
	 * @throws FileNotFoundException
	 */
	public void createFileOfArray() throws FileNotFoundException{
		Scanner userIn = new Scanner(System.in);
		System.out.println("What would you like to name the file (use the format 'name.txt')");
		String nameOfFile = userIn.next();
		
		PrintWriter output = new PrintWriter(nameOfFile);
		output.print(stringBank);
		output.close();
		
	}
	
	/**
	 * This method returns the length of the array for use in loops. 
	 * @return stringBank.size()
	 */
	public int length(){
		return stringBank.size();
	}
	
}
