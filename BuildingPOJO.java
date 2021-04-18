package com.example;


//ex4


public class BuildingPOJO
{

    public String test_name;
    public int number_of_residents;
    public String is_building_clean;
    public String is_electricity_working;
    public float cashbox;

    public BuildingPOJO()
    {

    }

    public BuildingPOJO(String test_name, int number_of_residents, String is_building_clean,
                        String is_electricity_working, float cashbox)
    {
        this.test_name = test_name;
        this.number_of_residents = number_of_residents;
        this.is_building_clean = is_building_clean;
        this.is_electricity_working = is_electricity_working;
        this.cashbox = cashbox;
    }

    @Override
    public String toString()
    {
        return "BuildingPOJO{" +
                "test_name='" + test_name + '\'' +
                ", number_of_residents=" + number_of_residents +
                ", is_building_clean='" + is_building_clean + '\'' +
                ", is_electricity_working='" + is_electricity_working + '\'' +
                ", cashbox=" + cashbox +
                '}';
    }

}
