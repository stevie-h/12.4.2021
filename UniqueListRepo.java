package com.example;

import java.sql.*;
import java.util.*;


//ex3


public class UniqueListRepo
{
    private String m_conn;

    public UniqueListRepo(String m_conn)
    {
        this.m_conn = m_conn;
    }

    public ArrayList<UniqueListPOJO> select(String query)
    {
        ArrayList<UniqueListPOJO> unq_numbers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if (conn != null)
            {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {
                    UniqueListPOJO e = new UniqueListPOJO(rs.getInt("numbers_list"));
                    unq_numbers.add(e);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return unq_numbers;
    }

    public void update(String query)
    {
        try (Connection conn = DriverManager.getConnection(m_conn))
        {

            if (conn != null)
            {

                Statement stmt = conn.createStatement();

                int result = stmt.executeUpdate(query);
                System.out.println(result + " record updated.");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


}
