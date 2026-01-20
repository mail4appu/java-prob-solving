package com.idrive.server.resources;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.glassfish.jersey.filter.LoggingFilter;

/**
 * Created by SESA439295 on 7/31/2018.
 */
@Path("/")
public class DocumentService {


    @POST
    @Path("/document")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.MULTIPART_FORM_DATA})
    public Response generateDocument(MultiPart multiPart,
                                     @QueryParam("fileType") String fileType) throws Exception {

        InputStream jsonInputStream = null;
        InputStream docInputStream = null;
        ZipInputStream zipInputStream = null;

        //Read the input file
        for (BodyPart bodyPart : multiPart.getBodyParts()) {


            String fileName = bodyPart.getContentDisposition().getFileName();
            System.out.println("Each file name: " + fileName);
            if (fileName.contains(".json")) {

                jsonInputStream = bodyPart.getEntityAs(InputStream.class);
                long start=System.currentTimeMillis();
                MagicMatch magicMatch = Magic.getMagicMatch(IOUtils.toByteArray(jsonInputStream));
                System.out.println("Time taken by java mime type: json file  "+(System.currentTimeMillis()-start));
                System.out.println("Mime type of json"+magicMatch.getMimeType());
            } else if (fileName.contains(".zip")) {
                zipInputStream = new ZipInputStream(bodyPart.getEntityAs(InputStream.class));
               // MagicMatch magicMatch = Magic.getMagicMatch(IOUtils.toByteArray(zipInputStream));
               // System.out.println("Mime type of zip"+magicMatch.getMimeType());

            } else {
                docInputStream = bodyPart.getEntityAs(InputStream.class);
                long start=System.currentTimeMillis();
                MagicMatch magicMatch = Magic.getMagicMatch(IOUtils.toByteArray(docInputStream));
                System.out.println("Time taken by java mime type doc file : "+(System.currentTimeMillis()-start));
                System.out.println("Mime type of template doc"+magicMatch.getMimeType());
            }

            System.out.println("in for loop");

        }
        docInputStream= new FileInputStream("enriched_sld_template_20.docx");
        System.out.println("generating word doc");
        generateWordDocument(jsonInputStream, docInputStream, zipInputStream);
        File file = new File("Test.docx");

        if (fileType.equals("pdf")) {
            generatePdfDocument("Test.docx");
            file = new File("Test.pdf");
        }

        //Download file
        if (file.exists()) {
            System.out.println("#####################:  " + file.getName());
            Response.ResponseBuilder builder = Response.ok(file);
            builder.header("Content-Disposition", "attachment; filename=" + file.getName());
            return builder.build();


        }
        return null;
    }

    private void generatePdfDocument(String fileName) {
        convertWordToPdf(fileName);
    }

    private void generateWordDocument(InputStream jsonInputStream, InputStream docInputStream, ZipInputStream zipInputStream) {
        try {
            XWPFDocument docuemntOriginal = new XWPFDocument(OPCPackage.open(docInputStream));
            System.out.println("document Original"+docuemntOriginal.getBodyElements());

            //Read the zip file entries

            List<XWPFParagraph> paragraphs = docuemntOriginal.getParagraphs();
            for (XWPFParagraph paragraph : paragraphs) {
                List<XWPFRun> runs = paragraph.getRuns();

                for (XWPFRun run : runs) {
                    String text=run.getText(0);
                    System.out.println("text from run :   "+run);
                    if (org.apache.commons.lang3.StringUtils.isNotBlank(text)&& text.indexOf("<<img_sld>>")!=-1) {
                        System.out.println("found replaceable text");
                        String placeHolderKey=text.substring(text.indexOf("<<")+2, text.indexOf(">>"));
                        String placeValue=fetchPlaceHoldersValue(jsonInputStream, placeHolderKey ).trim();
                        String []temp=placeValue.split("\\.");
                        String fileType=temp[1];
                        System.out.println("inside replacing word docuemnt content");
                        ZipEntry zipEntry=null;
                        while((zipEntry=getZipEntry(zipInputStream))!=null) {
                            String fileName=zipEntry.getName().trim();
                            if(fileName.equals(placeValue)) {
                                text=text.replace(text,"");
                                run.setText(text,0);
                                run.addPicture(zipInputStream, Document.PICTURE_TYPE_PNG, placeValue, Units.toEMU(400), Units.toEMU(400));
                                break;
                            }
                            else{
                                run.addPicture(zipInputStream, Document.PICTURE_TYPE_JPEG, "mytest.jpg", Units.toEMU(400), Units.toEMU(400));
                            }
                        }
                    }
                }

            }

            FileOutputStream out = new FileOutputStream(new File("Test.docx"));
            docuemntOriginal.write(out);
            docuemntOriginal.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    private String  fetchPlaceHoldersValue(InputStream jsonInputStream, String placeHolderKey) {
        try {
            BufferedReader bR = new BufferedReader(new InputStreamReader(jsonInputStream));
            String line = "";

            StringBuilder responseStrBuilder = new StringBuilder();
            while ((line = bR.readLine()) != null) {

                responseStrBuilder.append(line);
            }
            jsonInputStream.close();

            JSONObject result = new JSONObject(responseStrBuilder.toString());
            System.out.println("json string is: "+result);
            return result.getString(placeHolderKey);
        }catch(Exception ex){
            ex.printStackTrace();

        }
        return null;
    }

    private void convertWordToPdf(String s) {

        InputStream doc = null;
        try {
            doc = new FileInputStream(new File(s));
            XWPFDocument document = new XWPFDocument(doc);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File("Test.pdf"));
            PdfConverter.getInstance().convert(document, out, options);
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ZipEntry getZipEntry(ZipInputStream zipInputStream) {
        try {
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry != null) {
                System.out.println("******************:   "+entry.getName());
                if (entry.isDirectory()) {
                    entry = zipInputStream.getNextEntry();
                    return entry;
                }else{
                    return entry;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
