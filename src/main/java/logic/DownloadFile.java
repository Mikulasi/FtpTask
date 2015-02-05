package logic;

import exception.CanNotRetrieveFileException;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.util.Scanner;

public class DownloadFile {

    public static void downloadFile() throws IOException, CanNotRetrieveFileException {

        FTPClient ftpClient = Connection.getInstance().getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file you need to download: ");// /pub/OJI/MRJPlugin.sit.hqx
        String remoteFile = scanner.nextLine();
        System.out.println("Enter the path on the local computer and filename to save file: ");// d:/Яковлев/MRJPlugin.sit.hqx
        String downloadFile = scanner.nextLine();
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
        } catch (FileNotFoundException e) {
            System.out.println("Error! You should name your file");
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
                System.out.println("File " + downloadFile.substring(downloadFile.lastIndexOf("/") + 1, downloadFile.length()) + " has been downloaded successfully.");
            }
        }catch (IOException e){
            System.out.println("Can't close output stream");
        }
    }
}
