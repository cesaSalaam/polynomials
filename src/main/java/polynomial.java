
package main.java;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.*; 
public class polynomial {

	private ArrayList<Term> poly = new ArrayList<Term>();
	private String[] tokens;
	private String StringPoly;
	
	public polynomial() {
		
	//InputStream prop_input = null;
//		try
//		{
//			prop_input = new FileInputStream("src/main/java/resources/phone.properties");
//			
//			prop.load(prop_input);
//			
//			path = prop.getProperty("path"); // getting the location of the directory.txt file
//			
//			System.out.print(path);
//		} catch (IOException err) {
//			
//			// TODO Auto-generated catch block
//			
//			err.printStackTrace();
//			
//		} finally {
//			
//			if (prop_input != null) {
//				
//				try
//				{
//					prop_input.close();
//					
//				} catch (IOException err)
//				{
//					err.printStackTrace();
//				}
//			}
//		}
	}
	
	public void readPolynomialsFromText(){
		try{
		File file = new File("/Users/lifoma/Desktop/polynomials/src/main/java/resources/polynomials.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()){
				String line = scanner.nextLine();
		    	System.out.println(line);
		        tokens = line.split(";");
		        String last = tokens[tokens.length - 1];
		        System.out.println(tokens[0]);
		} 
		scanner.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
