package logic;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CreateCatalog {

    public static void catalogList(FTPClient ftpClient){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter file path: ");
            String input = sc.nextLine();
            FTPFile[] ftpFiles = new FTPFile[0];
            try {
                ftpFiles = ftpClient.listFiles(input);
            } catch (IOException e) {
                System.out.println("Can't print list files!");
            }
            printFileDateTimeSize(ftpFiles);

            String[] strings = new String[0];
            try {
                strings = ftpClient.listNames();
            } catch (IOException e) {
                System.out.println("Can't print list names!");
            }
            printFiles(strings);
        }

    private static void printFileDateTimeSize(FTPFile[] files) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for (FTPFile file : files) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }
            details += "\t\t" + file.getSize();
            details += "\t\t" + dateFormat.format(file.getTimestamp().getTime());

            System.out.println(details);
        }
    }

    private static void printFiles(String files[]) {
        if (files != null && files.length > 0) {
            for (String file: files) {
                System.out.println(file);
            }

        //recursive way to list folders
//       public static void catalogList(FTPClient ftpClient,String parentDir, String currentDir, int level) throws IOException {
//        String dirList = parentDir;
//        if (!currentDir.equals("")){
//            dirList+= "/" + currentDir;
//        }
//
//        FTPFile[] ftpFiles = ftpClient.listFiles(dirList);
//        if (ftpFiles != null && ftpFiles.length > 0){
//            for (FTPFile file:ftpFiles){
//                String currentFileName = file.getName();
//                if (currentFileName.equals(".")|| currentFileName.equals("..")){
//                    continue;
//                }
//                for (int i = 0; i < level; i++){
//                    System.out.println("\t");
//                }
//                if (file.isDirectory()){
//                    System.out.println("[" + currentFileName + "]");
//                    catalogList(ftpClient,dirList,currentFileName,level++);
//                }else {
//                    System.out.println(currentFileName);
//                }
//            }
        }

    }
}
