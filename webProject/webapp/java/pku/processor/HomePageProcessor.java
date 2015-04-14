package pku.processor;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

@RequestScoped
public class HomePageProcessor {

    @Inject
    public HomePageProcessor(HttpServletResponse resp) throws Exception {
        File homePage = new File("html/home.html");
        PrintWriter writer = resp.getWriter();
        if (!homePage.exists()) {
            System.out.println("file not found!");
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(homePage));
            resp.setCharacterEncoding("UTF-8");
            String lineStr = null;
            while (reader.ready()) {
                lineStr = reader.readLine();
                if (lineStr == null) {
                    break;
                }
                writer.println(lineStr);
            }
        }
    }
}
