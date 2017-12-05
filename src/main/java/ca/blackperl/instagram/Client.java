package ca.blackperl.instagram;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jinstagram.Instagram;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.users.feed.UserFeed;
import org.jinstagram.entity.users.feed.UserFeedData;
import org.jinstagram.exceptions.InstagramException;

public class Client {
	private static final Logger log = LogManager.getLogger(Client.class);
	private static final String EMPTY_TOKEN = null;
	
	public static void main(String[] args) {
		String clientId = "640f1c75899f44139fc8acb342e60cea";
		String clientSecret = "9a1a3d81bb7140e89edcd54078202d18";
		String clientUrl = "http://www.blackperl.ca";
		
		InstagramService service = new InstagramAuthService()
				.apiKey(clientId)
				.apiSecret(clientSecret)
				.callback(clientUrl)     
				.build();
		
		Verifier verifier = new Verifier("verifier you get from the user");
		Token accessToken = service.getAccessToken(verifier);
		
		Instagram instagram = new Instagram(accessToken);
		UserFeed feed;
		try {
			feed = instagram.getUserFollowList("eldonolmstead");
			List<UserFeedData> users = feed.getUserList();
			
			for (Iterator iterator = users.iterator(); iterator.hasNext();) {
				UserFeedData userFeedData = (UserFeedData) iterator.next();
				
				System.out.println(userFeedData.getFullName());
			}
		} catch (InstagramException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

