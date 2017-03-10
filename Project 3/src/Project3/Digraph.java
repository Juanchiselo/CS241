/**
 * Name: Jose J. Sandoval
 * Class: CS241 - Data Structures and Algorithms II
 * Created On: March 9, 2017
 * Description: Directed graph class. In this project it is
 *      used to store the city and road information read
 *      from their respective files.
 */

package Project3;

import java.util.ArrayList;

public class Digraph<T>
{
    private ArrayList<Vertex<T>> vertices;
    private int edgeCount;

    /**
     * Default constructor.
     */
    public Digraph()
    {

    }

    public Digraph(ArrayList<Vertex<T>> vertices, int edgeCount)
    {
        this.vertices = vertices;
        this.edgeCount = edgeCount;
    }

    public ArrayList<Vertex<T>> getVertices()
    {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex<T>> vertices)
    {
        this.vertices = vertices;
    }

    public int getEdgeCount()
    {
        return edgeCount;
    }
}
