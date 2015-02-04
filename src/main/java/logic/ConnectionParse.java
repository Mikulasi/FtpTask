package logic;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class ConnectionParse {

    public static void connectionParse() throws IOException {
        FTPClient ftpClient = Connection.getInstance().getConnection();
        try {
            CreateCatalog.catalogList(ftpClient);
        } finally {
            Connection.releaseConnection(ftpClient);
        }
    }
}
