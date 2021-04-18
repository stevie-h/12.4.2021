package com.example;

import org.junit.Test;
import java.util.*;
import static junit.framework.TestCase.assertEquals;

//ex3


public class UniqueListTestWithDB
{

    UniqueListRepo rep = new UniqueListRepo("jdbc:sqlite:C:\\SQLite\\120421.db");

    @Test
    public void testAddPositive()
    {
        ArrayList<UniqueListPOJO> ul_data = rep.select("SELECT * FROM UNIQUE_LIST WHERE numbers_list > 0");
        UniqueList uniqueList = new UniqueList();
        for (UniqueListPOJO one_row : ul_data)
        {
            boolean actual_result = uniqueList.add(one_row.numbers_list);
            assertEquals(true, actual_result);
        }
    }

    @Test
    public void testAddNegative()
    {
        ArrayList<UniqueListPOJO> ul_data = rep.select("SELECT * FROM UNIQUE_LIST WHERE numbers_list < 0");
        UniqueList uniqueList = new UniqueList();
        for (UniqueListPOJO one_row : ul_data)
        {
            boolean actual_result = uniqueList.add(one_row.numbers_list);
            assertEquals(false, actual_result);
        }
    }

    @Test (expected = ArithmeticException.class)
    public void testAddZero()
    {
        ArrayList<UniqueListPOJO> ul_data = rep.select("SELECT * FROM UNIQUE_LIST WHERE numbers_list = 0");
        UniqueList uniqueList = new UniqueList();
        for (UniqueListPOJO one_row : ul_data)
        {
            boolean actual_result = uniqueList.add(one_row.numbers_list);
            assertEquals(true, actual_result);          // true = throws exception
        }
    }

    @Test
    public void addSameNumber()
    {
        UniqueList uniqueList = new UniqueList();
        uniqueList.numbers_list.add(111);
        uniqueList.numbers_list.add(111);
        assertEquals(1, uniqueList.numbers_list.size());     // only 1 item added
    }


}