package controller;

import domain.City;
import service.CityService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectCityByAid")
public class SelectCityByAidController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aid=req.getParameter("aid");
        CityService cityService= MySpring.getBean("service.CityService");
        ArrayList<City> cityArrayList= cityService.selectCityByAid(Integer.parseInt(aid));
        req.setAttribute("cityArrayList",cityArrayList);
        req.getRequestDispatcher("handleCityList.jsp").forward(req,resp);
    }
}
