package business;

import java.util.Random;

public class StringGenerator {
	
		public String generateRandomPassword(int len) {
			String c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
			Random r = new Random();
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(c.charAt(r.nextInt(c.length())));
			return sb.toString();
		}
	

}
