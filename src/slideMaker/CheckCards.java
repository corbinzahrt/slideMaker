package slideMaker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class encapsulates the code for editing created cards.
 * @author Corbin K. Zahrt
 *
 */
public class CheckCards {
	
	private Card theCard;
	private ArrayList<String> items = new ArrayList <>();
	
	
	public CheckCards (Card card){
		theCard = card;
		items = theCard.getArray();
	}
	
	public void editCard(){
		String currentItem = "";
		
		for(int i = 0; i < theCard.length(); i++){
			Scanner keyboard = new Scanner(System.in);
			currentItem = items.get(i);
			String[] lables = theCard.getLabelsArray();
			
			/*
			 * I added this as a way of looking at the card I am currently editing. 
			 */
			displayAssigned();
			
			System.out.println("Enter a number to assign a type for: " + currentItem);
			for(int k = 0; k < lables.length; k++){
				String currentString = lables[k];
				currentString = currentString.replaceAll("\\s", "");
				
				System.out.print(k + 1 + ": " + currentString + ", ");
			}
			int userIn = keyboard.nextInt();

		
			userIn = userIn - 1;
			if(userIn >= -1 && userIn < 6){
				theCard.setItem(userIn, currentItem);
			} else{
				System.out.println("You did not enter a valid input, do that next time.");
				}
			
			
		}
		
		
	}
	
	/**
	 * This method is a helper. It is meant to keep track of whether a given string in the card has been assigned
	 * to any type. Its intended purpose is to make it possible for me to display what the user has told the
	 * program about the current card thus far. 
	 */
	private void displayAssigned(){
		System.out.println("\n\n\n----------------------BEGIN CONTENTS-----------------------");
		String[] contents = theCard.getContents();
		
		for(int i = 0; i < contents.length; i++){
			if(!contents[i].isEmpty()){
				String fastHolder = contents[i];
				System.out.println(theCard.getLabels(i)+ fastHolder.trim());
				
			}
		}
		
		System.out.println("-----------------------END CONTENTS------------------------\n\n\n");
	}
	
	//needs to create an array that holds each item.
	//needs to be able to assign elements of that array to the types that exist in the Card class. 
	//TO DO
	//TODO Create a system which takes each string contained in a card object and presents them with the following:
	/*
	 * One: displays each string in a card object one at a time. 
	 * Two: Asks the user to match each string to a type that is displayed on the screen (e,g. Artist, date, etc)
	 * Three: Matching is achieved by the user inputing a number which appears next to each type.
	 */

}
