import httpd.NanoHTTPD;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MinHttpServer extends NanoHTTPD {

	private EverNoteImportService everNoteService = new EverNoteImportService();
	private File indexHtml = new File(ClassLoader.getSystemClassLoader().getResource("index.html").getPath());

	private boolean onRequestAuth = false;

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
			} else {
				return new Response("error");
			}
		} else if (session.getUri().equals("/requestAuthorizationUrl")) {
			onRequestAuth = true;
			return new Response(everNoteService.requestAuthorizationUrl());
		} else if (session.getUri().equals("/auth_over")) {
			everNoteService.getAuthorization(session.getParms());
			onRequestAuth = false;
			return new Response("");
		} else if (session.getUri().equals("/waitForAuth")) {
			while (onRequestAuth) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return new Response("test");
		} else if (session.getUri().lastIndexOf('/') == 0) {
			String fileName = session.getUri().substring(1);
			File file = new File(ClassLoader.getSystemClassLoader().getResource(fileName).getPath());
			if (file.exists()) {
				FileInputStream stream = null;
				try {
					stream = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				return new Response(Response.Status.OK, MIME_HTML, stream);
			} else {
				return new Response("error");
			}
		} else {
			System.out.println(session.getUri());
			return new Response("unknown url");
		}
	}
}
