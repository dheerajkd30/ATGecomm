package visacheckout;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import atg.core.util.Base64;


public class VisaCheckoutEncryptDecrypt {

	private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
	private static final String HASH_ALGORITHM = "SHA-256";
	private static final String HMAC_ALGORITHM = "HmacSHA256";
	private static final int IV_LENGTH = 16, HMAC_LENGTH = 32;
	private static final Provider bcProvider=null;
	
	/*static {
		bcProvider = new BouncyCastleProvider();
		if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
			// Security.addProvider(new
			// org.bouncycastle.jce.provider.BouncyCastleProvider());
			Security.addProvider(bcProvider);
		}
	}*/
	//Base64-decode the encKey.
	//Remove the first 32 bytes of the decoded value. This is the HMAC (Hash Message Authentication Code).
	//Calculate a SHA-256 HMAC of the rest of the decoded data using your API shared secret and compare it to the HMAC from the first 32 bytes.
	//The next 16 bytes should be removed and used as the IV (Initialization Vector) for the decryption algorithm.
	//Decrypt the remaining data using AES-256-CBC, the IV from step 3, and the SHA-256 hash of the your API Shared Secret.


	public static Object decrypt(byte[] key, byte[] data) {

		try {
			byte[] decodedData = null;
			byte[] decodedkey = null;
			String sharedAPIKey = "7O07VN664O10JW6A9ESS113p8sf9JeGzr6_2haC9F9m_ANtLM";
			byte [] sskb = sharedAPIKey.getBytes();
			decodedkey = Base64.decodeToByteArray(key);
			byte[] hmac = new byte[HMAC_LENGTH];
			System.arraycopy(decodedkey, 0, hmac, 0, HMAC_LENGTH);
			if (!Arrays.equals(
					hmac,
					hmac(sskb, decodedkey, HMAC_LENGTH, decodedkey.length
							- HMAC_LENGTH))) {
				throw new RuntimeException("HMAC validation failed.");
			}
			
			byte[] iv = new byte[IV_LENGTH];
			System.arraycopy(decodedkey, HMAC_LENGTH, iv, 0, IV_LENGTH);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, bcProvider);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(hash(sskb), "AES"),
					new IvParameterSpec(iv));
			
			
			decodedData = Base64.decodeToByteArray(data);
			
			return cipher.doFinal(decodedData, HMAC_LENGTH + IV_LENGTH,
					decodedData.length - HMAC_LENGTH - IV_LENGTH);
            
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	/*public static byte[] decrypt(byte[] key, byte[] data)
			throws GeneralSecurityException {
		byte[] decodedData = Base64.decode(data);
		if (decodedData == null || decodedData.length <= IV_LENGTH) {
			throw new RuntimeException("Bad input data.");
		}
		byte[] hmac = new byte[HMAC_LENGTH];
		System.arraycopy(decodedData, 0, hmac, 0, HMAC_LENGTH);
		if (!Arrays.equals(
				hmac,
				hmac(key, decodedData, HMAC_LENGTH, decodedData.length
						- HMAC_LENGTH))) {
			throw new RuntimeException("HMAC validation failed.");
		}
		byte[] iv = new byte[IV_LENGTH];
		System.arraycopy(decodedData, HMAC_LENGTH, iv, 0, IV_LENGTH);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, bcProvider);
		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(hash(key), "AES"),
				new IvParameterSpec(iv));
		return cipher.doFinal(decodedData, HMAC_LENGTH + IV_LENGTH,
				decodedData.length - HMAC_LENGTH - IV_LENGTH);
	}*/

	private static byte[] hash(byte[] key) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
		md.update(key);
		return md.digest();
	}

	private static byte[] hmac(byte[] key, byte[] data, int offset, int length)
			throws GeneralSecurityException {
		Mac mac = Mac.getInstance(HMAC_ALGORITHM);
		mac.init(new SecretKeySpec(key, HMAC_ALGORITHM));
		mac.update(data, offset, length);
		return mac.doFinal();
	}

}
