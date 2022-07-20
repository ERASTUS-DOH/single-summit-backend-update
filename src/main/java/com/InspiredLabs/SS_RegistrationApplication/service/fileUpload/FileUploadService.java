package com.InspiredLabs.SS_RegistrationApplication.service.fileUpload;


import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.logging.Logger;

import static com.InspiredLabs.SS_RegistrationApplication.utils.Constant.BUCKET_NAME;
import static com.InspiredLabs.SS_RegistrationApplication.utils.Constant.IMAGE_PATH;

@Service
public class FileUploadService {
    private final Logger LOGGER = Logger.getLogger(FileUploadService.class.getName());
    private final TransferManager transferManager;



    public FileUploadService( TransferManager transferManager){
        this.transferManager = transferManager;
    }

    public void upload(String fileName) {
        File file = new File(IMAGE_PATH + fileName);



        try {
            Upload upload = transferManager.upload(BUCKET_NAME, fileName, file);
            upload.waitForCompletion();
            LOGGER.info("File upload very successful......");
        } catch (AmazonClientException e) {
            LOGGER.info("File upload unsuccessful.......");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
