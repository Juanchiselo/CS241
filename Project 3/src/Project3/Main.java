/**
 * Name: Jose J. Sandoval
 * Class: CS241 - Data Structures and Algorithms II
 * Created On: March 9, 2017
 * Description: Main.
 */

package Project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main extends Application {

    // FXML Controller.
    public static Controller controller = null;

    // Creates a scanner object to read user input.
    private static Scanner scanner = new Scanner(System.in);

    // Variable for user input.
    private static String command = "";

    /**
     * Overriden Application.start method.
     * Starts the JavaFX application by loading the FXML file
     * and setting up a scene and a stage.
     * @param primaryStage - The primary stage of the JavaFX application.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Loads the FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Layout.fxml"));

        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.setTitle("Project 3 - Jose Juan Sandoval");
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) throws InterruptedException, IOException
    {
        do
        {
//            // Asks user to choose which version of the program to launch.
//            System.out.print(
//                      "======================================================================\n"
//                    + "        Project 3 - Graph Data Structure - Jose Juan Sandoval\n"
//                    + "======================================================================\n"
//                    + "Select a version to launch:\n"
//                    + "     CON  - Console\n"
//                    + "     JFX  - JavaFX\n"
//                    + "     EXIT - Exit\n"
//                    + "Enter choice: ");
//            command = scanner.nextLine().toUpperCase();
            command = "CON";

            // Executes the chosen option.
            switch (command)
            {
                case "CON":
                    consoleVersion();
                    break;
                case "JFX":
                    launch(args);
                    break;
                case "EXIT":
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("ERROR: " + command + " is not a valid option.");
                    //Thread.sleep(2000);
                    //Runtime.getRuntime().exec("clear");
            }
            System.out.println("\n");
        }while(!command.equals("EXIT"));
    }

    public static void consoleVersion() throws FileNotFoundException {
        String userInput = "";

        String resourcesDirectory = System.getProperty("user.dir")
                + "\\src\\Project3\\Resources\\";


        // Read the city.dat file.
        String cities = readFile(resourcesDirectory + "city.dat", ",");


        // Read the road.dat file.
        String roads = readFile(resourcesDirectory + "road.dat", ",");

        System.out.println(
                  "\n\n======================================================================\n"
                + "        Project 3 - Graph Data Structure - Console Version\n"
                + "======================================================================\n");
        do
        {
            // Asks user to enter a command.
            System.out.print("Command? ");
            command = scanner.nextLine().toUpperCase();

            switch (command)
            {
                case "D":
                    System.out.print("City codes: ");
                    userInput = scanner.nextLine().toUpperCase();
                    break;
                case "E":
                    return;
                case "H":
                    System.out.println(
                              " Q - Query the city information by entering the city code.\n"
                            + " D - Find the minimum distance between two cities.\n"
                            + " I - Insert a road by entering two city codes and distance.\n"
                            + " R - Remove an existing road by entering two city codes.\n"
                            + " H - Display this message.\n"
                            + " E - Exit.\n");
                    break;
                case "I":
                    System.out.print("City codes and distance: ");
                    userInput = scanner.nextLine().toUpperCase();
                    break;
                case "Q":
                    System.out.print("City code: ");
                    userInput = scanner.nextLine().toUpperCase();
                    break;
                case "R":
                    System.out.print("City codes: ");
                    userInput = scanner.nextLine().toUpperCase();
                    break;
                default:
                    System.out.println("ERROR: " + command + " is not a valid option.");
            }
        }while(!command.equals("E"));
    }

    public static String readFile(String fileName, String delimiter)
    {
        // This will reference one line at a time
        String line;

        String data = "";

        try
        {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
            {
                data = data + line + delimiter + " ";
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        return data;
    }

    public static ArrayList<String> parseStringToStrings(String string, String delimiter)
    {
        return new ArrayList<String>(Arrays.asList(string.split(delimiter)));
    }

    public static ArrayList<Integer> parseStringToInteger(String string, String delimiter)
    {
        ArrayList<String> strings = parseStringToStrings(string, delimiter);
        ArrayList<Integer> integers = new ArrayList<Integer>(strings.size());

        for (String str : strings)
            integers.add(Integer.valueOf(str));

        return integers;
    }
}


