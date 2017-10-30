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
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public boolean insertEdge(Vertex<T> startVertex, Vertex<T> endVertex, double weight)
    {
        if(startVertex.connect(endVertex, weight))
        {
            edgeCount++;
            return true;
        }

        return false;
    }

    public boolean removeEdge(Vertex<T> startVertex, Vertex<T> endVertex)
    {
        ArrayList<Edge<T>> edges = startVertex.getEdges();

        for (int i = 0; i < edges.size(); i++)
        {
            if(edges.get(i).getVertex().equals(endVertex))
            {
                edges.remove(i);
                System.out.println(edges.toString());
                return true;
            }
        }

        return false;
    }

    public ArrayList<Vertex<T>> shortestDistance(Vertex<T> startVertex, Vertex<T> endVertex)
    {
        ArrayList<Vertex<T>> path = new ArrayList<>();

        for(int i = 0; i < vertices.size(); i++)
        {
            vertices.get(i).setCost(Double.POSITIVE_INFINITY);
            vertices.get(i).setPreviousVertex(null);
        }

        // Distance from source to source.
        startVertex.setCost(0);

        //PriorityQueue
        PriorityQueue<Vertex<T>> vertexPriorityQueue = new PriorityQueue<Vertex<T>>(vertices.size(), costComparator);
        for(Vertex<T> vertex : vertices)
            vertexPriorityQueue.add(vertex);

        while(!vertexPriorityQueue.isEmpty())
        {
            Vertex<T> closestVector = vertexPriorityQueue.poll();

            if(closestVector.getCost() == Double.POSITIVE_INFINITY)
                break;

            vertexPriorityQueue.remove(closestVector);

            for(Vertex<T> neighbor : closestVector.getNeighbors())
            {
                double costDifference = closestVector.getCost() + neighbor.getCost();

                if(costDifference < neighbor.getCost())
                {
                    neighbor.setCost(costDifference);
                    neighbor.setPreviousVertex(closestVector);
                    path.add(closestVector);
                }

                path.add(closestVector);
            }
        }
        return path;
    }

    //Comparator anonymous class implementation
    private Comparator<Vertex<T>> costComparator;
    {
        costComparator = new Comparator<Vertex<T>>()
        {
            @Override
            public int compare(Vertex<T> vertex, Vertex<T> nextVertex)
            {
                return (int) (vertex.getCost() - nextVertex.getCost());
            }
        };
    }

}
