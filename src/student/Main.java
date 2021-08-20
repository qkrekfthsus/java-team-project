package student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws IOException {
		String pw = "123456";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			System.out.println(String.format("%064x", new BigInteger(1, md.digest())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new FileReader("StudentData.txt"));
        
		while(true) {
            String line = br.readLine();
            if (line==null) break;
            System.out.println(line);
        }
        br.close();
	}

}
