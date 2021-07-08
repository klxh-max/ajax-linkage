package dao;

import domain.Country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CountryDao {
    private String className="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/cons";
    private String password="cy414ljh212,,,";
    public ArrayList<Country> selectAllCountry(){
        ArrayList<Country> countryArrayList=new ArrayList<>();
        Country country=null;
        try {
            Class.forName(className);
            Connection connection= DriverManager.getConnection(url,"root",password);
            String sql="SELECT CID, CNAME FROM COUNTRY";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                country=new Country(resultSet.getInt("cid"), resultSet.getString("cname"));
                countryArrayList.add(country);
            }
            resultSet.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return countryArrayList;
    }
}
