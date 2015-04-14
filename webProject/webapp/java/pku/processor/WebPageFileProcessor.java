package pku.processor;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import pku.annotation.RequestUri;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

@RequestScoped
public class WebPageFileProcessor {

    @Inject
    WebPageFileProcessor(HttpServletResponse resp, @RequestUri String uri) throws Exception {
        String path = null;
        if (uri == null) {
            return;
        }
        if (uri.startsWith("/")) {
            path = uri.substring(1);
        } else {
            path = uri;
        }
        if (uri.endsWith("js")) {
            resp.setContentType("text/javascript;charset=UTF-8");
        } else if (uri.endsWith("css")) {
            resp.setContentType("text/css;charset=UTF-8");
//        } else if (uri.endsWith("html")) {
        }
        File file = new File(path);
        PrintWriter writer = resp.getWriter();
        if (!file.exists()) {
            System.out.println("file not found!");
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(file));
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
