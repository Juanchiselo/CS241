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
import java.util.PriorityQueue;
import java.util.Stack;

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

    public double shortestDistance(Vertex<T> originVertex, Vertex<T> endVertex, Stack path)
    {
        double shortestDistance;
        boolean done = false;

        PriorityQueue<Vertex<T>> priorityQueue = new PriorityQueue<Vertex<T>>();
        priorityQueue.add(new (originVertex, 0, null))

        while(!done && !priorityQueue.isEmpty())
        {
            Vertex<T> frontEntry = priorityQueue.remove();
            from
        }



        priorityQueue.add(new EntryPQ(originVertex, 0, null))
        while (!done && !priorityQueue.isEmpty())
        {
            frontEntry = priorityQueue.remove()
            frontVertex = vertex in frontEntry
            if (frontVertex is not visited)
            {
                Mark frontVertex as visited
                Set the cost of the path to frontVertex to the cost recorded in frontEntry
                Set the predecessor of frontVertex to the predecessor recorded in frontEntry
                if (frontVertex equals endVertex)
                done = true
else
                {
                    while (frontVertex has a neighbor)
                    {
                        nextNeighbor = next neighbor of frontVertex
                            weightOfEdgeToNeighbor = weight of edge to nextNeighbor
                        if (nextNeighbor is not visited)
                        {
                            nextCost = weightOfEdgeToNeighbor + cost of path to frontVertex
                            priorityQueue.add(new EntryPQ(nextNeighbor, nextCost,
                                    frontVertex))
                        }
                    }
                }
            }
        }
// traversal ends; construct cheapest path

        pathCost = cost of path to endVertex
        path.push(endVertex)
        vertex = endVertex
        while (vertex has a predecessor)
        {
            vertex = predecessor of vertex
            path.push(vertex)
        }
        return pathCost


        return shortestDistance;
    }
}
