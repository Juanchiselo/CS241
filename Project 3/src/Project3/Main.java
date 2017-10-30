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

public class Main {


    // Creates a scanner object to read user input.
    private static Scanner scanner = new Scanner(System.in);

    // Variable for user input.
    private static String command = "";

    // Digraph
    public static Digraph<City> cityDigraph = new Digraph<City>();


    public static void main(String[] args) throws InterruptedException, IOException
    {
        System.out.println("Hello my baby\nHello my lady\nHello my ragtime doll");

        //consoleVersion();
    }

    public static void consoleVersion() throws FileNotFoundException
    {
        String userInput = "";

        String resourcesDirectory = System.getProperty("user.dir")
                + "\\src\\Project3\\Resources\\";


        // Read the city.dat file.
        String citiesData = readFile(resourcesDirectory + "city.dat", ",");
        ArrayList<City> cities = createCities(citiesData);
        ArrayList<Vertex<City>> vertices = new ArrayList<Vertex<City>>();
        for (int i = 0; i < cities.size(); i++)
            vertices.add(new Vertex<City>(cities.get(i)));
        cityDigraph.setVertices(vertices);

        // Read the road.dat file.
        String roadsData = readFile(resourcesDirectory + "road.dat", ",");
        ArrayList<Road> roads = createRoads(roadsData);
        for (Road road: roads)
        {
            Vertex<City> fromCity = findCityByNumber(road.getFromCity());
            Vertex<City> toCity = findCityByNumber(road.getToCity());
            double distance = road.getDistance();

            if(!cityDigraph.insertEdge(fromCity, toCity, distance))
                System.out.println("A road failed to be inserted.");
        }

        ArrayList<String> edgeData;
        Vertex<City> fromCity;
        Vertex<City> toCity;
        double distance;


        System.out.println(
                  "======================================================================\n"
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
                    edgeData = parseStringToStrings(userInput, "[ ]+");
                    fromCity = findCityByCode(edgeData.get(0));
                    toCity = findCityByCode(edgeData.get(1));

                    ArrayList<Vertex<City>> path = cityDigraph.shortestDistance(fromCity, toCity);


                    System.out.print("The minimum distance between "
                        + fromCity.getData().getCityName() + " and "
                        + toCity.getData().getCityName() + " is "
                        + " trough the route: ");
                    for (int i = 0; i < path.size(); i++)
                    {
                        System.out.println(path.get(i).getData().getCityCode());
                    }
                    break;
                case "E":
                    System.exit(0);
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
                    edgeData = parseStringToStrings(userInput, "[ ]+");

                    if(edgeData.size() != 3)
                    {
                        System.out.println("You're missing an item.");
                        break;
                    }


                    fromCity = findCityByCode(edgeData.get(0));
                    toCity = findCityByCode(edgeData.get(1));
                    distance = Double.valueOf(edgeData.get(2));

                    if(fromCity != null && toCity != null)
                    {
                        if(cityDigraph.insertEdge(fromCity, toCity, distance))
                            System.out.println("You have inserted a road from "
                                    + fromCity.getData().getCityName()
                                    + " (" + fromCity.getData().getCityCode() + ") to "
                                    + toCity.getData().getCityName()
                                    + " (" + toCity.getData().getCityCode() + ") "
                                    + "with a distance of " + distance + ".");
                        else
                            System.out.println("The road going from "
                                    + fromCity.getData().getCityName()
                                    + " (" + fromCity.getData().getCityCode() + ") to "
                                    + toCity.getData().getCityName()
                                    + " (" + toCity.getData().getCityCode() + ") "
                                    + "could not be inserted.");
                    }
                    else
                        System.out.println("One of the city codes does not exist.");

                    break;
                case "Q":
                    System.out.print("City code: ");
                    userInput = scanner.nextLine().toUpperCase();
                    Vertex<City> city = findCityByCode(userInput);
                    if(city != null)
                        System.out.println(city.getData().toString());
                    else
                        System.out.println("The city corresponding to city code "
                                + userInput + " does not exist.");
                    break;
                case "R":
                    System.out.print("City codes: ");
                    userInput = scanner.nextLine().toUpperCase();
                    edgeData = parseStringToStrings(userInput, "[ ]+");
                    fromCity = findCityByCode(edgeData.get(0));
                    toCity = findCityByCode(edgeData.get(1));

                    if(cityDigraph.removeEdge(fromCity, toCity))
                        System.out.println("The road from "
                                + fromCity.getData().getCityName()
                                + " (" + fromCity.getData().getCityCode() + ") and "
                                + toCity.getData().getCityName()
                                + " (" + toCity.getData().getCityCode() + ") "
                                + " has been removed.");
                    else
                        System.out.println("The road going from "
                                + fromCity.getData().getCityName()
                                + " (" + fromCity.getData().getCityCode() + ") to "
                                + toCity.getData().getCityName()
                                + " (" + toCity.getData().getCityCode() + ") "
                                + "does not exist.");



                    break;
                default:
                    System.out.println("ERROR: " + command + " is not a valid option.");
            }
        }while(!command.equals("E"));
    }

    /**
     * Finds a city from a given city code.
     * @param cityCode - A city code used for searching a city.
     * @return - The city if found or null if not found.
     */
    public static Vertex<City> findCityByCode(String cityCode)
    {
        for (Vertex<City> vertex : cityDigraph.getVertices())
            if(vertex.getData().getCityCode().equals(cityCode))
                return vertex;

        return null;
    }

    public static Vertex<City> findCityByNumber(int cityNumber)
    {
        for (Vertex<City> vertex : cityDigraph.getVertices())
            if(vertex.getData().getCityNumber() == cityNumber)
                return vertex;

        return null;
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
                data = data + line + delimiter;
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

    public static ArrayList<City> createCities(String data)
    {
        ArrayList<City> cities = new ArrayList<>();

        ArrayList<String> citiesStrings = parseStringToStrings(data, ",");

        for(int i = 0; i < citiesStrings.size(); i++)
        {
            City city = new City();
            String cityStr = citiesStrings.get(i).trim().replaceAll("[ ]{2,}", ",");

            ArrayList<String> cityString = parseStringToStrings(cityStr, ",");

            for (int j = 0; j < cityString.size(); j++)
            {
                if (j == 0)
                    city.setCityNumber(Integer.valueOf(cityString.get(j)));
                else if (j == 1)
                    city.setCityCode(cityString.get(j));
                else if (j == 2)
                    city.setCityName(cityString.get(j));
                else if (j == 3)
                    city.setPopulation(Integer.valueOf(cityString.get(j)));
                else if (j == 4)
                    city.setElevation(Integer.valueOf(cityString.get(j)));
            }

            cities.add(city);
        }

        return cities;
    }

    public static ArrayList<Road> createRoads(String data)
    {
        ArrayList<Road> roads = new ArrayList<>();

        ArrayList<String> roadsStrings = parseStringToStrings(data, ",");

        for(int i = 0; i < roadsStrings.size(); i++)
        {
            Road road = new Road();
            String roadStr = roadsStrings.get(i).trim().replaceAll("[ ]{2,}", ",");

            ArrayList<String> roadString = parseStringToStrings(roadStr, ",");

            for (int j = 0; j < roadString.size(); j++)
            {
                if (j == 0)
                    road.setFromCity(Integer.valueOf(roadString.get(j)));
                else if (j == 1)
                    road.setToCity(Integer.valueOf(roadString.get(j)));
                else if (j == 2)
                    road.setDistance(Integer.valueOf(roadString.get(j)));
            }

            roads.add(road);
        }

        return roads;
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


