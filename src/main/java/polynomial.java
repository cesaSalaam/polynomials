
package main.java;
import java.io.*;
import java.util.*; 

/**
 * @author Cesa Salaam
 * The polynomial class represents a list of objects of type Term
 * polynomial has 9 methods: readPolynomialsFromText(), addingTermPoly(), createTerm(), product(), toString(), sortPoly(), insert(), reverse(), delete().
 * polynomial has private 3 data members: "tokens" of String[], "poly" of type ArrayList<Term>, and "polynomials" of type ArrayList<ArrayList<Term>>.
 */

public class polynomial {
	
	private ArrayList<ArrayList<Term>> polynomials; //This data member is used to store the polynomials. It is a 2D array list. The inner array list holds the polynomials.
	
	private ArrayList<Term> poly; //This data member is used to the terms of the polynomial.
	
	private String[] tokens; //This is used to store each line of the polynomials.txt file.
	
	
	public polynomial() {
		poly = new ArrayList<Term>();
		polynomials = new ArrayList<ArrayList<Term>>(); 
		
	} //Class constructor
	
	
	public void readPolynomialsFromText(){ 
		/**
		 * The readPolynomialsFromText() reads in data from the polynomials.txt file.
		 * @param this function takes no parameters.
		 * @return void.
		 */
		try{
			File file = new File("/Users/lifoma/Desktop/polynomials/src/main/java/resources/polynomials.txt");
			
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()){ // loops through file. line by line
				
				String line = scanner.nextLine();
				
				tokens = line.split(";"); // splitting the line from the text file on the ";" char
				
		        addingTermPoly(tokens);  //adding the tokens to the function addingTermPoly()
			} 
			
			tokens = new String[0]; //resetting the tokens so that the new ones wont be added to the old ones.
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	public void addingTermPoly(String[] tokens){
		/**
		 * The addingTermPoly(String[] tokens) adds a array of terms.
		 * @param this function in a String array.
		 * @return void.
		 */
		
		for(int i = 1;i<tokens.length;i++){
			//for loop to go through each token. Starts at 1 because the 0 index holds p1 and not a number
			Term tempTerm = new Term(0,0); //creating new term with dummy numbers
			
			tempTerm = createTerm(tokens[i],tokens[i + 1]); 
			//Passing the first pair of numbers into the create term function and setting the tempTerm variable to the term returned from the createTerm function
			if (tokens[i].contains("-")){ //checks if the element in the tokens at index i has a minus sign.
				//if it does it sets the sign of the term to false(negative)
				tempTerm.setSign(false);
				
				String[] temp = tokens[i].split("-"); //splits the element with the minus sign.
				
				tokens[i] = temp[1]; //resets the element at position i to the new element in temp without the minus sign.
				
				tempTerm.setCoe(Integer.valueOf(tokens[i])); // changes the coefficient of the term to the new value with out the minus sign
				
				poly.add(tempTerm); // adds the term to the arrayList called poly
				
				poly = sortPoly(poly); // send poly to the sort function to put the arraylist into the correct order according to the exponents.
				
			}else{
				//if there is no minus sign in the element
				tempTerm.setSign(true); // sets the sign of the term to true (positive)
				poly.add(tempTerm);  // adds the term to the arrayList called poly
				poly = sortPoly(poly);// send poly to the sort function to put the arraylist into the correct order according to the exponents.
			}
			i++; //increments again so that it will go to the next coefficient, others wise it will only move to the next exponent and treat it like a coe
		}
		polynomials.add(poly); // adding the poly to the polynomials arraylist which stores all of the polynomials
		poly = new ArrayList<Term>(); // resets poly to empty.	
	}
	
	
	public Term createTerm(String coe, String exp){
		/**
		 * The createTerm(String coe, String exp) creates a new term from the parameters passed in.
		 * @param this function takes in two String parameters.
		 * @return Term, returns a Term.
		 */
		Term tempTerm = new Term(Integer.valueOf(coe), Integer.valueOf(exp)); // Converts input to integers and creates new term
		return tempTerm; // returns the Term
	}
	
	
	private String product(){

		/**
		 * The product() converts each polynomial to a string.
		 * @param this function takes in no parameters.
		 * @return String.
		 */
		String polynomial = new String(); // Creates a String name polynomial
		
		for (int i = 0; i <polynomials.size();i++){ // loops through element of the polynomial arraylist
			polynomial += "p"+ ++i +"(X) = "; //adds pi(x) to string 
			--i;
			for (int k = 0; k<polynomials.get(i).size(); k++){ // loops through the inner arrayList of each element
				polynomial += polynomials.get(i).get(k).toString(); //covert each term to a string and adds the string to the polynomial string
			}
			polynomial += "\n"; //new line character
		}
		return polynomial; //returns string 
	}
	
	
	
	public String toString(){
		/**
		 * The toString() calls the product function and returns the string the the product function returns.
		 * @param this function takes in none.
		 * @return none.
		 */
		return product();
	}
	
	
	private ArrayList<Term> sortPoly(ArrayList<Term> array) {
		/**
		 * The sortPoly(ArrayList<Term> array) implements the bubble sort on the terms..
		 * @param this function takes an arraylist.
		 * @return returns ArrayList<Term>.
		 */
        int n = array.size();// setting n to the length of the array
        int k; //instantiating var k
        for (int m = n; m >= 0; m--) { // looping from top to bottom of the array
            for (int i = 0; i < n - 1; i++) { //going through the each element
                k = i + 1; // moving one element above where i is at
                if (array.get(i).getEx() > array.get(k).getEx()) { // checks if exponent at position i is greater than exponent at position k
                	//if it element @ position i is greater then swap the two element
                    Collections.swap(array,i,k);
                }
            }
        }
        return array; // returns array after sorting is done.
    }
	
	
	public void insert(String coe, String exp, int polynomialNum){
		/**
		 * The insert(String coe, String exp, int polynomialNum) function inserts a new term into the specified polynomial.
		 * @param this function takes 3 parameters String coe (the coefficient), String exp (the exponent), int polynomialNum (the specified polynomial).
		 * @return void.
		 */
		if (polynomialNum >= 0 && polynomialNum < polynomials.size()){ // makes sure the the polynomialNum is valid
			Term tempTerm = new Term(0,0); //creates new term with dummy values
			tempTerm = createTerm(coe,exp); // sets the tempTerm to the value returned from the createTerm function.
			
			if (coe.contains("-")){ //checks if the element in the tokens at index i has a minus sign.
				//if it does it sets the sign of the term to false(negative)
				
				tempTerm.setSign(false);
				
				String[] temp = coe.split("-"); //splits the element with the minus sign.
				
				coe = temp[1];  //resets the coe to new element in temp without the minus sign.
				tempTerm.setCoe(Integer.valueOf(coe)); // changes the coefficient of the tempTerm
				polynomials.get(polynomialNum).add(tempTerm); // adding the term to the correct polynomial
				polynomials.set(polynomialNum,sortPoly(polynomials.get(polynomialNum)));
				
			}else{
				tempTerm.setSign(true); // sets the sign to true(positive)
				polynomials.get(polynomialNum).add(tempTerm); // adding the term to the correct polynomial
				polynomials.set(polynomialNum,sortPoly(polynomials.get(polynomialNum)));
			}
		} 
		else{
			//if polynomialNum is not valid. 
			//prints error message
			System.out.print("no p"+polynomialNum + " Polynomial");
		}
	}
	
	
	
	public void reverse(int polynomialNum){
		/**
		 * The reverse(int polynomialNum) reverses a particular polynomial.
		 * @param this function takes an integer to specify which polynomial is being reversed.
		 * @return void.
		 */
		if (polynomialNum >= 0 && polynomialNum < polynomials.size()){ // checks if polynomialNum is a valid number
			Collections.reverse(polynomials.get(polynomialNum)); // reverses the polynomial
		}else{
			//if polnomialNum is invalid print out error message
			System.out.println("p" + polynomialNum+""
					+ "(x)"+" does not exist. And cant be reversed.");
		}
	}
	
	public void delete(String coe, String exp,int polynomialNum){
		/**
		 * The delete(int coe, int exp,int polynomialsNum) deletes a particular term from a polynomial.
		 * @param this function takes an integer to specify which polynomial a term is being deleted from, the coefficient and exponent of the term that being deleted.
		 * @return void.
		 */
			
		if (polynomialNum >= 0 && polynomialNum < polynomials.size()){//checks if polynomialNum is a valid number
			Term tempTerm = new Term(0,0);
			tempTerm = createTerm(coe,exp);
			if (coe.contains("-")){ //checks if the element passed in the param has a minus sign.
				//if it does it sets the sign of the term to false(negative)
				
				tempTerm.setSign(false);
				
				String[] temp = coe.split("-"); //splits the element with the minus sign.
				
				coe = temp[1];  //resets the coe to new element in temp without the minus sign.
				tempTerm.setCoe(Integer.valueOf(coe)); // changes the coefficient of the tempTerm
				
			}else{
				tempTerm.setSign(true); // sets the sign to true(positive)
			}
			
			for (int k = 0; k<polynomials.get(polynomialNum).size();k++){ // loops through the specified polynomial 
				//checking for the term that matches the parameter coefficient and exponent
				if ((Integer.compare(tempTerm.getCoe(),Integer.valueOf(polynomials.get(polynomialNum).get(k).getCoe())) == 0) && (Integer.compare(tempTerm.getEx(),Integer.valueOf(polynomials.get(polynomialNum).get(k).getEx())) == 0)){
					if (tempTerm.getSign() == polynomials.get(polynomialNum).get(k).getSign() ){	
					polynomials.get(polynomialNum).remove(k); // removing the term 
					return;
					}
				}
			}
		}else{
		//if polnomialNum is invalid print out error message
		System.out.println("p" + polynomialNum+""
				+ "(x)"+" does not exist.");
	}
	}
	
}
