public class MainClass {

	public static void main(String[] args) throws Exception {
		MinHttpServer server = new MinHttpServer(10086);
		server.start();
		while (true) {
			Thread.sleep(1000);
		}
	}
}
