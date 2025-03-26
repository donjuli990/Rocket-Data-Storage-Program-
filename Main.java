import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String response="";
		RocketData TestFlight;

		
		while(true) {
			//Asking the user for the name of the rocket
			System.out.print("Welcome! Please enter the rocket model followed by 'Enter': ");
			String rocket_name = scanner.nextLine();
			
			//Name of the rocket will be displayed in all upper case
			rocket_name=rocket_name.toUpperCase();
			
			//Asking the user for the the test flight number. Will not continue unless user enters an integer greater than 0. 
			//Otherwise, it will throw an exception
			int test_flight_number = 0;
			while(test_flight_number<=0){
				try {
					System.out.print("\nPlease enter a test flight number (an integer greater than 0) followed by 'Enter': ");
					test_flight_number = scanner.nextInt();
				} catch(InputMismatchException e) {
					System.out.println("\n\nInvalid input. Please enter an integer greater than 0.\n\n");
					scanner.nextLine();
				}
			}
			//Creating a new HashMap with the rocket name and test number provided by user
			TestFlight = new RocketData(rocket_name, test_flight_number);
			
			System.out.println("\n\n\nNow entering data for " + rocket_name + " - Test Flight Number "+test_flight_number);
			System.out.println();
			break;
		}
		
		//The user has a menu to select what action they want to do.
		while(response.equalsIgnoreCase("Exit")!=true) {
			
			System.out.println("What would you like to do? Please select one of the following:\n");
			System.out.println("Type '1' followed by 'Enter' to add data");
			System.out.println("Type '2' followed by 'Enter' to remove data");
			System.out.println("Type '3' followed by 'Enter' to modify data");
			System.out.println("Type '4' followed by 'Enter' to print existing data");
			System.out.println("Type '5' followed by 'Enter' to search for existing data");
			System.out.println("Type '6' followed by 'Enter' to sort existing data");
			System.out.println("Or type 'Exit' to exit the program.\n");
			response=scanner.next();
			
			if(response.equalsIgnoreCase("1")==true) {
				TestFlight.add_data();
			}
			
			else if(response.equalsIgnoreCase("2")==true){
				TestFlight.delete_data();
			}
			
			else if(response.equalsIgnoreCase("3")==true) {
				TestFlight.modify_data();
			}
			
			else if(response.equalsIgnoreCase("4")==true) {
				TestFlight.print_data();
			}
			
			else if(response.equalsIgnoreCase("5")==true) {
				TestFlight.search_data();
			}
			
			else if(response.equalsIgnoreCase("6")==true) {
				TestFlight.sort_data();
			}
			
			else if(response.equalsIgnoreCase("Exit")==true) {
				System.out.println("Exiting program.");
			}
			else {
				System.out.println("\n\nInvalid choice. Please try again.\n\n");
			}
		}
		scanner.close();
	}

}
