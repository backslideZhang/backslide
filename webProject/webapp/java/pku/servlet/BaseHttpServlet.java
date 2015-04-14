package pku.servlet;

import com.google.inject.Inject;
import com.google.inject.Injector;
import pku.annotation.ProcessorClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseHttpServlet extends HttpServlet {
    @Inject
    private Injector injector;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProcessorClass processorClass = getClass().getAnnotation(ProcessorClass.class);
        if (processorClass != null) {
            injector.getInstance(processorClass.value());
        }
    }
}
