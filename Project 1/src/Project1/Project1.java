/**
 * Name: Jose J. Sandoval
 * Class: CS241 - Data Structures and Algorithms II
 * Created On: January 30, 2017
 * Description: Test program for a Binary Search Tree.
 */

package Project1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 extends Application
{
    // FXML Controller.
    public static Controller controller;

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
        primaryStage.setTitle("Project 1 - Jose Juan Sandoval");
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        // JavaFX application launcher method.
        //launch(args);

        // Instantiate a binary search tree of strings.
        BinarySearchTree<Integer> integerBST = new BinarySearchTree<Integer>();

        // Insert elements into the tree.
        Scanner scanner = new Scanner(System.in);

        String command;
        int element;

        String delimiter = " ";

        System.out.println("Please enter the initial sequence of values:");
        String input = scanner.nextLine();

        ArrayList<Integer> integers = parseStringToInteger(input, delimiter);

        for (int integer : integers)
            integerBST.insert(integer);

        // Traverse the tree PreOrder.
        System.out.println("\nTraversing the tree Pre-Order:");
        integerBST.traversePreOrder();

        // Traverse the tree InOrder.
        System.out.println("\nTraversing the tree In-Order:");
        integerBST.traverseInOrder();

        // Traverse the tree PostOrder.
        System.out.println("\nTraversing the tree Post-Order:");
        integerBST.traversePostOrder();

        do
        {
            // Asks user to enter a command.
            System.out.println("\n\nCommand? (Enter H for help.)");
            command = scanner.nextLine().toUpperCase();

            switch (command)
            {
                case "I":
                    System.out.print("Enter the value to be inserted: ");
                    element = scanner.nextInt();

                    if(!integerBST.search(element))
                    {
                        integerBST.insert(element);
                        System.out.println("The new tree:");
                        integerBST.traverseInOrder();
                    }
                    else
                        System.out.println("ERROR: Element already exists in tree.");
                    break;
                case "D":
                    // Remove an element.
                    System.out.println("Enter the value to be deleted: ");
                    element = scanner.nextInt();
                    if(integerBST.search(element))
                    {
                        integerBST.remove(element);
                        System.out.println("The new tree:");
                        integerBST.traverseInOrder();
                    }
                    else
                        System.out.println("ERROR: Element does not exists in the tree.");

                    break;
                case "P":
                    System.out.println("Enter a value to find its predecessor: ");
                    element = scanner.nextInt();
                    System.out.println("The successor of " + element + " is "
                            + integerBST.findPredecessor(element));
                    break;
                case "S":
                    System.out.println("Enter a value to find its successor: ");
                    element = scanner.nextInt();
                    System.out.println("The successor of " + element + " is "
                            + integerBST.findSuccessor(element));
                    break;
                case "E":
                    System.out.println("Goodbye!");
                    break;
                case "H":
                    String help = "I - Insert a value\n"
                            + "D - Delete a value\n"
                            + "P - Find predecessor\n"
                            + "S - Find sucessor\n"
                            + "E - Exit program\n"
                            + "H - Display this message\n"
                            + "PAR - Find parent\n"
                            + "MIN - Find the minimum element\n"
                            + "MAX - Find the maximum element\n"
                            + "FX - Launch JavaFX application";
                    System.out.println(help);
                    break;
                case "PAR":
                    System.out.println("Enter a value to find its parent: ");
                    element = scanner.nextInt();
                    System.out.println("Parent of " + element + " is " + integerBST.getParent(element));
                    break;
                case "MIN":
                    // Find minimum element in the tree.
                    System.out.println("\nMinimum Element: " + integerBST.findMin());
                    break;
                case "MAX":
                    // Find maximum element in the tree.
                    System.out.println("\nMaximum Element: " + integerBST.findMax());
                    break;
                case "FX":
                    launch(args);
                    break;
                default:
                    System.out.println("ERROR: Not a valid option.");
            }
        }while(!command.equals("E"));
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
