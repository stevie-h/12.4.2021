package com.example;

import java.sql.*;
import java.util.ArrayList;

import static com.example.Main.readStoresUpdateStatistics;


//ex5


public class StoresREPO
{

    private String m_conn;

    public StoresREPO(String m_conn)
    {
        this.m_conn = m_conn;
    }

    public ArrayList<StoresPOJO> select(String query)
    {
        ArrayList<StoresPOJO> storesPOJOS = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if (conn != null)
            {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    StoresPOJO s = new StoresPOJO(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getInt("Floor"),
                            rs.getInt("IsRestaurant"),
                            rs.getInt("IsOpenLate"),
                            rs.getInt("IsLarge"));
                    storesPOJOS.add(s);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return storesPOJOS;
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
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        readStoresUpdateStatistics();
    }


    public StoresPOJO getById(int id)
    {
        ArrayList<StoresPOJO> results =
                select("SELECT * FROM Stores WHERE ID = " + id);
        if (results.size() > 0)
            return results.get(0);
        else
            return null;
    }



}
