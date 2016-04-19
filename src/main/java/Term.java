package main.java;

public class Term {
	
		private int coeficient;
		private int exponent;
		public Term(int coeficient, int exponent){
			this.coeficient = coeficient;
			this.exponent = exponent;
		}
		
		public int getCoe(){
			return coeficient;
		}
		public int getEx(){
			return exponent;
		}
		
		public String toString(){
			String termString;
			if (this.exponent > 1){
				termString = String.valueOf(this.coeficient) + "X^" +String.valueOf(this.exponent);
				return termString;
			} else if (this.exponent == 1){
				termString = String.valueOf(this.coeficient) + "X";
				return termString;
			} else if(this.exponent == 0 ){
				termString = String.valueOf(this.coeficient);
				return termString;
			}
			return "your exponent is not valid";
		}
		

	

	

}
