/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;

import java.security.NoSuchAlgorithmException;
import java.security.*;
import java.security.spec.*;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.*;
import disc.tiinfosec.businessobjects.UserCredential;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author daniel112
 */
public class Crypto {
    
    
    public static UserCredential generateStrongPasswordHash(String p_password, byte[] p_salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UserCredential uc = new UserCredential();
        int iterations = 1000;
        char[] chars = p_password.toCharArray();
        byte[] salt = p_salt;
        
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        uc.setLonghash(toHex(hash));
        uc.setSalt(toHex(salt));
        return uc;
    }
    
    public static boolean validatePassword(String p_originalPassword, String p_storedPassword, String p_salt) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        
        int iterations = 1000;
        byte[] salt = fromHex(p_salt);
        byte[] hash = fromHex(p_storedPassword);
         
        PBEKeySpec spec = new PBEKeySpec(p_originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();
         
        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
    
    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom nativeRND = SecureRandom.getInstance("Windows-PRNG");
        byte[] seed = nativeRND.generateSeed(55);
        SecureRandom sha1Random = SecureRandom.getInstance("SHA1PRNG");
        sha1Random.setSeed(seed);
        byte[] values = new byte[20];
        sha1Random.nextBytes(values);
        return values;
    }
    
    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
    
    public static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
    
}
