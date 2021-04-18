package com.example;


//ex4


public class Building
{

    protected int number_of_residents;
    protected boolean is_building_clean;
    protected boolean is_electricity_working;
    protected float cashbox;

    public int getNumber_of_residents()
    {
        return number_of_residents;
    }

    public boolean getIs_building_clean()
    {
        return is_building_clean;
    }

    public boolean getIs_electricity_working()
    {
        return is_electricity_working;
    }

    public float getCashbox()
    {
        return cashbox;
    }


    public boolean maintainBuilding()
    {
        if (is_building_clean == false)
        {
            boolean cleaner = callCleaner();
            if (cleaner == false)
            {
                return false;
            }
        }

        if (is_electricity_working == false)
        {
            boolean electrician = callElectrician();
            if (electrician == false)
            {
                return false;
            }
        }

        return true;
    }

    public boolean callCleaner()
    {
        if (cashbox < 100)
        {
            return false;
        }
        cashbox -= 100;
        is_building_clean = true;
        return true;
    }

    public boolean callElectrician()
    {
        if (cashbox < 300)
        {
            return false;
        }
        cashbox -= 300;
        is_electricity_working = true;
        return true;
    }

    public void collectMoney()
    {
        cashbox += 80 * (float)number_of_residents;
    }


}
