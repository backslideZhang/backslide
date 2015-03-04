import httpd.NanoHTTPD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MinHttpServer extends NanoHTTPD {

	private EverNoteService everNoteService = new EverNoteService();
	private File indexHtml = new File(ClassLoader.getSystemClassLoader().getResource("index.html").getPath());

	public MinHttpServer(int port) {
		super(port);
	}

	@Override
	public Response serve(IHTTPSession session) {
		if (session.getUri().equals("/")) {
			if (indexHtml.exists()) {
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(indexHtml);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				return new Response(Response.Status.OK, MIME_HTML, stream);
			}
		} else if (session.getUri().equals("/request-evernote")) {
			everNoteService.requestTokenTest();
		}
		return new Response("test");
	}
}
