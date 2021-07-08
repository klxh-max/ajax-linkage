package controller;

import domain.Country;
import service.CountryService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAllCountry")
public class SelectAllCountryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountryService countryService= MySpring.getBean("service.CountryService");
        ArrayList<Country> countryArrayList= countryService.selectAllCountry();
        req.setAttribute("countryArrayList",countryArrayList);
        req.getRequestDispatcher("regist.jsp").forward(req,resp);
    }
}
