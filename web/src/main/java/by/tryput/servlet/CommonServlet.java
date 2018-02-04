package by.tryput.servlet;

import by.tryput.CommonService;
import by.tryput.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/start")
public class CommonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person = new CommonService().getPerson();
        req.setAttribute("person", person);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/first.jsp")
                .forward(req, resp);
    }

}
