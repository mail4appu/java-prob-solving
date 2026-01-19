package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;

public class ReadCertifcateFile {

	public static void main(String[] args) {
		try {
			loadPublicX509("/home/Test/Downloads/okta.cert");
			BufferedReader bf= new BufferedReader(new InputStreamReader(new FileInputStream(new File("/home/Test/Downloads/okta.cert"))));
			try {
				String line="";
				while((line=bf.readLine())!=null){
					System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static X509Certificate loadPublicX509(String fileName) 
	        throws GeneralSecurityException, FileNotFoundException {
	    InputStream is = null;
	    X509Certificate crt = null;
	    try {
	        //is = fileName.getClass().getResourceAsStream("/" + fileName);
	    	is=new FileInputStream(fileName);
	        CertificateFactory cf = CertificateFactory.getInstance("X.509");
	        crt = (X509Certificate)cf.generateCertificate(is);
	        System.out.println(crt.getSignature());
	        System.out.println(crt.toString());
	        PublicKey pk = crt.getPublicKey();
	        System.out.println(pk.toString());
	    } finally {
	        closeSilent(is);
	    }
	    return crt;
	}

	public static PrivateKey loadPrivateKey(String fileName) 
	        throws IOException, GeneralSecurityException {
	    PrivateKey key = null;
	    InputStream is = null;
	    try {
	        is = fileName.getClass().getResourceAsStream("/" + fileName);
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        StringBuilder builder = new StringBuilder();
	        boolean inKey = false;
	        for (String line = br.readLine(); line != null; line = br.readLine()) {
	            if (!inKey) {
	                if (line.startsWith("-----BEGIN ") && 
	                        line.endsWith(" PRIVATE KEY-----")) {
	                    inKey = true;
	                }
	                continue;
	            }
	            else {
	                if (line.startsWith("-----END ") && 
	                        line.endsWith(" PRIVATE KEY-----")) {
	                    inKey = false;
	                    break;
	                }
	                builder.append(line);
	            }
	        }
	        //
	      /*  byte[] encoded = DatatypeConverter.parseBase64Binary(builder.toString());
	        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
	        KeyFactory kf = KeyFactory.getInstance("RSA");
	        key = kf.generatePrivate(keySpec);*/
	    } finally {
	        closeSilent(is);
	    }
	    return key;
	}

	public static void closeSilent(final InputStream is) {
	    if (is == null) return;
	    try { is.close(); } catch (Exception ign) {}
	}
	
}
