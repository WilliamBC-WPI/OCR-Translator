/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Copyright ©2016-2017 Gary F. Pollice
 *******************************************************************************/
package ocr;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This class has a single method that will translate OCR digits to a string of
 * text digits that correspond to the OCR digits.
 * 
 * @version Mar 13, 2019
 */
public class OCRTranslator
{

	//Top of OCR digits in order 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	private String[] topBank = {"  _  ", "   ", "  _  ", " _  ", "     ", "  _  ", "  _  ", " _  ", "  _  ", "  _  "};

	//Middle of OCR digits in order 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	private String[] middleBank = {" | | " , " | ", "  _| ", " _| ", " |_| ", " |_  ", " |_  ", "  | ", " |_| ", " |_| "};

	//Bottom of OCR digits in order 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	private String[] bottomBank = {" |_| ", " | ", " |_  ", " _| ", "   | ", "  _| ", " |_| ", "  | ", " |_| ", "   | "};

	/**
	 * Default constructor. You may not add parameters to this. This is
	 * the only constructor for this class and is what the master tests will use.
	 */
	public OCRTranslator()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Takes in OCR digits as three lines and translates them into a string of numbers
	 * @param top String representing the top line of OCR input
	 * @param middle String representing the middle line of OCR input
	 * @param bottom String representing the bottom line of OCR input
	 * @return retString, String of translated numbers
	 */
	public String translate(String top, String middle, String bottom)
	{
		// To be implemented
		//TODO Check for empty strings on input
		//TODO check for different length inputs
		//Call this on for each number, using each part of the number
		if(!sameLength(top, middle, bottom)) {
			throw new OCRException("Invalid input format.");
		}
		//Index, Integer in this hashmap
		HashMap<Integer,Integer> indexMap = new HashMap<>();
		for(int i = 0; i < topBank.length; i++) {
			ArrayList<Integer> matchedList = matchIndex(topBank[i], middleBank[i], bottomBank[i], top, middle, bottom);
			for(int s : matchedList) {
				indexMap.put(s, i);
			}
		}
		String retString = "";
		List sortedKeys=new ArrayList(indexMap.keySet());
		Collections.sort(sortedKeys);
		for(Object key : sortedKeys) {
			retString += Integer.toString(indexMap.get(key));
		}
		System.out.println(retString);
		return retString;
	}
	//Add a space to the input string, that way all the patterns we're searching for can have a space at the end of them.

	/**
	 * A function that find a specified pattern in a string and creates a list of indexes from where
	 * the patterns were found
	 * @param pattern, the pattern (Either top, middle, or bottom part) of a number
	 * @param searchBank, the whole, top, middle, or bottom string to find the pattern in
	 * @return foundIndex, a arraylist of indexes where the number might exist
	 */
	public ArrayList<Integer> matchPattern(String pattern, String searchBank) {
		searchBank = " " + searchBank + " ";
		ArrayList<Integer> foundIndex = new ArrayList<>();
		for(int i = 0; i < searchBank.length(); i++) {
			int index = searchBank.indexOf(pattern, i);
			if(index >= 0 && !foundIndex.contains(index)) {
				foundIndex.add(index);
			}
		}
		return foundIndex;
	}

	/**
	 * Pattern is 1 Top, 1 Mid, 1 Bottom
	 * 3 Array Lists, check to see if they all contain the same index
	 * This function gets run 9 times.
	 */
	/**
	 * Function takes in the top, middle and bottom pattern of a specified number.
	 * Creates arraylists of where the pattern matches for the top, middle and bottom
	 * Looks for overlaps in the three array lists, that is where the number exists in the input string
	 * @param topPattern
	 * @param middlePattern
	 * @param bottomPattern
	 * @param top
	 * @param middle
	 * @param bottom
	 * @return findTop, the list of all indexes the number appears.
	 */
	public ArrayList<Integer> matchIndex(String topPattern, String middlePattern, String bottomPattern, String top, String middle, String bottom) {
		ArrayList<Integer> findTop = matchPattern(topPattern, top);
		ArrayList<Integer> findMiddle = matchPattern(middlePattern, middle);
		ArrayList<Integer> findBottom = matchPattern(bottomPattern, bottom);
		//TODO make sure this works
		findTop.retainAll(findMiddle);
		findTop.retainAll(findBottom);
		System.out.println();
		return findTop;
	}

	
	/**
	 * Translate a string of OCR digits to a corresponding string of text
	 * digits. OCR digits are represented as three rows of characters (|, _, and space).
	 * @param top the top row of the OCR input
	 * @param middle the middle row of the OCR input
	 * @param bottom the third row of the OCR input
	 * @return a String containing the digits corresponding to the OCR input
	 * @throws OCRException on error as noted in the specification
	 */
	public boolean sameLength(String top, String middle, String bottom) throws OCRException{
		if(top.length() != middle.length() || top.length() != bottom.length()) {
			return false;
		}
		return true;
	}
}
