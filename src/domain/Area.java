package domain;

public class Area {
    private Integer aid;
    private String aname;
    private Country country;

    public Area() {}

    public Area(Integer aid, String aname, Country country) {
        this.aid = aid;
        this.aname = aname;
        this.country = country;
    }

    public Integer getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public Country getCountry() {
        return country;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
