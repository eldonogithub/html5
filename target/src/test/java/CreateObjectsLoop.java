import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CreateObjectsLoop {
	private static Logger log = Logger.getLogger(CreateObjectsLoop.class.toString());
	public static void main(String[] args) {
		List<BigClass> list = new ArrayList<BigClass>();

		log.info("Start");
		for( int i = 0; i < 10000; i++) {
			list.add(new BigClass());
		}
		log.info("End");
	}

}
