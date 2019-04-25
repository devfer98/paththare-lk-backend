package dto;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.management.openmbean.InvalidKeyException;
import static javax.swing.JOptionPane.showMessageDialog;

public class RefLinkGenerator {

    public String refLink = "Empty Referral Link !";
    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;

    public final String genLink(Date linkClickDate, Time clickTime, String promoterID, String SellerID, String productCode, String productLink) {

        try {

            String tempLink = linkClickDate.toString() + promoterID + SellerID + productCode + productLink + clickTime;
            //InitializeEncriptionDecryption();
            //refLink = EncriptRefLink(tempLink);
            refLink = tempLink;
            return refLink;

        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            return refLink = "Error in generating refferal link";
        }
    }

//    private void InitializeEncriptionDecryption() throws java.security.InvalidKeyException {
//        try {
//
//            // generate secret key using DES algorithm
//            key = KeyGenerator.getInstance("DES").generateKey();
//
//            ecipher = Cipher.getInstance("DES");
//            dcipher = Cipher.getInstance("DES");
//
//            // initialize the ciphers with the given key
//            ecipher.init(Cipher.ENCRYPT_MODE, key);
//
//            dcipher.init(Cipher.DECRYPT_MODE, key);
//
//            //String encrypted = EncriptRefLink("This is a classified message!");
//            //String decrypted = DecryptRefLink(encrypted);
//            //System.out.println("Decrypted: " + decrypted);
//
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("No Such Algorithm:" + e.getMessage());
//        } catch (NoSuchPaddingException e) {
//            System.out.println("No Such Padding:" + e.getMessage());
//        } catch (InvalidKeyException e) {
//            System.out.println("Invalid Key:" + e.getMessage());
//        }
//
//    }
//
//
//private String EncriptRefLink(String tempLink) {
//        try {
//            // encode the string into a sequence of bytes using the named charset
//            // storing the result into a new byte array.
//            byte[] utf8 = tempLink.getBytes("UTF8");
//            byte[] enc = ecipher.doFinal(utf8);
//
//            // encode to base64
//            enc = BASE64EncoderStream.encode(enc);
//            return new String(enc);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    private String DecryptRefLink(String tempLink) {
//        try {
//
//            // decode with base64 to get bytes
//            byte[] dec = BASE64DecoderStream.decode(tempLink.getBytes());
//            byte[] utf8 = dcipher.doFinal(dec);
//
//            // create new string based on the specified charset
//            return new String(utf8, "UTF8");
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            return null;
//        }
//
//    }
}
