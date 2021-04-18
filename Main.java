package com.example;

import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        //ex1
        /*
        1. Stack - C (stack of clothes)
        2. Queue - B (branch customers)
        3. Set - D (actors)
        4. HashMap - E (dictionary)
        5. ArrayList - A (shopping list)

        */

        //ex2
        CarRentalAgency car_ex2 = new CarRentalAgency();

        car_ex2.workers.add("Worker 1");
        car_ex2.workers.add("Worker 2");
        car_ex2.workers.add("Worker 3");
        car_ex2.workers.add("Worker 4");
        car_ex2.workers.add("Worker 5");

        car_ex2.customers.add("Customer 1");
        car_ex2.customers.add("Customer 2");
        car_ex2.customers.add("Customer 3");
        car_ex2.customers.add("Customer 4");
        car_ex2.customers.add("Customer 5");

        car_ex2.cars.add("Picanto");
        car_ex2.cars.add("Rio");
        car_ex2.cars.add("Fortte");
        car_ex2.cars.add("Sportage");
        car_ex2.cars.add("Optima");

        car_ex2.rentHourlyFee.put("Picanto", 15f);
        car_ex2.rentHourlyFee.put("Rio", 20f);
        car_ex2.rentHourlyFee.put("Fortte", 25f);
        car_ex2.rentHourlyFee.put("Sportage", 30f);
        car_ex2.rentHourlyFee.put("Optima", 35f);

        car_ex2.rentACar();
        System.out.println("Car rented!");
        System.out.println(car_ex2);
        System.out.println();
        car_ex2.returnACar("Control Customer", "Control Car");

        //ex5

        readStoresUpdateStatistics();

    }

    public static void readStoresUpdateStatistics()
    {
        StoresREPO storesREPO = new StoresREPO("jdbc:sqlite:C:\\SQLite\\120421.db");
        StatisticsREPO statisticsREPO = new StatisticsREPO("jdbc:sqlite:C:\\SQLite\\120421.db");

        statisticsREPO.update("DELETE FROM Statistics WHERE Id > 0");

        int num_floors = 3;            // don't know how to get the max from the DB...
        for (int i1 = 1; i1 <= num_floors; i1++)
        {
            ArrayList<StoresPOJO> stores = storesREPO.select("SELECT * FROM Stores WHERE Floor = " + i1);

            int countNumRestaurants = 0;
            int countNumOpenLate = 0;
            int countNumLarge = 0;

            for (int i2 = 0; i2 < stores.size(); i2++)         // all stores per floor
            {
                if (stores.get(i2).isRestaurant == 1)
                {
                    countNumRestaurants++;
                }
                if (stores.get(i2).isOpenLate == 1)
                {
                    countNumOpenLate++;
                }
                if (stores.get(i2).isLarge == 1)
                {
                    countNumLarge++;
                }
            }
            statisticsREPO.update(String.format("INSERT INTO Statistics (Floor, NumberOfRestaurants, NumberOfOpenLate, NumberOfLargeStores) " +
                    "Values (%d, %d, %d, %d)", i1, countNumRestaurants, countNumOpenLate, countNumLarge));
        }
    }


}
