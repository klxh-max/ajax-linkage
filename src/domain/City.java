package domain;

public class City {
    private Integer cityid;
    private String cityname;
    private Integer citysize;
    private Area area;

    public City() {}

    public City(Integer cityid, String cityname, Integer citysize, Area area) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.citysize = citysize;
        this.area = area;
    }

    public Integer getCityid() {
        return cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public Integer getCitysize() {
        return citysize;
    }

    public Area getArea() {
        return area;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public void setCitysize(Integer citysize) {
        this.citysize = citysize;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
