import java.util.*;

public class SafeInput {

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString;  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an integer response
     */

    public static int getInt(Scanner pipe, String prompt){
        //method variables
        String trash;
        int retInt = 0;
        boolean loop = true;

        do{
            System.out.print("\n" + prompt + ": "); //show the prompt to user
            if(pipe.hasNextInt()){
                retInt = pipe.nextInt();
                pipe.nextLine(); //clears the buffer
                loop = false;
            } else{
                trash = pipe.nextLine(); //stores the incorrect input
                System.out.println("You entered '" + trash + "'. Enter a valid integer please."); //Outputs value is invalid
            }
        } while(loop);

        return retInt;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double response
     */

    public static double getDouble(Scanner pipe, String prompt){
        //method variables
        String trash;
        double retDouble = 0;
        boolean loop = true;

        do{
            System.out.print("\n" + prompt + ": "); //show the prompt to user
            if(pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                pipe.nextLine(); //clears the buffer
                loop = false;
            } else{
                trash = pipe.nextLine(); //stores the incorrect input
                System.out.println("You entered '" + trash + "'. Enter a valid number please."); //Outputs value is invalid
            }
        } while(loop);

        return retDouble;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param lo is the lowest integer in the range
     * @param hi is the highest integer in the range
     * @return an integer response that ranges from lo to hi
     */

    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi){
        //method variables
        String trash;
        int retInt = 0;
        boolean loop = true;

        do{
            System.out.print("\n" + prompt + "[" + lo + " - " + hi + "]: "); //show the prompt to user
            if(pipe.hasNextInt()){
                retInt = pipe.nextInt();
                pipe.nextLine(); //clears the buffer
                if(retInt >= lo && retInt <= hi) {
                    loop = false;
                } else {
                    System.out.println("You entered '" + retInt + "' You must enter a value in range [" + lo + " - " + hi + "]"); //promts user to try again
                }
            } else{
                trash = pipe.nextLine(); //stores the incorrect input
                System.out.println("You entered '" + trash + "'. Enter a valid integer please."); //Outputs value is invalid
            }
        } while(loop);

        return retInt;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param lo is the lowest integer in the range
     * @param hi is the highest integer in the range
     * @return an integer response that ranges from lo to hi
     */

    public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi){
        //method variables
        String trash;
        double retDouble = 0;
        boolean loop = true;

        do{
            System.out.print("\n" + prompt + "[" + lo + " - " + hi + "]: "); //show the prompt to user
            if(pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                pipe.nextLine(); //clears the buffer
                if(retDouble >= lo && retDouble <= hi) { //checks whether the double is within the range
                    loop = false;
                } else {
                    System.out.println("You entered '" + retDouble + "'. You must enter a value in range [" + lo + " - " + hi + "]"); //prompts user to try again
                }
            } else{
                trash = pipe.nextLine(); //stores the incorrect input
                System.out.println("You entered '" + trash + "'. Enter a valid number please."); //Outputs value is invalid
            }
        } while(loop);

        return retDouble;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an integer response that ranges from lo to hi
     */

    public static boolean getYNConfirm(Scanner pipe, String prompt){
        //method variables
        String input;
        boolean retBoolean = false;
        boolean loop = true;

        do{
            System.out.print("\n" + prompt + ": "); //show the prompt to user
            input = pipe.nextLine();
            if(input.equalsIgnoreCase("Y")){ //checks whether input is Y, N, or neither
                retBoolean = true;
                loop = false;
            } else if(input.equalsIgnoreCase("N")){
                retBoolean = false;
                loop = false;
            } else{
                System.out.println("You entered '" + input + "'. Enter Yes or No [Y/N]"); //Tells user input is invalid
                loop = true;
            }
        } while(loop);

        return retBoolean;
    }

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an integer response that ranges from lo to hi
     */

    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        //method variables
        String retString;
        boolean loop = true;

        do{
            System.out.print("\n" + prompt + ": "); //show the prompt to user
            retString = pipe.nextLine();
            if(retString.matches(regEx)) {
                loop = false;
            } else {
                System.out.println("You entered '" + retString + "'. Enter a valid input"); //Tells user input is invalid
                loop = true;
            }
        } while(loop);

        return retString;
    }

    /**
     *
     * @param msg is the message that is at the center of the header
     * @return a pretty header
     */
    public static void prettyHeader(String msg){
        //This creates two Len variables, which are used to form the lower and upper boundary of the message about the center
        //If message is not a even number of characters, the upper boundary is longer in length by one
        int len;
        int len1;
        if(msg.length() %2 == 0) {
            len = (msg.length()) / 2;
            len1 = (msg.length()) / 2;
        } else{
            len = (msg.length()) / 2;
            len1 = ((msg.length()) / 2) + 1;
        }

        int lowerBoundary = 30-len;
        int upperBoundary = 30+len1;

        //for loop prints * 60 times
        for(int i = 0; i < 60; i++){
            System.out.printf("%1s", "*");
        }
        System.out.println(""); //next line

        //for loop to center of banner
        for(int i = 1; i <= 60; i++){

            if (i <= 3){ //creates 3 *'s
                System.out.print("*");

            } else if(i < lowerBoundary){ //Prints spaces until lower boundary is reached
                System.out.print(" ");

            } else if(i >= lowerBoundary && i < upperBoundary){ //prints message between lower and upper boudnary
                System.out.print(msg.charAt(i-lowerBoundary));

            } else if (i >= upperBoundary && i < 58) { // prints spaces until 3 *'s
                System.out.print(" ");

            } else if (i >= 58) { //prints 3 *'s
                System.out.print("*");
            }

        }
        System.out.println(""); // next line

        //Prints 60 *'s
        for(int i = 0; i < 60; i++){
            System.out.printf("%1s", "*");
        }


    }
}