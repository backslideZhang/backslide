package pku.servlet;

import com.google.inject.Singleton;
import pku.annotation.ProcessorClass;
import pku.processor.WebPageFileProcessor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@Singleton
@WebServlet(name = "css", urlPatterns = {"*.css", "*.html", "*.js"})
@ProcessorClass(WebPageFileProcessor.class)
public class WebPageFileServlet extends BaseHttpServlet {}