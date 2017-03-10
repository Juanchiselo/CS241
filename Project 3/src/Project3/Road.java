package Project3;

public class Road
{
    private int fromCity;
    private int toCity;
    private int distance;

    public Road()
    {

    }

    public Road(int fromCity, int toCity,
                int distance)
    {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public int getFromCity() {
        return fromCity;
    }

    public void setFromCity(int fromCity) {
        this.fromCity = fromCity;
    }

    public int getToCity() {
        return toCity;
    }

    public void setToCity(int toCity) {
        this.toCity = toCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Road{" +
                "fromCity=" + fromCity +
                ", toCity=" + toCity +
                ", distance=" + distance +
                '}';
    }

}
