package main.java;
//This is the driver program (testing program) for the polynomial and term classes.
//Adds polynomials from a file
//inserts new term into polynomial
//deletes from a polynomial
//reverses a polynomial
//prints a polynomial
public class driver {
	public static void main(String[] args) {
		
		polynomial poly = new polynomial();
		
		poly.readPolynomialsFromText();
		
		System.out.print("Polynomials: \n" + poly.toString());
		
		System.out.print("inserted '3x^9' into the p2(x) polynomial: \n");
		
		poly.insert("3", "9",1);
		
		System.out.print(poly.toString());
		
		System.out.print("reversed the p3(x) polynomial: \n");
		
		poly.reverse(2);
		
		System.out.print(poly.toString());
		
		System.out.print("deleted '-7x^9' from the p1(x) polynomial: \n");
		
		poly.delete("6","2",0);
		
		System.out.print("Polynomials: \n "+ poly.toString());
	}
}
