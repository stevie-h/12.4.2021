package com.example;

import java.util.*;


//ex2


public class CarRentalAgency
{
    static Random r = new Random();

    protected ArrayList<String> cars = new ArrayList<>();
    protected Stack<String> workers = new Stack<>();
    protected Queue<String> customers = new LinkedList<>();
    protected HashMap<String, Float> rentHourlyFee = new HashMap<>();
    protected float income;

    public CarRentalAgency()
    {

    }

    public void setCars(ArrayList<String> cars)
    {
        this.cars = cars;
    }

    public ArrayList<String> getCars()
    {
        return cars;
    }

    public void setWorkers(Stack<String> workers)
    {
        this.workers = workers;
    }

    public Stack<String> getWorkers()
    {
        return workers;
    }

    public void setCustomers(Queue<String> customers)
    {
        this.customers = customers;
    }

    public Queue<String> getCustomers()
    {
        return customers;
    }

    public void setRentHourlyFee(HashMap<String, Float> rentHourlyFee)
    {
        this.rentHourlyFee = rentHourlyFee;
    }

    public HashMap<String, Float> getRentHourlyFee()
    {
        return rentHourlyFee;
    }

    public void setIncome(float income)
    {
        this.income = income;
    }

    public float getIncome()
    {
        return income;
    }

    public void rentACar()
    {
        if (customers.size() == 0)
        {
            System.out.println("No customers waiting...");
            return;
        }
        if (workers.size() == 0)
        {
            System.out.println("Sorry, all our workers are busy right now");
            return;
        }
        if (cars.size() == 0)
        {
             System.out.println("Sorry, we have no cars available right now");
             return;
        }

        String worker = workers.pop();
        String next_customer = customers.poll();
        String car = cars.get(r.nextInt(cars.size()));     // random car
        cars.remove(car);

        Float car_fee = 0f;
        if (rentHourlyFee.containsKey(car))
        {
            car_fee = rentHourlyFee.get(car);
        }
        int rent_hours = r.nextInt(12) + 1;
        float rent_fee = car_fee * (float) rent_hours;
        income += rent_fee;

        System.out.println(String.format("The customer %s has rented the car %s for %d hours", next_customer, car, rent_hours));

        workers.add(worker);
    }

    public void returnACar (String customer, String car)
    {
        if (workers.size() == 0)
        {
            System.out.println("Sorry, all our workers are busy right now");
            return;
        }

        String worker = workers.pop();
        cars.add(car);
        System.out.println(String.format("The customer %s has returned the car %s", customer, car));
        workers.add(worker);
    }


    @Override
    public String toString()
    {
        return "CarRentalAgency{" +
                "cars=" + cars +
                ", workers=" + workers +
                ", customers=" + customers +
                ", rentHourlyFee=" + rentHourlyFee +
                ", income=" + income +
                '}';
    }
}
