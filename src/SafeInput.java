import java.util.Scanner;


public class SafeInput {

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        int retVal = low - 1;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + "[" + low + "]" + "[" + high + "]: ");
            if (pipe.hasNextInt())
                retVal = pipe.nextInt();
            pipe.nextLine();
            if (retVal >= low && retVal <= high) {
                // System.out.println("You said your favorite number is: " + retVal);
                done = true;
            } else {
                System.out.println("You said your number is " + retVal + " but that is not in range.");
            }

        } while (!done);

        return retVal;
    }


    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
                retVal = pipe.nextInt();
            pipe.nextLine();
            if (retVal >= 0.1) {
                // System.out.println("You said your favorite number is: " + retVal);
                done = true;
            } else {
                System.out.println("That is not a number.");
            }

        } while (!done);

        return retVal;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {

        double retVal = low - 1;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + "[" + low + "]" + "[" + high + "]: ");
            if (pipe.hasNextDouble())
                retVal = pipe.nextDouble();
            pipe.nextLine();
            if (retVal >= low && retVal <= high) {
                // System.out.println("You said your favorite number is: " + retVal);
                done = true;
            } else {
                System.out.println("You entered " + trash + " but that is not a number.");
            }

        } while (!done);

        return retVal;

    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble())
                retVal = pipe.nextDouble();
            pipe.nextLine();
            if (retVal >= 0.1) {
                // System.out.println("You said your favorite number is: " + retVal);
                done = true;
            } else {
                System.out.println("Please enter a double.");
            }

        } while (!done);

        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String pattern) {

        String retVal = "";
        retVal = pipe.nextLine();
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(pattern)) {
                done = true;
            } else {
                System.out.println("That does not match the pattern" + pattern);
            }

        } while (!done);

        return retVal;

    }

    public static boolean getYN(Scanner pipe, String prompt) {

        String respYN = "";
        boolean retVal = false;
        boolean done = false;

        do {
            System.out.print(prompt + "[Y/N]: ");
            respYN = pipe.nextLine();

            if (respYN.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (respYN.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter [Y/N]");
            }
        } while (!done);
        return retVal;
    }

    public static String getNonZerolength(Scanner pipe, String prompt) {
        String retVal = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.length() > 0) {
                done = true;
            } else {
                System.out.println("You have to enter at least one character: ");
            }
        } while (!done);

        return retVal;
    }



    public static double CtoF(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do{
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble())
                retVal = (pipe.nextDouble()*1.8)+32;
            pipe.nextLine();
            if (retVal >= 0.1) {
                // System.out.println("You said your favorite number is: " + retVal);
                done = true;
            } else {
                System.out.println("You said your favorite number is " + trash + " but that is not in range.");
            }
        }while(!done);

        return retVal;

    }
}