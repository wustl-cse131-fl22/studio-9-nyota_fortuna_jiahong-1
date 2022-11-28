package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	//instance variables
		private String firstName;
		private String lastName;
		private int id;
		
		private int attemptedCredits;
		private int passingCredits;
		private double totalGradeQualityPoints;
		private double bearBucksBalance;
		private double qualityPoints;
		
		
		
		//constructor 
		/**
		 * Constructor for the Student Object
		 * 
		 * @param firstName takes in the String firstName
		 * @param lastName takes in the String lastName
		 * @param id takes in the id of the student
		 */
		public Student(String firstName, String lastName, int id) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
		}
		
		
		/**
		 * Gets the full name of an object of the Student Class
		 * @return the first and last name of a Student object
		 */
		//get the fullName
		public String getFullName() {
			return this.firstName + " " + this.lastName;
		}
		
		/**
		 * Returns the id of a Student object
		 * @return the id of a student object
		 */
		//get the Id
		public int getId() {
			return this.id;
		}
		
//		//updates the attempted credits and quality points
//		public void submitGrade(double grade, int credits) {
//			this.attemptedCredits += credits; //updates the Attempted credits so we can eventually
//			this.qualityPoints = grade * attemptedCredits;
	//
//		}
		/**
		 * Takes in a course grade and credits and updates the students GPA accordingly
		 * @param grade course grade as a value between 0-4
		 * @param credits number of credits for a course
		 */
		public void submitGrade(double grade, int credits) {
			this.qualityPoints += credits*grade;  //accumulates the total number of quality points
			if (grade >= 1.7) {
				passingCredits += credits; // accumulates the total numb of quality points 
			} //as long as the grade is greater than or equal to 1.7
			this.attemptedCredits += credits; //accumulates the total number of credits
		}
		
		/**
		 * Returns the number of attempted credits(that is, credits for all Submitted grades)
		 * @return the number of attempted credits
		 */
		//returns the total attempted credits
		public int getTotalAttemptedCredits() {
			return this.attemptedCredits;
		}
		
//		returns the total passing credits
		/**
		 * Getter for the total passing credits
		 * @return the total passing credits
		 */
		public int getTotalPassingCredits() {
			return this.passingCredits;
		}
		
		//returns the accumulated gpa
		/**
		 * Returns the gpa
		 * @return the gpa
		 */
		public double calculateGradePointAverage() { 
			double gpa = this.qualityPoints / this.attemptedCredits;
			return gpa;
		}
		
		//returns the student standing class based on how many credits they have
		/**
		 * Returns the student class based on how many credits they have
		 * @return the grade they are in (ex: first year, sophmore, etc.) based on their num of credits
		 */
		public String getClassStanding() {
			if (this.passingCredits < 30) {
				return "First Year";
			} else if (this.passingCredits >= 30 && this.passingCredits < 60) {
				return "Sophomore";
			} else if (this.passingCredits >= 60 && this.passingCredits < 90) {
				return "Junior";
			} else {
				return "Senior";
			}
		}
		
		//returns true if student is elligible for PhiBetaKappa (false otherwise)
		//we can check the gpa by simply calling the calculategpa() method
		/**
		 * Returns true if the student is ellible for PhiBetaKappa (false if otherwised)
		 * @return boolean if the student is elligible for PhiBetaKappa
		 */
		public boolean isEligibleForPhiBetaKappa() {
			if ((attemptedCredits >= 98 && this.calculateGradePointAverage() >= 3.60) || (attemptedCredits >= 75 && this.calculateGradePointAverage() >= 3.80)) {
				return true;
			} else {
				return false;
			}
		}
		
		// increases the Bear Bucks balance by amount
		/**
		 * Increases the Bear Bucks balance by the amouont given
		 * @param amount amount you want the Bear Bucks balance to increase by
		 */
		public void depositBearBucks(double amount) {
			bearBucksBalance += amount;
		}
		
		
		//decreases the Bear Bucks balance by amount
		/**
		 * Decreses the Bear Bucks balance by the given amount(parameter)
		 * @param amount the amount the user wants to decrese the bear buck balance
		 */
		public void deductBearBucks(double amount) {
			bearBucksBalance-= amount;
		}
		
		//returns the Bear Bucks balance
		/** 
		 * Getter to return the current bear bucks balance
		 * @return the current Bear Bucks Balance
		 */
		public double getBearBucksBalance()  {
			return this.bearBucksBalance;
		}
		
		
		//Zero out the Bear Bucks balance
	//the student's Bear Bucks balance should be zeroed out as a result of calling this method.
	//if the bearBucksBalance >10 the money back we get is the bearBucksBalance minus 10 
	//if the bearBucksBalnce  is less than or equal to 10 you get no money back lawlz 
		/**
		 * Zeros out the bear bucks balance. If the bear bucks balance is greater than or equal to 10 the cashback
		 * is the current Bear Bucks Balance minus 10. If the balance is less than 10 then you get no money back
		 * @return
		 */
		public double cashOutBearBucks()  {
			double moneyBack = 0;
			if (bearBucksBalance <= 10) {
				bearBucksBalance = 0;
			} else {
				moneyBack = bearBucksBalance-10;
				bearBucksBalance = 0;
				
			}
			
			return moneyBack;
		}
		//first name is passed through
		//the other parent is passed through (as a reference to the student class)
		//The child student that is created and returned by the weekend
		//This refers to the current object reference (Student 1)
		//We are passing in a second object (Student2/the other parent) so we cannot use the this keyword b/c that
		//would reference student 1 and not student 2
		//I created student 3 (legacy) student and returned it
		/**
		 * first name is passed through
		the other student(other parent) is passed through (as a reference to the student class)
		The child student that is created and returned
		"this" refers to the current object reference (Student 1)
		We are passing in a second object (Student2/the other parent) so we cannot use the "this" keyword b/c that
		would reference student 1 and not student 2
		I created student 3 (legacy) student and returned it
		 * @param firstName first name of the student
		 * @param other the other student 
		 * @param isHyphenated boolean if the child's last name should be hyphenated or not
		 * @param id the student's id
		 * @return the newly created legacy student object
		 * 
		 */
		 public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
			if (isHyphenated) {
				Student legacy = new Student(firstName, this.lastName + "-" + other.lastName ,id);
				double legacyBearBucks = this.cashOutBearBucks() + other.cashOutBearBucks();
				legacy.depositBearBucks(legacyBearBucks);
				return legacy;
			} else {
				Student legacy = new Student(firstName, this.lastName, id);
//				legacy.depositBearBucks(this.getBearBucksBalance() + other.getBearBucksBalance());
				double legacyBearBucks = this.cashOutBearBucks() + other.cashOutBearBucks();
				legacy.depositBearBucks(legacyBearBucks);
				return legacy;
			}

		}
		 
		 //Returns the full name and the id!
		 /**
		  * Returns the full name and id
		  */
		 public String toString() {
			 return this.getFullName() + this.id;
		 }
}
