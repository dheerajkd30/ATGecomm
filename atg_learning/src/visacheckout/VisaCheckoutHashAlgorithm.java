package visacheckout;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SignatureException;

public class VisaCheckoutHashAlgorithm {

	
	String sourceString = "WH$s-sU@YK7scZphszteYwZWtfbCShkMzp14Y6t7"; // shared secret + fields in correct format
	//String hash = sha256Digest(sourceString);

	public String sha256Digest (String data) throws SignatureException {
	 return getDigest("SHA-256", data, true);
	}

	private String getDigest(String algorithm, String data, boolean toLower) 
	 throws SignatureException {
	  try {
	 MessageDigest mac = MessageDigest.getInstance(algorithm);
	 mac.update(data.getBytes("UTF-8"));
	 return toLower ? 
	  new String(toHex(mac.digest())).toLowerCase() : new String(toHex(mac.digest()));
	  } catch (Exception e) {
	 throw new SignatureException(e);
	  }
	}

	private String toHex(byte[] bytes) {
	 BigInteger bi = new BigInteger(1, bytes);
	 return String.format("%0" + (bytes.length << 1) + "X", bi);
	}
	
}
