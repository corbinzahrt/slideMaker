package slideMaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the entry point for the program which encompasses all classes within slideMaker.
 * @author Corbin K. Zahrt
 *
 */
public class CardMakerMain {
	
	/**
	 * This array holds all card objects for storage and manipulation. 
	 */
	private static ArrayList <Card> deck = new ArrayList<>();
	
	/**
	 * Stores a formated version of <code>deck</code>
	 */
	private static ArrayList <String> formatDeck = new ArrayList<>();
	
	/**
	 * I don't think I need this. 
	 */
	private static ArrayList <String> handoutStrings;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		parseHandout();
		cardMaker();
		checkDeck();
		getFormat();
		toStringSave();
//		createFile();
		//createCardPrintOut();
		
		//TODO Perhaps a help that automatically adds formatting instead of coding into every method. 
		
		
		

	}
	

	
	/**
	 * This method contains the code for editing a Card object. 
	 */
	private static void checkDeck(){
		for(int i = 0; i < deck.size(); i++){
			CheckCards checker = new CheckCards(deck.get(i));
			checker.editCard();
		}
	}
	
	
	/**
	 * This method takes each element from the array which contains each slide and creates a deck of card objects.
	 */
	private static void cardMaker(){
		for(int i = 0; i < handoutStrings.size(); i++ ){
			String currentItem = handoutStrings.get(i);
			Card card = new Card(currentItem);
			deck.add(card);
			
		}
	}
	
	
	/**
	 * This method uses code from StringParser to parse all the items with asterisks and stores it to the 
	 * array handoutStrings.
	 * @throws FileNotFoundException
	 */
	private static void parseHandout() throws FileNotFoundException{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the filename or path of the handout");
		String fileName = keyboard.next();
		
		System.out.println("You typed: " + fileName);	
		File input = new File(fileName);
		
		StringParser parser = new StringParser(input);
		
		parser.getAllStrings();
		
		handoutStrings = parser.getArray();
		
	}
	
	
	private static void toStringSave() throws FileNotFoundException{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What would you like to name the file? (name.txt)");
		String filename = keyboard.next();
		
		/*
		 * Deciding to include locations an materials
		 */
		boolean includeLocations = false;
		System.out.println("Would you like to include locations & materials? 1: Yes 0: No");
		int input = keyboard.nextInt();
		if(input == 1){
			includeLocations = true;
		}

		
		PrintWriter output = new PrintWriter(filename);
		
		for(int i = 0; i < deck.size(); i++){
			Card card = deck.get(i);
			String[] contents = card.getContents();
			
			for(int k = 0; k < contents.length; k++){
				if(includeLocations){
					if(!contents[k].isEmpty()){
						output.print(contents[k]);
					}
				} else {
					if(!contents[k].isEmpty() && k != 3 || k != 4){
						output.print(contents[k]);
				}
				}
				
				
			}
			output.println();
		}
		output.close();
	}
	
	
	/**
	 * This method creates a file with labeled items. It will not output anything for cards which have
	 * a location or a material. April Eisman does not test for these. 
	 * @throws FileNotFoundException
	 */
	private static void createFile() throws FileNotFoundException{
		
		//Boolean so user can chose not to include locations and materials.
		boolean includeLocationsMaterials = false;
		
		//The Scanner
		Scanner userIn = new Scanner(System.in);
		
		//User prompts
		System.out.println("What would you like to name the file?\n(use the format 'name.txt')");
		String nameOfFile = userIn.next();
		System.out.println("Would you like to include materials and locations? 1: yes, 0: no.");
		
		if(userIn.hasNextInt()){
			if(userIn.nextInt() == 1){
				includeLocationsMaterials = true;
			
			}
			
		}
		
		//Creating the actual file output
		PrintWriter output = new PrintWriter(nameOfFile);
		
		
			
		for(int i = 0; i < deck.size(); i++){
			Card card = deck.get(i);
			String[] contents = card.getContents();
			
			for(int k = 0; i < contents.length; k++){
				String currentItem = contents[k];
					output.println(currentItem);
				}
			}
			output.print("\n");
				
		userIn.close();
		output.close();
	}
	

	/**
	 * This method 
	 */
	private static void getFormat(){
		
		
		for(int i = 0; i < deck.size(); i++){
			Card card = deck.get(i);
			String[] cardContents = card.getContents();
			
			
			for(int k = 0; k < cardContents.length; k++){
				if(!cardContents[k].isEmpty()){
					String currentItem = cardContents[k];
					currentItem = card.getLabels(k) + currentItem.trim() + "\n";
					card.replaceItem(k, currentItem);
					
				}
			}
		}
		
	}
}
