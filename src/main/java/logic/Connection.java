package logic;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

public class Connection {

    public static final String FTP_MOZILLA_ORG = "ftp.mozilla.org";
    public static final int PORT = 21;


    private static final Connection INSTANCE = new Connection();
    private static FTPClient ftpClient = new FTPClient();
    private Connection() {
    }

    public static Connection getInstance(){
        if (INSTANCE == null){
            return new Connection();
        } return INSTANCE;
    }

    protected static FTPClient getConnection() throws IOException {


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
