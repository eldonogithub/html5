package ca.blackperl.apps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.oauth.InstagramService;

public class Instagram {
	private static final Logger log = LogManager.getLogger(Instagram.class);

	public static void main(String[] args) {
		InstagramService service = new InstagramAuthService().apiKey("your_client_id").apiSecret("your_client_secret")
				.callback("your_callback_url").build();
	}
}
