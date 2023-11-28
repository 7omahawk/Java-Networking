import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class network_post {
    public static void main(String[] args) throws MalformedURLException,

        IOException {

        URL myUrl = new URL("https://jsonplaceholder.typicode.com/posts/");
        HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();

        conn.setRequestMethod("POST");

        conn.setDoOutput(true);

        OutputStream out = conn.getOutputStream();

        String postedString = "Hi!!! We have posted something!!! Yay!!!";

        out.write(postedString.getBytes());

        int responseCode = conn.getResponseCode();
        System.out.print("Value of http created is: " + conn.HTTP_CREATED + "\n");
        if (responseCode == conn.HTTP_CREATED) {
            System.out.print("This is the response Code: " + responseCode + "\n");
            System.out.print("This is the response Message from server: " + conn.

                    getResponseMessage() + "\n");

        } else
            System.out.print("GO HOME EVERYBODY :( ");

        InputStreamReader in = new InputStreamReader(conn.getInputStream());

        BufferedReader buffer = new BufferedReader(in);

        StringBuffer fromServer = new StringBuffer();

        String eachLine = null;

        while ((eachLine = buffer.readLine()) != null) {
            fromServer.append(eachLine);
            fromServer.append(System.lineSeparator());
        }

        buffer.close();

        System.out.print("Here is our posted content :\n" + fromServer);
        System.out.println();
    }
}
