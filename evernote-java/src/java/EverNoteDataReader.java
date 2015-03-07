import com.evernote.auth.EvernoteAuth;
import com.evernote.auth.EvernoteService;
import com.evernote.clients.ClientFactory;
import com.evernote.clients.NoteStoreClient;
import com.evernote.clients.UserStoreClient;

public class EverNoteDataReader {
	public static final EvernoteService service = EvernoteService.SANDBOX;

	private UserStoreClient userStore = null;
	private NoteStoreClient noteStore = null;

	public EverNoteDataReader(String token) throws Exception {
		EvernoteAuth auth = new EvernoteAuth(service, token);
		ClientFactory factory = new ClientFactory(auth);
		userStore = factory.createUserStoreClient();
		noteStore = factory.createNoteStoreClient();
	}

}
