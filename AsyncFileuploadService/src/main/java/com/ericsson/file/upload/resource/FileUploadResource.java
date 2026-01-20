package com.ericsson.file.upload.resource;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.ericsson.file.upload.FileUploadJob;
import com.ericsson.file.upload.UploadStatus;

/**
 * @author evarapp
 * 
 * 
 * @FormParam 
 *  The FormParam annotation in conjunction with the media type "application/x-www-form-urlencoded" is
 *  inefficient for sending and consuming large quantities of binary data or text containing non-ASCII characters. 
 *  
 *  or We can use, MultiValuedMap<K, V> to retrieve all form params. This can not be used for multipart requests because there will be a file type
 *  
 *  @FormDataParam 
 *  This annotation in conjunction with the media type "multipart/form-data" should be used for submitting and consuming forms that contain files,
 *  non-ASCII data, and binary data.
 *
 */
@Path("/service")
public class FileUploadResource {
	private static final String FOLDER_PATH = "/home/appu/filebackups/";

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadFile(@FormDataParam("file") InputStream fis,
			@FormDataParam("file") FormDataContentDisposition fileMetaData) {
		String fileName = fileMetaData.getFileName();
		System.out.println("File Name: " + fileMetaData.getFileName());
		String filePath = FOLDER_PATH + fileName;

		FileUploadJob job= new FileUploadJob(filePath, fis);
		Thread t= new Thread(job) ;
		t.start();
		System.out.println("Main thread started  background thread");
		return "File Upload request is sent successfully !!";
	}




	@GET
	@Path("/upload/status")
	@Produces(MediaType.TEXT_PLAIN)
	public int uploadStatus(@QueryParam("fileName") String fileName) {

		System.out.println("******"+UploadStatus.statusMap.size()+":  "+UploadStatus.statusMap+"   : "+UploadStatus.statusMap.get(FOLDER_PATH+fileName));
		return UploadStatus.getMap().get(FOLDER_PATH+fileName.trim());

	}
}

