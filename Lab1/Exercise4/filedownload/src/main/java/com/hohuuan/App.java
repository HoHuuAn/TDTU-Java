package com.hohuuan;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.validator.routines.UrlValidator;



public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please specify a URL to a file");
            return;
        }

        String url = args[0];
        UrlValidator validator = new UrlValidator();
        if (!validator.isValid(url)) {
            System.out.println("This is not a valid URL");
            return;
        }

        try {
            downloadFile(url);
            System.out.println("Download success !");
        } catch (IOException e) {
            System.out.println("Download fail !");
            e.printStackTrace();
        }
    }

    public static void downloadFile(String url) throws IOException {
        URL fileUrl = new URL(url);
        String fileName = FilenameUtils.getName(fileUrl.getPath());
        File workDir = new File(System.getProperty("user.dir"));
        File destinationFile = new File(workDir, fileName);
        System.out.println("Starting download...");
        FileUtils.copyURLToFile(fileUrl, destinationFile);
    }
}
// test: java -jar Program.jar https://www.unikey.org/assets/release/unikey43RC5-200929-win64.zip