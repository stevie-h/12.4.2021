package com.example;

import java.util.*;

//ex3

public class UniqueList
{
    Set<Integer> numbers_list = new HashSet<>();

    public boolean add(int num)
    {
        if (num > 0)
        {
            numbers_list.add(num);
            return true;
        }
        if (num < 0)
        {
            numbers_list.add(num);
            return false;
        }
        else
        {
            throw new ArithmeticException("Number received is 0!");
        }
    }


    @Override
    public String toString()
    {
        return "UniqueList{" +
                "numbers_list=" + numbers_list +
                '}';
    }

}
