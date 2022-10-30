package com.example.crud.BasicCrud.Helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

   public final String UPLOAD_DIR="D:\\OneDrive\\OneDrive - intellier.com\\Documents\\SpringBoot_basic\\BasicCrud\\src\\main\\resources\\static\\image";
   public boolean uploadFile(MultipartFile multipartFile){
       boolean f=false;
       try{
            //one way to read and write file
//           InputStream is=multipartFile.getInputStream();
//           byte[]data=new byte[is.available()];
//           is.read(data);
//
//           //write
//
//           FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
//           fos.write(data);
//           fos.flush();
//           fos.close();

           Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
           f=true;
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return f;
   }
}
