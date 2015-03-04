import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.EvernoteApi;
import org.scribe.builder.api.SinaWeiboApi;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

public class EverNoteService {
	private static String API_KEY = "2178327133";
	private static String API_SECRET = "67b0153c234c5423bcbba7078af6d127";
//	private static String API_KEY = "yiqixie-1605";
//	private static String API_SECRET = "422898dae353fb8c";

	private OAuthService oAuthService = null;

	public EverNoteService() {
		oAuthService = new ServiceBuilder()
				.provider(new SinaWeiboApi())
				.apiKey(API_KEY)
				.apiSecret(API_SECRET)
				.build();
	}

	public void requestTokenTest() {
		Token scribeToken = oAuthService.getRequestToken();
		System.out.println("response:"+scribeToken.getRawResponse());
		System.out.println("token:"+scribeToken.getToken());
		System.out.println("secret:"+scribeToken.getSecret());
	}
}
