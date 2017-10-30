package Project3;

import java.util.ArrayList;

/**
 * Created by juanc on 3/10/2017.
 */
public class Vertex<T>
{
    private T data;
    private boolean isVisted = false;
    private ArrayList<Edge<T>> edges;
    private Vertex<T> previousVertex;
    private double cost;

    public Vertex(T data)
    {
        this.data = data;
        edges = new ArrayList<>();
        isVisted = false;
        previousVertex = null;
        cost = 0;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public boolean isVisted()
    {
        return isVisted;
    }

    public void visit()
    {
        isVisted = true;
    }

    public void unvisit()
    {
        isVisted = false;
    }

    public ArrayList<Edge<T>> getEdges()
    {
        return edges;
    }

    public Vertex<T> getPreviousVertex()
    {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex<T> previousVertex)
    {
        this.previousVertex = previousVertex;
    }

    public boolean hasPreviousVertex()
    {
        if(previousVertex != null)
            return true;
        else
            return false;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public boolean connect(Vertex<T> endVertex, double edgeWeight)
    {
        Edge<T> newEdge = new Edge<T>(endVertex, edgeWeight);

        if(edges.isEmpty())
        {
            edges.add(newEdge);
            return true;
        }
        else
        {
            for (Edge edge : edges)
            {
                if(!edge.getVertex().equals(newEdge.getVertex()))
                {
                    edges.add(newEdge);
                    return true;
                }
                else
                    System.out.println("This edge already exists!");
            }
        }

        return false;
    }

    public boolean connect(Vertex<T> endVertex)
    {
        return connect(endVertex, 0);
    }

    public ArrayList<Vertex<T>> getNeighbors()
    {
        ArrayList<Vertex<T>> neighbors = new ArrayList<Vertex<T>>();

        if(this.hasNeighbor())
        {
            for (Edge<T> edge : edges)
                neighbors.add(edge.getVertex());
        }

        return neighbors;
    }

    public ArrayList<Double> getWeights()
    {
        ArrayList<Double> weights = null;
        return weights;
    }

    public boolean hasNeighbor()
    {
        return !edges.isEmpty();
    }

    public ArrayList<Vertex<T>> getUnvisitedNeighbors()
    {
        ArrayList<Vertex<T>> unvisitedNeighbors = null;
        return unvisitedNeighbors;
    }

}
