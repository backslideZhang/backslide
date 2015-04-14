package pku.module;

import com.google.inject.Provides;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.ServletModule;
import pku.annotation.RequestUri;
import pku.servlet.WebPageFileServlet;
import pku.servlet.HomePageServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

public class MainServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        registryServlet(WebPageFileServlet.class);
        registryServlet(HomePageServlet.class);
    }

    private void registryServlet(Class<? extends HttpServlet> servletClass) {
        Annotation[] annotations = servletClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i].annotationType().equals(WebServlet.class)) {
                WebServlet webServlet = (WebServlet) annotations[i];
                String[] urls = webServlet.urlPatterns();
                for (int j = 0; j < urls.length; j++) {
                    serve(urls[j]).with(servletClass);
                }
                break;
            }
        }
    }

    @Provides
    @RequestScoped
    @RequestUri
    public String getRequestUri(HttpServletRequest request) {
        return request.getRequestURI();
    }
}