package dao;

import domain.Area;
import domain.Country;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AreaDao {
    private String className="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/cons";
    private String password="cy414ljh212,,,";
    public ArrayList<Area> selectAreaByCid(Integer cid){
        ArrayList<Area> areaArrayList=new ArrayList<>();
        Area area=null;
        try {
            Class.forName(className);
            Connection connection= DriverManager.getConnection(url,"root",password);
            String sql="SELECT AID, ANAME FROM AREA WHERE CID = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,cid);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Country country=new Country(cid,null) ;
                area=new Area(resultSet.getInt("aid"), resultSet.getString("aname"),country);
                areaArrayList.add(area);
            }
            resultSet.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return areaArrayList;
    }
}
