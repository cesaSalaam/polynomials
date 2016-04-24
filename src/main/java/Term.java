package main.java;

public class Term{
	/**
	 * @author Cesa Salaam
	 * The term class represents a  of coefficient and exponent 
	 * polynomial has 9 methods: getCoe(), getEx(), setCoe(int value), toString().
	 * polynomial has private 3 data members: "coeficient" of type int, "exponent" of type int, and "sign" of type boolean.
	 */
	
		private int coeficient; // coefficient of term
		private int exponent; //exponent of term
		private boolean sign; // determines whether its positive or negative. true is positive; false is negative'
		
		public Term(int coeficient, int exponent){
			/**
			 * The class constructor Term(int coeficient, int exponent) assign parameters to proper data members
			 * @param this function takes an int coeficient, and int exponent.
			 * @return no return type.
			 */
			this.coeficient = coeficient;
			this.exponent = exponent;
		}
		
		public int getCoe(){
			/**
			 * The class function getCoe() is a getter for the coefficient.
			 * @param none.
			 * @return int.
			 */
			return coeficient;
		}
		public int getEx(){
			/**
			 * The class function getEx() is a getter for the exponent.
			 * @param none.
			 * @return int.
			 */
			return exponent;
		}
		public void setCoe(int value){
			/**
			 * The class function setCoe() is a setter for the coefficient.
			 * @param int value.
			 * @return int.
			 */
			this.coeficient = value;
		}
		public boolean getSign(){
			/**
			 * The class function getTerm() is a getter for the sign.
			 * @param none.
			 * @return boolean.
			 */
			return sign;
		}
		
		public void setSign(boolean value){
			/**
			 * The class function setSign(boolean value) is a setter for the sign.
			 * @param boolean value.
			 * @return void.
			 */
			if (value == true){
				//sets to positive if value == true
					this.sign = value;
			} else{
				//sets to negative if the value is false
				this.sign = value;
			}
		}
		
		public String toString(){
			/**
			 * The class function toString() converts the term to a string and assigns a plus or minus sign.
			 * @param boolean value.
			 * @return void.
			 */
			String termString;
			if(this.sign == true){
				termString = "+";
			}else{
				termString = "-";
			}
			if (this.exponent > 1){
				termString += String.valueOf(this.coeficient) + "X^" +String.valueOf(this.exponent);
				return termString;
			} else if (this.exponent == 1){
				termString += String.valueOf(this.coeficient) + "X";
				return termString;
			} else if(this.exponent == 0 ){
				termString += String.valueOf(this.coeficient);
				return termString;
			}
			return "your exponent is not valid";
		}

}
