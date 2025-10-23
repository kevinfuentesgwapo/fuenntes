import java.util.Scanner;
public class Fuentes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //2d array to store usernames and passwords
        String[][] accounts = new String[2][2];
        int accountCount = 0;

        while (true) {
        //the options for the user
        System.out.println("=================== LOGIN SYSTEM ==================");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        String option = sc.nextLine();

      switch (option) {
       
        case "2": 
        // creating the register system
        System.out.println("Register option selected");
        
    // if the account is full this will print
        boolean registered = false;
        
        if (accountCount >= accounts.length) {
            System.out.println("Account limit reached, cannot register new account.");
            registered = true;
            break;
        }
        System.out.print("Enter New username:");
        String userName2 = sc.nextLine();

        // check if the username already exits
        for (int i = 0; i < accountCount; i++){
            if (accounts[i][0].equals(userName2)) {
                System.out.println("Username already exists, please create a different one,");
               registered = true;
                break;
            }
        }
    
        /*if the username does not exist this will store the new username and passoword
         * and if the username already exists, this will NOT continue the registration process
         * and will return to the main menu
         */       
        if (registered) { 
            break;
        }
        
         System.out.print("Enter New password: ");
        String password2 = sc.nextLine();
        
        System.out.println("Confirm your password: ");
        String confirmPassword = sc.nextLine();

        
        //repeat the confirmatin passoword until it matches the new password2
        while (!password2.equals(confirmPassword)){ 
                System.out.println("Passwords do not match, please try again.");
                System.out.println("Enter your password: ");
                password2 = sc.nextLine();
                System.out.println("Confirm your password:");
                confirmPassword = sc.nextLine();          
        } 
        System.out.println("Registration successful!");

        // store the new username and passoword in the accounts array
        accounts[accountCount][0] = userName2;
        accounts[accountCount][1] = password2;
        accountCount++;
        break;
        
         case "1":
    // creating the login system
        System.out.println("Login option seleted");
        System.out.println("Enter your username: ");
        String userName1 = sc.nextLine();
        System.out.println("Enter your password: ");
        String password1 = sc.nextLine();

// chech if the username and password are correct
        boolean loggedIn = false;
        //loop for the accounts array to match the given username and password
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i][0].equals(userName1) && accounts[i][1].equals(password1)) {
            System.out.println("Hello " + userName1+ "!");
            loggedIn = true;
            break;
            }           
        }
         //if the usrname and passoword are incorrect or not found this will print
        if (!loggedIn) {
            System.out.println("Invalid username or password!");
        }
break;
        case "3":
        //exit the program 
        System.out.println("Goodbye!");
        sc.close();
}
        }

    }
}