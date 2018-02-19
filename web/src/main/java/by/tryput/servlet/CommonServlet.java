package by.tryput.servlet;

import by.tryput.services.CommonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        AnnotationConfigApplicationContext context = InitServlet.getContext();
        CommonService service = context.getBean(CommonService.class);
        req.setAttribute("countries", service.getAllCountries());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/start-filter.jsp")
                .forward(req, resp);
    }


}
