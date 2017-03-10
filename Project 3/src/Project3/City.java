package Project3;

public class City
{
    private int cityNumber;
    private String cityCode;
    public String cityName;
    private int population;
    private int elevation;

    /**
     * Default Constructor.
     */
    public City()
    {
    }

    /**
     * Overloaded constructor.
     * @param cityNumber
     * @param cityCode
     * @param cityName
     * @param population
     * @param elevation
     */
    public City(int cityNumber, String cityCode,
                String cityName, int population,
                int elevation)
    {
        this.cityNumber = cityNumber;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.population = population;
        this.elevation = elevation;
    }

    public int getCityNumber()
    {
        return cityNumber;
    }

    public void setCityNumber(int cityNumber)
    {
        this.cityNumber = cityNumber;
    }

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getElevation()
    {
        return elevation;
    }

    public void setElevation(int elevation)
    {
        this.elevation = elevation;
    }

    @Override
    public String toString()
    {
        return cityNumber + " "
                + cityCode + " "
                + cityName + " "
                + population + " "
                + elevation;
    }

    public String toStringDebug() {
        return "City{" +
                "cityNumber=" + cityNumber +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", population=" + population +
                ", elevation=" + elevation +
                '}';
    }
}
