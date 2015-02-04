package main;

import exception.CanNotRetrieveFileException;
import logic.DownloadFile;

import java.io.IOException;

public class Main {

        public static void main(String[] args) throws IOException, CanNotRetrieveFileException {

//            ConnectionParse.connectionParse();
            DownloadFile.downloadFile();
        }

    }
