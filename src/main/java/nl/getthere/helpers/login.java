package nl.getthere.helpers;

import java.security.MessageDigest;

/**
 * Created by jasper.dejong on 27-9-2016.
 * Source: http://stackoverflow.com/questions/5531455/how-to-encode-some-string-with-sha256-in-java
 */
public class login {

    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
