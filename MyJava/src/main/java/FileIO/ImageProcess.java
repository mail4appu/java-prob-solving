package FileIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageProcess {
	public static void main(String[] args) {

		File file = new File("/home/apparao/Downloads/Vara Lakshmi (1).jpg");
	    BufferedImage img;
	    byte b=45;
	    System.out.println(b*78);
	    
		try {
			img = ImageIO.read(file );
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(img , "jpg", baos);
			byte[] previewByte = baos.toByteArray();
			System.out.println(Arrays.toString(previewByte));
			String str = new String(previewByte);
			System.out.println(""+(int)'c');
            System.out.println(Short.parseShort("01100110", 2));
            System.out.println(Integer.toBinaryString(1));
            String s = "admin";
            byte[] bytes = s.getBytes("US-ASCII");
            System.out.println(Arrays.toString(bytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}



}
