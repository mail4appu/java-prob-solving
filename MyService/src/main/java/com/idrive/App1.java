package com.idrive;

import net.sf.jmimemagic.*;
import org.apache.poi.util.IOUtils;
import org.apache.tika.Tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) {
        try {
            //Tika tika = new Tika();
            //File f= new File("C:\\Users\\SESA439295\\Activities\\Docgen\\123.xlsx");
            FileInputStream fi = new FileInputStream("C:\\Users\\SESA439295\\Activities\\Docgen\\123.zip");
            MagicMatch magicMatch = Magic.getMagicMatch(IOUtils.toByteArray(fi));
            //String detect = tika.detect(fi);
            //System.out.println("Tika detection: "+detect);
            //MagicMatch magicMatch =Magic.getMagicMatch(f, true);
            System.out.println("Mime type of template doc ####:   " + magicMatch.getMimeType());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MagicException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MagicParseException e) {
            e.printStackTrace();
        } catch (MagicMatchNotFoundException e) {
            e.printStackTrace();
        }

    }
}
