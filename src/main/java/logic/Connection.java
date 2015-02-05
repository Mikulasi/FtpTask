package logic;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

public class Connection {

    private Connection() {
    }

    public static class ConnectionManager {

        public static final String FTP_MOZILLA_ORG = "ftp.mozilla.org";
        public static final int PORT = 21;
        private final static Connection MANAGER_INSTANCE = new Connection();
        public static Connection getInstance() {
            return ConnectionManager.MANAGER_INSTANCE;
        }

    }
        protected static FTPClient getConnection() throws IOException {


            String path = ConnectionManager.FTP_MOZILLA_ORG;
            int port = ConnectionManager.PORT;
            ftpClient.connect(path, port);
            ftpClient.login("anonymous", "anonymous");
            int code = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(code)) {
                System.out.println("Connection error!");
            }
            return ftpClient;
        }

    private static FTPClient ftpClient = new FTPClient();

        protected static void releaseConnection() {
            ftpClient.isConnected();
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                System.out.println("Error while releasing connection!");
            }
        }
    }
