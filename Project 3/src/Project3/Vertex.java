package Project3;

import java.util.ArrayList;

/**
 * Created by juanc on 3/10/2017.
 */
public class Vertex<T>
{
    private T data;
    private boolean isVisted = false;
    private ArrayList<Edge> edges;
    private Vertex<T> previousVertex;
    private double cost;

    public Vertex()
    {
    }

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

    public ArrayList<Edge> getEdges()
    {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges)
    {
        this.edges = edges;
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
        // TODO: If edge exists return false. Else return true;

        return false;
    }

    public boolean connect(Vertex<T> endVertex)
    {
        return false;
    }

    public ArrayList<Vertex<T>> getNeighbors()
    {
        ArrayList<Vertex<T>> neighbors = null;

        return neighbors;
    }

    public ArrayList<Double> getWeights()
    {
        ArrayList<Double> weights = null;
        return weights;
    }

    public boolean hasNeighbor()
    {
        return false;
    }

    public ArrayList<Vertex<T>> getUnvisitedNeighbors()
    {
        ArrayList<Vertex<T>> unvisitedNeighbors = null;
        return unvisitedNeighbors;
    }

}
