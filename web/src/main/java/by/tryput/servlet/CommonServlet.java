package by.tryput.servlet;


import by.tryput.CommonService;
import by.tryput.entity.CommonEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/common")
public class CommonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        CommonEntity entity = new CommonService().getEntity("Hello");
        String hello = entity.getText();

        req.setAttribute("text", entity);
        System.out.println(hello);
        req.getRequestDispatcher("/WEB-INF/jsp/common.jsp")
                .forward(req, resp);
    }
}
