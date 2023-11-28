import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class network_get {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println("Response Code: "+status);
        System.out.println("GET Post: "+content);
        System.out.println();
    }
}
