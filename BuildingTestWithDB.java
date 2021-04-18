package com.example;

import org.junit.Test;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;


//ex4


public class BuildingTestWithDB
{
    BuildingRepo rep = new BuildingRepo("jdbc:sqlite:C:\\SQLite\\120421.db");

    @Test
    public void testCollectMoney()
    {
        ArrayList<BuildingPOJO> build = rep.select("SELECT * FROM BUILDING WHERE test_name = 'TestCollect'");
        Building building = new Building();

        for (BuildingPOJO one_row : build)
        {
            building.cashbox = one_row.cashbox;
            float actual_result = building.getCashbox();
            assertEquals(one_row.cashbox, actual_result);
        }

    }

    @Test
    public void testMaintainBuilding_notEnoughMoneyCashbox()
    {
        ArrayList<BuildingPOJO> build = rep.select("SELECT * FROM BUILDING WHERE test_name = 'TestNotEnough'");
        Building building = new Building();

        for (BuildingPOJO one_row : build)
        {
            building.cashbox = one_row.cashbox;
            building.is_building_clean = one_row.is_building_clean;
            building.is_electricity_working = one_row.is_electricity_working;
            boolean actual_result =  building.maintainBuilding();
            assertEquals(false, actual_result);
        }
    }

    @Test
    public void testMaintainBuilding_Cleaning()
    {
        ArrayList<BuildingPOJO> build = rep.select("SELECT * FROM BUILDING WHERE test_name = 'TestClean'");
        Building building = new Building();

        for (BuildingPOJO one_row : build)
        {
            building.cashbox = one_row.cashbox;
            building.is_building_clean = one_row.is_building_clean;
            building.is_electricity_working = one_row.is_electricity_working;
            building.maintainBuilding();
            float actual_result = one_row.cashbox - 100;
            assertEquals(building.cashbox, actual_result);
        }
    }

    @Test
    public void testMaintainBuilding_Electrical()
    {
        ArrayList<BuildingPOJO> build = rep.select("SELECT * FROM BUILDING WHERE test_name = 'TestElectric'");
        Building building = new Building();

        for (BuildingPOJO one_row : build)
        {
            building.cashbox = one_row.cashbox;
            building.is_building_clean = one_row.is_building_clean;
            building.is_electricity_working = one_row.is_electricity_working;
            building.maintainBuilding();
            float actual_result = one_row.cashbox - 300;
            assertEquals(building.cashbox, actual_result);
        }
    }


}
