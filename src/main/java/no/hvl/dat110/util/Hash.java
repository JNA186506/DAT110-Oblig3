package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
        MessageDigest messageDigest;
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        
        byte[] digestEntity = messageDigest
                .digest(entity.getBytes(StandardCharsets.UTF_8));
        
        String digestedEntity = toHex(digestEntity);
	
		return new BigInteger(digestedEntity, 16);
	}
	
	public static BigInteger addressSize() {
        
        int length = bitSize();
        
        return BigInteger.valueOf(2).pow(length);
	}
	
	public static int bitSize() {
        MessageDigest MD5Digest;
        try {
            MD5Digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }	
		int digestlen = MD5Digest.getDigestLength();
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
