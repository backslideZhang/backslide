package pku.servlet;

import com.google.inject.Singleton;
import pku.annotation.ProcessorClass;
import pku.processor.HomePageProcessor;

import javax.servlet.annotation.WebServlet;

@Singleton
@WebServlet(name = "homePage", urlPatterns = {"/home", "/home/*"})
@ProcessorClass(HomePageProcessor.class)
public class HomePageServlet extends BaseHttpServlet {}
