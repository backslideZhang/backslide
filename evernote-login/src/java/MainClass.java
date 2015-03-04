import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.EvernoteApi;
import org.scribe.oauth.OAuthService;

public class MainClass {
	public static String API_KEY = "yiqixie-1605";
	public static String API_SECRET = "422898dae353fb8c";

	public static void main(String[] args) throws Exception {
		OAuthService service = new ServiceBuilder()
				.provider(new EvernoteApi())
				.apiKey(API_KEY)
				.apiSecret(API_SECRET)
				.build();
	}
}
