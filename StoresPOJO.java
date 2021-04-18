package com.example;

public class StoresPOJO
{

    public int id;
    public String name;
    public int floor;
    public int isRestaurant;
    public int isOpenLate;
    public int isLarge;

    public StoresPOJO()
    {

    }

    public StoresPOJO(int id, String name, int floor, int isRestaurant, int isOpenLate, int isLarge)
    {
        id = id;
        name = name;
        floor = floor;
        isRestaurant = isRestaurant;
        isOpenLate = isOpenLate;
        isLarge = isLarge;
    }

    @Override
    public String toString()
    {
        return "StorePOJO{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Floor=" + floor +
                ", IsRestaurant=" + isRestaurant +
                ", IsOpenLate=" + isOpenLate +
                ", IsLarge=" + isLarge +
                '}';
    }

}
