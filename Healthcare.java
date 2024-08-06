// Name: Ong Guo Xiang, Vincent
// Full Time
// Tutorial Group: T07F
//
// File Name: Vincent_A2.java
//
// Declaration: I declare that this is my own work

import java.util.Scanner;
import java.io.IOException;
import java.io.File;


enum Month  {Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec}

class Date{
    
    //private instance variables
    private int day;
    private Month month;
    private int year;
    
    //default constructor
    public Date ()
    {
        day = 1;
        month = Month.Jan;
        year = 2021;
    }
    
    //other constructor
    public Date (int day, Month month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    //copy constructor
    public Date(Date d)
    {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }
    
    //Accessor method
    public int getDay()
    {
        return day;
    }
    
    public Month getMonth()
    {
        return month;
    }
    public int getYear()
    {
        return year;
    }
    
    //mutator method
    public void setDate(int day, Month month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
}
//done top part


class HealthProfile{
    // declaring instance variables
    private String firstName;
    private String lastName;
    private Date dob;
    private double weight;
    private double height;
    private int currentYear;
    
    //default constructor
    public HealthProfile(String firstName, String lastName, Date dob, double weight, double height, int currentYear)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.weight = weight;
        this.height = height;
        this.currentYear = currentYear;
        
    }
    
    //copy constructor
    public HealthProfile(HealthProfile hr)
    {
        this (hr.firstName, hr.lastName, hr.dob, hr.weight, hr.height, hr.currentYear);
       
    }
    
    // Accessor methods
    public String getfirstName()
    {
        return firstName;
    }

    public String getlastName()
    {
        return lastName;
    }
    
    public Date getDob()
    {
        return dob;
    }
    
    public double getWeight()
    {
        return weight;
    }
    
    public double getHeight()
    {
        return height;
    }
    
    public int getcurrentYear()
    {
        return currentYear;
    }
    
    
    // Mutator methods
    public void setfirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setlastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setDob(Date dob)
    {
        this.dob = dob;
    }
    
    public void setcurrentYear(int currentYear)
    {
        this.currentYear = currentYear;
    }
    
     public void setBMIInfo(double weight, double height)
    {
        this.weight = weight;
        this.height = height;
    }
    
    // non static public methods
    public int getAge()
    {
        int age = getcurrentYear() - dob.getYear();
        return age;
    }
    
    private int getmaxHR()
    {
        int maxhr = 220 - getAge();
        return maxhr;
    }
    
    private double getminTargetHR()
    {
        double minthr = getmaxHR() * 0.50;
        return minthr;
    }
    
      private double getmaxTargetHR()
    {
        double maxthr = getmaxHR() * 0.85;
        return maxthr;
    }
    
       private double getBMI()
    {

        double bmi = weight/(height * height);
        return bmi;
    }
    
    public void displayInfo()
    {
       System.out.printf("\nName: %s, %s", firstName, lastName);
       System.out.printf("\nDate of birth: " + dob.getDay() + " "+ dob.getMonth() + " " + dob.getYear());
       System.out.printf("\nYour weight: %.1f kg", weight);
       System.out.printf("\nYour height: %.1f meter", height);
       System.out.printf("\nCurrent Year: %d", currentYear);
       System.out.printf("\nYour age: %d years old\n",getAge());
       System.out.printf("\nClinic analysis, base on your age: \n");
       System.out.printf("\t1. Your maximum heart rate is %d%n", getmaxHR());
       System.out.printf("\t2. Your minimum target heart rate is %.2f%n",getminTargetHR());
       System.out.printf("\t3. Your maximum target heart rate is %.2f%n", getmaxTargetHR());
       System.out.printf ("\nYour BMI: %.1f%n", getBMI());

       System.out.printf("\tWeight category             Range");
       System.out.printf("\n\tUnderweight / too low       Below 18.5");
       System.out.printf("\n\tHealthy range               18.5 - 25");
       System.out.printf("\n\tOverweight                  25 - 30");
       System.out.printf("\n\tObese                       30 - 35");
       System.out.printf("\n\tServere Obesity             35 - 40");
       System.out.printf("\n\tMorbid Obesity              Over 40\n");
    }
}

 class Vincent_A2.java
{
    private static Scanner input;
	public static void main(String[] args) throws IOException

	{
	   // Declare Scanner object that linked to data file call "patient.txt"
	    input = new Scanner (new File("patient.txt"));
		
		// Declare variables
		String firstName, lastName;
		String emonth;
		int currentYear;
		int day, year;
		Month month;
		
		//for calculating bmi
		double weight;
		double height;
		
		// Read a user from the textfile
		firstName = input.nextLine();
		lastName = input.nextLine();
		
		day = input.nextInt();
        month = Month.valueOf(input.next());
        year = input.nextInt();
	
		weight = input.nextDouble();
		height = input.nextDouble();
		
		currentYear = input.nextInt();
		input.nextLine();
		
		// Construct a HealthProfile object to store first user info
		Date dob = new Date(day, month, year);
		HealthProfile hp = new HealthProfile (firstName, lastName, dob, weight, height, currentYear);
		// Compute and display info
		hp.displayInfo();
		
		
		// Read a user from the textfile
		firstName = input.nextLine();
		lastName = input.nextLine();
		
		day = input.nextInt();
        month = Month.valueOf(input.next());
        year = input.nextInt();
	
		weight = input.nextDouble();
		height = input.nextDouble();
		
		currentYear = input.nextInt();
		
		
		// Construct a HealthProfile object to store second user info
        Date dob1 = new Date(day, month, year);
		HealthProfile hp2 = new HealthProfile (firstName, lastName, dob1, weight, height, currentYear);
		// Compute and display info
		hp2.displayInfo();

	}
}
