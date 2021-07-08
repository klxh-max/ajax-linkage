package dao;

import domain.Area;
import domain.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CityDao {
    private String className="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/cons";
    private String password="cy414ljh212,,,";
    public ArrayList<City> selectCityByAid(Integer aid){
        ArrayList<City> cityArrayList=new ArrayList<>();
        City city=null;
        try {
            Class.forName(className);
            Connection connection= DriverManager.getConnection(url,"root",password);
            String sql="SELECT CITYID, CITYNAME, CITYSIZE FROM CITY WHERE AID = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,aid);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Area area=new Area(aid,null,null) ;
                city=new City(resultSet.getInt("cityid"), resultSet.getString("cityname"),resultSet.getInt("citysize"),area);
                cityArrayList.add(city);
            }
            resultSet.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cityArrayList;
    }
}
