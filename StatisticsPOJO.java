package com.example;


//ex5


public class StatisticsPOJO
{
    public int id;
    public int floor;
    public int numberOfRestaurants;
    public int numberOfOpenLate;
    public int numberOfLargeStores;

    public StatisticsPOJO()
    {

    }

    public StatisticsPOJO(int id, int floor, int numberOfRestaurants, int numberOfOpenLate, int numberOfLargeStores)
    {
        id = id;
        floor = floor;
        numberOfRestaurants = numberOfRestaurants;
        numberOfOpenLate = numberOfOpenLate;
        numberOfLargeStores = numberOfLargeStores;
    }


    @Override
    public String toString()
    {
        return "StatisticsPOJO{" +
                "Id=" + id +
                ", Floor=" + floor +
                ", NumberOfRestaurants=" + numberOfRestaurants +
                ", NumberOfOpenLate=" + numberOfOpenLate +
                ", NumberOfLargeStores=" + numberOfLargeStores +
                '}';
    }

}
