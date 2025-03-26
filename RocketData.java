import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class RocketData {
	String name="";
	int num=0;
	Scanner scanner = new Scanner(System.in);
	String choice="";
	double data=0;
	HashMap<String, Double> FlightData = new HashMap<>();
	
	//Constructor for a rocket test flight where the argument is the name of rocket
	//and the test flight number
	public RocketData(String rocket, int flight_num) {
		name= rocket;
		num=flight_num;
		FlightData.put(name, (double) num);
	}
	
	//ADDITION: If user wants to add data, will give the user a choice of kind of data to be added
	public void add_data() {
		choice="";
		while(choice.equalsIgnoreCase("Menu")!=true) {
			data=Double.NEGATIVE_INFINITY;
			System.out.println("Please select from the following:");
			System.out.println("Type '1' to enter initial velocity (in MPH).");
			System.out.println("Type '2' to enter maximum height if rocket did not exit Earth's atmosphere (in FEET).");
			System.out.println("Type '3' to enter amount of fuel (in LBS).");
			System.out.println("Type '4' to enter outside temperature (in Fahrenheit).");
			System.out.println("Type '5' to enter degrees longitude of starting point.");
			System.out.println("Type '6' to enter degrees latitude of starting point.");
			System.out.println("Or type 'Menu' to return to the main menu.");
			choice=scanner.next();
			
			if (choice.equalsIgnoreCase("1")==true){
				if(FlightData.containsKey("Initial Velocity")==true) {
					System.out.println("\n\nData for initial velocity already exists.");
					System.out.println("Please modify existing data instead.\n\n");
				}
				//Making sure the user enters a valid input (not a string and greater than 0).
				else {
					while(data<=0) {
						try {
							System.out.println("Please enter initial velocity (greater than 0) in MPH:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
					}
					FlightData.put("Initial Velocity", data);
					System.out.println("Initial velocity of " + data + " MPH has been added.\n\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("2")==true){
				if(FlightData.containsKey("Maximum Height")==true) {
					System.out.println("\n\nData for maximum height already exists.");
					System.out.println("Please modify existing data instead.\n\n");
				}
				else {
					while(data<=0) {
						try {
							System.out.println("Please enter the maximum height(greater than 0) in FEET:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
					}
					FlightData.put("Maximum Height", data);
					System.out.println("Maximum height of " + data + " feet has been added.\n\n");
				}
				
			}
			
			else if (choice.equalsIgnoreCase("3")==true){
				if(FlightData.containsKey("Fuel")==true) {
					System.out.println("\n\nData for fuel already exists.");
					System.out.println("Please modify existing data instead.\n\n");
				}
				else {
					while(data<=0) {
						try {
							System.out.println("Please enter the amount of starting fuel(greater than 0) in LBS:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
					}
					FlightData.put("Fuel", data);
					System.out.println("Initial fuel of " + data + " LBS has been added.\n\n");
				}
				
			}
			
			else if (choice.equalsIgnoreCase("4")==true){
				if(FlightData.containsKey("Temp")==true) {
					System.out.println("\n\nData for temperature already exists.");
					System.out.println("Please modify existing data instead.\n\n");
				}
				else {
					while(data<=-100 || data>=150) {
						try {
							System.out.println("Please enter the outside temperature in degrees F:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
						if(data<=-100) {
							System.out.println("\n\n Too cold for launch!\n\n");
						}
						else if(data>=150) {
							System.out.println("\n\n Too hot for launch!\n\n");
						}
					}
					FlightData.put("Temp", data);
					System.out.println("Outside temperature of " + data + " F has been added.\n\n");
				}
			}
			
			
			else if (choice.equalsIgnoreCase("5")==true){
				if(FlightData.containsKey("Long")==true) {
					System.out.println("\n\nData for longitude already exists.");
					System.out.println("Please modify existing data instead.\n\n");
				}
				else {
					while(data>=180 || data<=-180) {
						try {
							System.out.println("Please enter the degrees longitude of initial point (between -180 and 180):");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
						
						if(data>180) {
							System.out.println("\n\nLongitude cannot exceed 180 degrees.\n\n");
						}
						if(data<-180) {
							System.out.println("\n\nLongitude cannot be below -180 degrees.\n\n");
						}
					}
					FlightData.put("Long", data);
					System.out.println("Longitude of " + data + " degrees has been added.\n\n");
				}
				
			}
			
			else if (choice.equalsIgnoreCase("6")==true){
				if(FlightData.containsKey("Latitude")==true) {
					System.out.println("\n\nData for latitude already exists.");
					System.out.println("Please modify existing data instead.\n\n");
				}
				else {
					while(data>90 || data<-90) {
						try {
							System.out.println("Please enter the degrees latitude of initial point (between -90 and 90):");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
						
						if(data>90) {
							System.out.println("\n\nLatitude cannot exceed 90 degrees.\n\n");
						}
						if(data<-90) {
							System.out.println("\n\nLatitude cannot be below -90 degrees.\n\n");
						}
					}
					FlightData.put("Latitude", data);
					System.out.println("Latitude of " + data + " degrees has been added.\n\n");
				}
				
			}
			
			else if(choice.equalsIgnoreCase("Menu")==true) {
				System.out.println("\n\nReturning to menu.\n");
			}
			else {
				System.out.println("\n\nInvalid choice. Please try again.\n\n");
			}
		}
	}
	
	
	//REMOVAL: If user wants to delete data, will give the user a choice of kind of data to be deleted
	public void delete_data() {
		choice="";
		while(choice.equalsIgnoreCase("Menu")!=true) {
			System.out.println("Please select from the following:");
			System.out.println("Type '1' to delete initial velocity (in MPH).");
			System.out.println("Type '2' to delete maximum height (in FEET).");
			System.out.println("Type '3' to delete amount of fuel (in LBS).");
			System.out.println("Type '4' to delete outside temperature (in Fahrenheit).");
			System.out.println("Type '5' to delete degrees longitude of starting point.");
			System.out.println("Type '6' to delete degrees latitude of starting point.");
			System.out.println("Or type 'Menu' to return to the main menu.");
			choice=scanner.next();
				
			if (choice.equalsIgnoreCase("1")==true){
				if(FlightData.containsKey("Initial Velocity")==true) {
					FlightData.remove("Initial Velocity");
					System.out.println("\n\nInitial velocity has been deleted.\n\n");
				}
				else {
					System.out.println("\n\nNo initial velocity recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
					}
					
				}
			
			else if (choice.equalsIgnoreCase("2")==true){
				if(FlightData.containsKey("Maximum Height")==true) {
					FlightData.remove("Maximum Height");
					System.out.println("\n\nMaximum Height has been deleted.\n\n");
				}
				else {
					System.out.println("\n\nNo maximum height recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
					}
				}
			
			else if (choice.equalsIgnoreCase("3")==true){
				if(FlightData.containsKey("Fuel")==true) {
					FlightData.remove("Fuel");
					System.out.println("\n\nInitial fuel has been deleted.\n\n");
				}
				else {
					System.out.println("\n\nNo initial fuel recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
					}
				}
			
			else if (choice.equalsIgnoreCase("4")==true){
				if(FlightData.containsKey("Temp")==true) {
					FlightData.remove("Temp");
					System.out.println("\n\nTemperature has been deleted.\n\n");
				}
				else {
					System.out.println("\n\nNo temperature recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
					}
				}
			
			else if (choice.equalsIgnoreCase("4")==true){
				if(FlightData.containsKey("Temp")==true) {
					FlightData.remove("Temp");
					System.out.println("\n\nTemperature has been deleted.\n\n");
				}
				else {
					System.out.println("\n\nNo temperature recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
					}
				}
			
			else if (choice.equalsIgnoreCase("5")==true){
				if(FlightData.containsKey("Long")==true) {
					FlightData.remove("Long");
					System.out.println("\n\nLongitude has been deleted.\n\n");
				}
				else {
					System.out.println("\n\nNo longitude recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
					}
				}
			
			else if (choice.equalsIgnoreCase("6")==true){
				if(FlightData.containsKey("Latitude")==true) {
					FlightData.remove("Latitude");
					System.out.println("\n\nLatitude has been deleted.\n\n");
				}
				else {
					System.out.println("\n\nNo latitude recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
					}
				}
			
			else if(choice.equalsIgnoreCase("Menu")==true) {
				System.out.println("\n\nReturning to menu.\n");
			}
			else {
				System.out.println("\n\nInvalid choice. Please try again.\n\n");
				}
			}
		}
	
	
	//MODIFICATION
	public void modify_data() {
		choice="";
		while(choice.equalsIgnoreCase("Menu")!=true) {
			data=Double.NEGATIVE_INFINITY;
			System.out.println("Please select from the following:");
			System.out.println("Type '1' to modify initial velocity (in MPH).");
			System.out.println("Type '2' to modify maximum height (in FEET).");
			System.out.println("Type '3' to modify test flight number.");
			System.out.println("Type '4' to modify amount of fuel (in LBS).");
			System.out.println("Type '5' to modify outside temperature (in Fahrenheit).");
			System.out.println("Type '6' to modify degrees longitude of starting point.");
			System.out.println("Type '7' to modify degrees latitude of starting point.");
			System.out.println("Or type 'Menu' to return to the main menu.");
			choice=scanner.next();
			
			if (choice.equalsIgnoreCase("1")==true){
				if(FlightData.containsKey("Initial Velocity")==true) {
					System.out.println("\n\nReplacing previous initial velocity.");
					while(data<=0) {
						try {
							System.out.println("Please enter the initial velocity (greater than 0) in MPH:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
					}
					FlightData.replace("Initial Velocity", data);
					System.out.println("\n\nInitial velocity now set to " + data + " MPH.\n\n");
				}
				else {
					System.out.println("\n\nNo initial velocity recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
				
			}
			
			else if (choice.equalsIgnoreCase("2")==true){
				if(FlightData.containsKey("Maximum Height")==true) {
					System.out.println("\n\nReplacing previous maximum height.");
					while(data<=0) {
						try {
							System.out.println("Please enter the maximum height (greater than 0) in FEET:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
					}
					FlightData.replace("Maximum Height", data);
					System.out.println("Maximum height now set to " + data + " feet.\n\n");
				}
				else {
					System.out.println("\n\nNo maximum height recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("3")==true){
				System.out.println("\n\nReplacing previous test flight number.");
				while(data<=0) {
					try {
						System.out.println("Please enter the test flight number (greater than 0):");
						data=scanner.nextInt();
					} catch(InputMismatchException e) {
						System.out.println("\nInvalid input.");
						scanner.nextLine();
					}
				}
				FlightData.replace(name, (double)data);
				System.out.println("Test flight number now set to " + (int)data +".\n\n");
			}
			
			else if (choice.equalsIgnoreCase("4")==true){
				if(FlightData.containsKey("Fuel")==true) {
					System.out.println("\n\nReplacing previous fuel entry.");
					while(data<=0) {
						try {
							System.out.println("Please enter the fuel (greater than 0) in LBS:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
					}
					FlightData.replace("Fuel", data);
					System.out.println("Initial fuel now set to " + data + " LBS.\n\n");
				}
				else {
					System.out.println("\n\nNo fuel recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("5")==true){
				if(FlightData.containsKey("Temp")==true) {
					System.out.println("\n\nReplacing previous temperature entry.");
					while(data<=-100 || data>=150) {
						try {
							System.out.println("Please enter the outside temperature in degrees F:");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
						if(data<=-100) {
							System.out.println("\n\n Too cold for launch!\n\n");
						}
						else if(data>=150) {
							System.out.println("\n\n Too hot for launch!\n\n");
						}
					}
					FlightData.replace("Temp", data);
					System.out.println("Outside temperature now set to " + data + " degrees F.\n\n");
				}
				else {
					System.out.println("\n\nNo temperature recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			
			else if (choice.equalsIgnoreCase("6")==true){
				if(FlightData.containsKey("Long")==true) {
					System.out.println("\n\nReplacing previous longitude entry.");
					while(data>180 || data<-180) {
						try {
							System.out.println("Please enter the degrees longitude of initial point (between -180 and 180):");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
						
						if(data>180) {
							System.out.println("\n\nLongitude cannot exceed 180 degrees.\n\n");
						}
						if(data<-180) {
							System.out.println("\n\nLongitude cannot be below -180 degrees.\n\n");
						}
					}
					FlightData.replace("Long", data);
					System.out.println("Starting longitude now set to " + data + " degrees.\n\n");
				}
				else {
					System.out.println("\n\nNo longitude recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("7")==true){
				if(FlightData.containsKey("Latitude")==true) {
					System.out.println("\n\nReplacing previous latitude entry.");
					while(data>90 || data<-90) {
						try {
							System.out.println("Please enter the degrees latitude of initial point (between -90 and 90):");
							data=scanner.nextDouble();
						} catch(InputMismatchException e) {
							System.out.println("\nInvalid input.");
							scanner.nextLine();
						}
						
						if(data>90) {
							System.out.println("\n\nLatitude cannot exceed 90 degrees.\n\n");
						}
						if(data<-90) {
							System.out.println("\n\nLatitude cannot be below -90 degrees.\n\n");
						}
					}
					FlightData.replace("Latitude", data);
					System.out.println("Starting latitude now set to " + data + " degrees.\n\n");
				}
				else {
					System.out.println("\n\nNo latitude recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if(choice.equalsIgnoreCase("Menu")==true) {
				System.out.println("\n\nReturning to menu.\n");
			}
			else {
				System.out.println("\n\nInvalid choice. Please try again.\n\n");
				}
		}
	}
	//PRINT
	public void print_data() {
		choice="";
		while(choice.equalsIgnoreCase("Menu")!=true) {
			System.out.println("Please select from the following:");
			System.out.println("Type '1' to print initial velocity (in MPH).");
			System.out.println("Type '2' to print maximum height (in FEET).");
			System.out.println("Type '3' to print test flight number.");
			System.out.println("Type '4' to print amount of fuel (in LBS).");
			System.out.println("Type '5' to print outside temperature (in Fahrenheit).");
			System.out.println("Type '6' to print degrees longitude of starting point.");
			System.out.println("Type '7' to print degrees latitude of starting point.");
			System.out.println("Or type 'Menu' to return to the main menu.");
			choice=scanner.next();
			
			if(choice.equalsIgnoreCase("Menu")==true) {
				System.out.println("\n\nReturning to menu.\n");
			}
			
			else if (choice.equalsIgnoreCase("1")==true) {
				if(FlightData.containsKey("Initial Velocity")==true) {
					System.out.println("Initial Velocity: "+FlightData.get("Initial Velocity")+" MPH\n\n");
				}
				else {
					System.out.println("\n\nNo initial velocity recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("2")==true) {
				if(FlightData.containsKey("Maximum Height")==true) {
					System.out.println("Maximum Height: "+FlightData.get("Maximum Height")+" FEET\n\n");
				}
				else {
					System.out.println("\n\nNo maximum height recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("3")==true) {
				System.out.println(name+": "+FlightData.get(name)+"\n\n");
			}
			
			else if (choice.equalsIgnoreCase("4")==true) {
				if(FlightData.containsKey("Fuel")==true) {
					System.out.println("Fuel: "+FlightData.get("Fuel")+" LBS\n\n");
				}
				else {
					System.out.println("\n\nNo fuel recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("5")==true) {
				if(FlightData.containsKey("Temp")==true) {
					System.out.println("Temperature: "+FlightData.get("Temp")+" degrees F\n\n");
				}
				else {
					System.out.println("\n\nNo temperature recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("6")==true) {
				if(FlightData.containsKey("Long")==true) {
					System.out.println("Starting Longitude: "+FlightData.get("Long")+" degrees\n\n");
				}
				else {
					System.out.println("\n\nNo longitude recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else if (choice.equalsIgnoreCase("7")==true) {
				if(FlightData.containsKey("Latitude")==true) {
					System.out.println("Starting Latitude: "+FlightData.get("Latitude")+" degrees\n\n");
				}
				else {
					System.out.println("\n\nNo latitude recorded.\nPlease select another option or type 'Menu' to return to the main menu.\n");
				}
			}
			
			else {
				System.out.println("\n\nInvalid choice. Please try again.\n\n");
				}
		}
		
	}
	//LOOKUP/SEARCH
	public void search_data() {
		choice="";
		while(choice.equalsIgnoreCase("Menu")!=true) {
			System.out.println("Please select from the following:");
			System.out.println("Type '1' to search for initial velocity (in MPH).");
			System.out.println("Type '2' to search for maximum height (in FEET).");
			System.out.println("Type '3' to search for amount of fuel (in LBS).");
			System.out.println("Type '4' to search for outside temperature (in Fahrenheit).");
			System.out.println("Type '5' to search for degrees longitude of starting point.");
			System.out.println("Type '6' to search for degrees latitude of starting point.");
			System.out.println("Or type 'Menu' to return to the main menu.");
			choice=scanner.next();
			
			if (choice.equalsIgnoreCase("1")==true){
				if(FlightData.containsKey("Initial Velocity")==true) {
					System.out.println("\n\nEntry for Initial velocity exists.\n\n");
					System.out.println("Initial Velocity: "+FlightData.get("Initial Velocity")+" MPH\n\n");
				}
				else {
					System.out.println("\n\nNo initial velocity recorded.\n\n");
					}
					
				}
			
			else if (choice.equalsIgnoreCase("2")==true){
				if(FlightData.containsKey("Maximum Height")==true) {
					System.out.println("\n\nEntry for Maximum Height exists.\n\n");
					System.out.println("Maximum Height: "+FlightData.get("Maximum Height")+" FEET\n\n");
				}
				else {
					System.out.println("\n\nNo maximum height recorded.\n\n");
					}	
				}
			
			else if (choice.equalsIgnoreCase("3")==true){
				if(FlightData.containsKey("Fuel")==true) {
					System.out.println("\n\nEntry for Maximum Height exists.\n\n");
					System.out.println("Fuel: "+FlightData.get("Fuel")+" LBS\n\n");
				}
				else {
					System.out.println("\n\nNo fuel recorded.\n\n");
					}	
				}
			
			else if (choice.equalsIgnoreCase("4")==true){
				if(FlightData.containsKey("Temp")==true) {
					System.out.println("\n\nEntry for temperature exists.\n\n");
					System.out.println("Temperature: "+FlightData.get("Temp")+" degrees F\n\n");
				}
				else {
					System.out.println("\n\nNo temperature recorded.\n\n");
					}	
				}
			
			else if (choice.equalsIgnoreCase("5")==true){
				if(FlightData.containsKey("Long")==true) {
					System.out.println("\n\nEntry for longitude exists.\n\n");
					System.out.println("Longitude: "+FlightData.get("Long")+" degrees\n\n");
				}
				else {
					System.out.println("\n\nNo longitude recorded.\n\n");
					}	
				}
			
			else if (choice.equalsIgnoreCase("6")==true){
				if(FlightData.containsKey("Latitude")==true) {
					System.out.println("\n\nEntry for ;latitude exists.\n\n");
					System.out.println("Latitude: "+FlightData.get("Latitude")+" degrees\n\n");
				}
				else {
					System.out.println("\n\nNo latitude recorded.\n\n");
					}	
				}
				
			else if(choice.equalsIgnoreCase("Menu")==true) {
				System.out.println("\n\nReturning to menu.\n");
			}
			else {
				System.out.println("\n\nInvalid choice. Please try again.\n\n");
				}
		}
		
	}
	
	//SORT
	public void sort_data() {
		choice="";
		HashSet<Double> hset = new HashSet<Double>();
		List<Double> list = new ArrayList<>(FlightData.values());
		while(choice.equalsIgnoreCase("Menu")!=true) {
			data=0;
			System.out.println("Please select from the following:");
			System.out.println("Type '1' to sort data from smallest to largest.");
			System.out.println("Type '2' to sort data from largest to smallest.");
			System.out.println("Or type 'Menu' to return to the main menu.");
			choice=scanner.next();
			if (choice.equalsIgnoreCase("1")==true){
				Collections.sort(list);
				for(double num : list) {
					for(String key : FlightData.keySet()) {
						if(FlightData.get(key)==num && hset.contains(num)==false) {
							System.out.println("\n"+key+": "+num+"\n");
							hset.add(num);
						}
					}
				}
				break;
			}
			
			else if (choice.equalsIgnoreCase("2")==true){
				Collections.sort(list);
				Collections.reverse(list);
				for(double num : list) {
					for(String key : FlightData.keySet()) {
						if(FlightData.get(key)==num && hset.contains(num)==false) {
							System.out.println("\n"+key+": "+num+"\n");
							hset.add(num);
						}
					}
				}
				break;
			}
			
			else if(choice.equalsIgnoreCase("Menu")==true) {
				System.out.println("\n\nReturning to menu.\n");
			}
			
			else {
				System.out.println("\nInvalid choice. Please try again.\n\n");
			}
		
		}
	}
	//END OF PROGRAM
	}
