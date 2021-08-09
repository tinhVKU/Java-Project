package mahoa;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {
	public static String encrypt(String srcText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String enrText;
		MessageDigest msd = MessageDigest.getInstance("MD5");
		byte[] srcTextbytes = srcText.getBytes("UTF-8");
		byte[] enrTextBytes = msd.digest(srcTextbytes);
		BigInteger bigInt = new BigInteger(1,enrTextBytes);
		enrText = bigInt.toString(16);
		return enrText;
	}
	
	public static void main(String[] args) {
		String srcText;
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Text: ");
		srcText = sc.nextLine();
		try {
			String enrText = MD5.encrypt(srcText);
			
//			System.out.println("Source Text: "+ srcText);
			System.out.println("Encrypt Text: "+ enrText);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
