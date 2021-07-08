package service;

import dao.CityDao;
import domain.City;
import util.MySpring;

import java.util.ArrayList;

public class CityService {
    private CityDao cityDao= MySpring.getBean("dao.CityDao");
    public ArrayList<City> selectCityByAid(Integer aid){
        return cityDao.selectCityByAid(aid);
    }
}
