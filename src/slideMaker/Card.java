package slideMaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class encapsulates the code for individual note cards
 * @author Corbin K. Zahrt
 *
 */
public class Card {
	
	/**
	 * Stores the total number of slots available in a card object. 
	 */
	private static final int CARD_CAPACITY = 8;
	/**
	 * This array holds all the strings contained by the given instance of a card object.
	 */
	private ArrayList <String> stringHolder = new ArrayList<>();
	
	
	/**
	 * An array that I have created to replace this class's huge number of instance variables
	 * to help condense the space the growing number of methods this class is accumulating.
	 * Each index stores a specific kind of information. 
	 * 0: artist, 1: date, 2: title, 3: location, 4: material, 5: period, 6: vocabulary term, 7: definition. 
	 */
	private String[] contents = new String[CARD_CAPACITY];

	/**
	 * This array is meant as a companion to <code>contents</code>. It stores the label for each index. 
	 */
	private String[] labels = 
		{
			"Title\t\t", 	
			"Artist\t\t", 
			"Location\t",	
			"Date\t\t", 	
			"Material\t", 	
			"Period:\t\t",	
			"Vocabulary\t", 
			"Definition\t"
			};

	
	/**
	 * The constructor. Accepts a string created by the StringParser class and breaks up the items into 
	 * new strings using "," as a delimiter. It then adds each string to the array stringHolder. 
	 * @param givenItem
	 */
	public Card(String givenItem){
		Scanner breaker = new Scanner(givenItem);
		
		for(int i = 0; i < CARD_CAPACITY; i++){
			contents[i] = "";
		}
		
		breaker.useDelimiter(",");
		while(breaker.hasNext()){
			stringHolder.add(breaker.next());
			}
		}
		
	
	
	//The set methods
	
	/**
	 * Set 0: artist, 1: date, 2: title, 3: location, 4: material, 5: period, 6: vocabulary term, 7: definition
	 * @param index
	 * @param input
	 */
	public void setItem(int index, String input){
		if(!contents[index].isEmpty()){
			contents[index] = contents[index] + "," + input;
		}else {
			contents[index] = input;
		}
	}
	
	/**
	 * This method replaces the array of contents completely. 
	 * @param input
	 */
	public void setContents(String[] input){
		contents = input;
	}
	//End of the set methods.
	
	
	
	//The get methods
	
	/**
	 * This method returns the String at the given index.
	 * @param index
	 * @return
	 */
	public String getItem(int index){
		return contents[index];
	}
	
	/**
	 * Returns the array of this cards contents.
	 * @return
	 */
	public String[] getContents(){
		return contents;
	}
	
	public String getLabels(int index){
		return labels[index];
	}
	
	/**
	 * Returns the array of labels
	 * @return
	 */
	public String[] getLabelsArray(){
		return labels;
	}
	
	/**
	 * Returns a list of all strings contained by the card. 
	 * @return
	 */
	public ArrayList <String> getArray(){
		return stringHolder;
	}
	
	/**
	 * Returns all items held by the primary array as one string. 
	 * @return stringHolder.toString();
	 */
	public String getAllStrings(){
		return stringHolder.toString();
	}
	
	/**
	 * Returns the size of the Card's array of contents. 
	 * @return
	 */
	public int length(){
		return stringHolder.size();
	}
	
	//End of the get methods
	
	//The boolean methods
	/**
	 * Returns true if item at index has something in it. 
	 * @param index
	 * @return
	 */
	public boolean hasItem(int index){
		return !contents[index].isEmpty();
			
		}
	
	//end of the boolean methods
	
	
	
	//Start of the replace methods
	/**
	 * Replaces the item at the given index with <code>input</code>
	 * @param index
	 * @param input
	 */
	public void replaceItem(int index, String input){
		contents[index] = input;
	}
	
	
	//End of replace methods
	
	//Begin the Append methods
	
	/**
	 * Appends <code>input</code> to the contents of the <code>String</code> at <code>index</code>,
	 * @param index
	 * @param input
	 */
	public void appendItem(int index, String input){
		contents[index] = contents[index] + input;
	}
	
	//End the Append Methods
	
	
	

}
