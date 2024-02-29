import javax.net.ssl.HttpsURLConnection;
import java.net.URL;



public class SSLTest {
    public static void main(String[] args) {
        //System.setProperty("https.proxyHost", "proxy");
        //System.setProperty("https.proxyPort", "443");
        String proxyHost = System.getProperty("https.proxyHost");
        String proxyPort = System.getProperty("https.proxyPort");

        System.out.println("HTTPS Proxy Host: " + proxyHost);
        System.out.println("HTTPS Proxy Port: " + proxyPort);
        try {
            URL url = new URL("https://github.com/eazybytes/microservices.git");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            System.out.println("Response Code: " + connection.getResponseCode());
            System.out.println("Cipher Suite: " + connection.getCipherSuite());
            //System.out.println("Protocol: " + connection.getProtocol());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


