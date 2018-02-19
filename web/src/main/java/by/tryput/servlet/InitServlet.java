package by.tryput.servlet;

import by.tryput.config.ServletsConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

    private static AnnotationConfigApplicationContext annotationConfigApplicationContext;

    static {
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ServletsConfig.class);
    }

    @Override
    public void destroy() {
        annotationConfigApplicationContext.destroy();
        super.destroy();
    }

    public static AnnotationConfigApplicationContext getContext() {
        return annotationConfigApplicationContext;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
