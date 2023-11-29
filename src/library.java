// Java Program to Illustrate Application CLass
// To Create The Menu For the Program

// Importing required classes
import java.util.Scanner;

// Class
public class library {
    private static Account[] accounts; // Store user accounts
    private static Account currentAccount; // Currently logged-in account
    private static boolean isLoggedIn;
	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of Scanner class
		// to take input from user
		Scanner input = new Scanner(System.in);
        accounts = new Account[100]; // Initialize an array to store user accounts
        initializeAccounts();

        isLoggedIn = false;
        currentAccount = null;

		// Displaying menu
		System.out.println(
			"********************Welcome to the GFG Library!********************");
		System.out.println(
			"				 Select From The Following Options:			 ");
		System.out.println(
			"**********************************************************************");

		// Creating object of book class
		books ob = new books();
		// Creating object of students class
		students obStudent = new students();

		int choice=-1;
		int searchChoice;

		// Creating menu
		// using do-while loop
		do {
       
                // Check if a user is logged in, if not, prompt for login
                if (!isLoggedIn) {
                    currentAccount = login(input);
                    if (currentAccount != null) {
                        isLoggedIn = true;
                        System.out.println("Login successful. Welcome, " + currentAccount.getUsername() + "!");
                    } else {
                        System.out.println("Login failed. Please try again.");
                        continue; // Restart the loop
                    }
                }

			ob.dispMenu();
			choice = input.nextInt();

			// Switch case
			switch (choice) {

				// Case
			case 1:
				book b = new book();
				ob.addBook(b);
				break;

				// Case
			case 2:
				ob.upgradeBookQty();
				break;

			// Case
			case 3:

				System.out.println(
					" press 1 to Search with Book Serial No.");
				System.out.println(
					" Press 2 to Search with Book's Author Name.");
				searchChoice = input.nextInt();

				// Nested switch
				switch (searchChoice) {

					// Case
				case 1:
					ob.searchBySno();
					break;

					// Case
				case 2:
					ob.searchByAuthorName();
				}
				break;

				// Case
			case 4:
				ob.showAllBooks();
				break;

				// Case
			case 5:
				Student s = new Student();
				obStudent.addStudent(s);
				break;

				// Case
			case 6:
				obStudent.showAllStudents();
				break;

				// Case
			case 7:
				obStudent.checkOutBook(ob);
				break;

				// Case
			case 8:
				obStudent.checkInBook(ob);
				break;

            case 0:
                isLoggedIn = false; // Log out the user
                System.out.println("Logged out successfully.");
                break;

				// Default case that will execute for sure
				// if above cases does not match
			default:

				// Print statement
				System.out.println("ENTER BETWEEN 0 TO 8.");
			}

		}while (choice != 0);

		// Checking condition at last where we are
		// checking case entered value is not zero
		

        
	}
        // Add more user accounts here
        private static void initializeAccounts() {
            accounts[0] = new Account("user1", "password1");
            accounts[1] = new Account("user2", "password2");
            // Add more accounts as needed
        }


    // Logic for user login
    private static Account login(Scanner input) {
        System.out.print("Enter Username: ");
        String username = input.next();
        System.out.print("Enter Password: ");
        String password = input.next();

        for (Account account : accounts) {
            if (account != null && account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account; // Return the matched account
            }
        }
        return null; // No matching account found
    }
    
}
