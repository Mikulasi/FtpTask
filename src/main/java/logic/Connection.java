package logic;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

public class Connection {

    public static final String FTP_MOZILLA_ORG = "ftp.mozilla.org";
    public static final int PORT = 21;
    private static FTPClient ftpClient = new FTPClient();

    private Connection() {
    }

    private static class ConnectionManager {
        private final static Connection MANAGER_INSTANCE = new Connection();
    }
        public static Connection getInstance() {
            return ConnectionManager.MANAGER_INSTANCE;
        }

        public static FTPClient getConnection() throws IOException {

            String path = FTP_MOZILLA_ORG;
            int port = PORT;
            ftpClient.connect(path, port);
            ftpClient.login("anonymous", "anonymous");
            int code = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(code)) {
                System.out.println("Connection error!");
            }
            return ftpClient;
        }

        public static void releaseConnection() {
            ftpClient.isConnected();
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                System.out.println("Error while releasing connection!");
            }
        }
    }
