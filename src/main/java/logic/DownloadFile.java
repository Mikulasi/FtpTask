package logic;

import exception.CanNotRetrieveFileException;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.util.Scanner;

public class DownloadFile {

    public static void downloadFile() throws IOException, CanNotRetrieveFileException {

        FTPClient ftpClient = Connection.getInstance().getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file you need to download: ");
        String remoteFile = scanner.nextLine();
        System.out.println("Enter the file name to upload: ");
        String downloadFile = scanner.nextLine();
//        String remoteFile = "/pub/OJI/MRJPlugin.sit.hqx";
//        File downloadFile = new File("d:/Яковлев/MRJPlugin.sit.hqx");
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found");
        }
        boolean success;
        try {
            success = ftpClient.retrieveFile(remoteFile, outputStream);
        } catch (IOException e) {
            throw new CanNotRetrieveFileException("Can't retrieve file!");
        }
        try {
            if (outputStream != null) {
                outputStream.close();
            }

            if (success) {
                System.out.println("File has been downloaded successfully.");
            }
        }catch (IOException e){
            System.out.println("Can't close output stream");
        }
    }
}
