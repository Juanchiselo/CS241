package Project3;

/**
 * Created by juanc on 3/10/2017.
 */
public class Edge<T>
{
    private Vertex<T> vertex;
    private double weight;

    public Edge()
    {

    }

    public Edge(Vertex<T> vertex, double weight)
    {
        this.vertex = vertex;
        this.weight = weight;
    }

    public Vertex<T> getVertex()
    {
        return vertex;
    }

    public void setVertex(Vertex<T> vertex)
    {
        this.vertex = vertex;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertex=" + vertex.toString() +
                ", weight=" + weight +
                '}';
    }
}
