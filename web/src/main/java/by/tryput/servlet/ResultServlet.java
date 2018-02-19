package by.tryput.servlet;

import by.tryput.entity.Country;
import by.tryput.entity.Movie;
import by.tryput.services.CommonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    private HashMap<String, Object> filterParameters = new HashMap<>();
    private HashMap<String, Integer> paginationParameters = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        paginationParameters.put("page", Integer.parseInt(req.getParameter("page")));
        paginationParameters.put("elements", 3);
        CommonService commonService = InitServlet.getContext().getBean(CommonService.class);
        Map<Long, List<Movie>> result = commonService.findWithFilter(filterParameters, paginationParameters);
        result.forEach((k, v) -> {
            req.setAttribute("movies", v);
            req.setAttribute("pages", k);
        });
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/result.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        filterParameters.put("title", req.getParameter("title").equals("") ? null :
                req.getParameter("title"));
        filterParameters.put("createYear", req.getParameter("year") == null || req.getParameter("year").equals("") ? null
                : Integer.valueOf(req.getParameter("year")));
        filterParameters.put("country", req.getParameter("countries") == null || req.getParameter("countries").equals("") ? null
                : Country.valueOf(req.getParameter("countries")));
        paginationParameters.put("page", 1);
        paginationParameters.put("elements", 3);
        CommonService commonService = InitServlet.getContext().getBean(CommonService.class);
        Map<Long, List<Movie>> result = commonService.findWithFilter(filterParameters, paginationParameters);
        result.forEach((k, v) -> {
            req.setAttribute("movies", v);
            req.setAttribute("pages", k);
        });
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/result.jsp")
                .forward(req, resp);
    }
}
