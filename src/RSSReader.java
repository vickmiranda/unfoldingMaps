import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vicentem on 12/14/16.
 */
public class RSSReader {
    public static void main(String[] args){
        System.out.println(readRSS("http://earthquake.usgs.gov//earthquakes//feed//v1.0//summary//2.5_week.atom"));
    }

    public static String readRSS(String urlAddress) {
        try {

            URL rssUrl = new URL(urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("<title>")) {
                    int firstpos = line.indexOf("<title>");
                    String temp = line.substring(firstpos);
                    temp = temp.replace("<title>", "");
                    int lastpos = temp.indexOf("</title>");
                    temp = temp.substring(0, lastpos);
                    sourceCode += temp + "\n";
                }
            }
            in.close();
            return sourceCode;
        } catch (MalformedURLException ue) {
            System.out.println("MalformedURL Exception\n");
        } catch (IOException ioe) {
            System.out.println("IO Exception\n");
        }
        return null;
    }
}
