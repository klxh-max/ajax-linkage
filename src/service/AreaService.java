package service;

import dao.AreaDao;
import domain.Area;
import util.MySpring;

import java.util.ArrayList;

public class AreaService {
    private AreaDao areaDao= MySpring.getBean("dao.AreaDao");
    public ArrayList<Area> selectAreaByCid(Integer cid){
        return areaDao.selectAreaByCid(cid);
    }
}
