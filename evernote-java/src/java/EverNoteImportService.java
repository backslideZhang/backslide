import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.EvernoteApi;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.util.Map;

public class EverNoteImportService {
	private static String API_KEY = "yiqixie-1605";
	private static String API_SECRET = "422898dae353fb8c";
	private static String HOSTNAME = "http://127.0.0.1:10086";

	private Token requestToken = null;
	private Token authoredToken = null;
	private Token accessToken = null;

	EverNoteDataReader everNoteDataReader = null;

	private OAuthService oAuthService = null;

	public EverNoteImportService() {
		oAuthService = new ServiceBuilder()
				.provider(new EvernoteApi.Sandbox())
				.apiKey(API_KEY)
				.apiSecret(API_SECRET)
				.callback(HOSTNAME + "/auth_over")
				.build();
	}

	public String requestAuthorizationUrl() {
		requestToken = oAuthService.getRequestToken();
		return oAuthService.getAuthorizationUrl(requestToken);
	}

	public void getAuthorization(Map<String, String> parms) {
		authoredToken = new Token(parms.get("oauth_token"), requestToken.getSecret());
		Verifier verifier = new Verifier(parms.get("oauth_verifier"));
		accessToken = oAuthService.getAccessToken(authoredToken, verifier);
		try {
			everNoteDataReader = new EverNoteDataReader(accessToken.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
