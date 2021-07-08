package controller;

import domain.Area;
import service.AreaService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAreaByCid")
public class SelectAreaByCidController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid=req.getParameter("cid");
        AreaService areaService= MySpring.getBean("service.AreaService");
        ArrayList<Area> areaArrayList=areaService.selectAreaByCid(Integer.parseInt(cid));
        req.setAttribute("areaArrayList",areaArrayList);
        //1.转发  JSP（本身就是拼接响应 内容就是响应信息）
        req.getRequestDispatcher("handleAreaList.jsp").forward(req,resp);
        //2.自己拼接响应（JSON）
    }
}
