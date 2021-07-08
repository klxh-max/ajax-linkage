package service;

import dao.CountryDao;
import domain.Country;
import util.MySpring;

import java.util.ArrayList;

public class CountryService {
    private CountryDao countryDao= MySpring.getBean("dao.CountryDao");

    public ArrayList<Country> selectAllCountry(){
        return countryDao.selectAllCountry();
    }
}
