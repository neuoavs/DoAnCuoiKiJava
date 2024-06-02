package Controller;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyController {
	
	private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static Object readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            // Try parsing the response as a JSONObject
            try {
                return new JSONObject(jsonText);
            } catch (JSONException e) {
                return new JSONArray(jsonText);
            }
        } finally {
            is.close();
        }
    }
    
    public static void addImageToLabel(String link, JLabel label) throws IOException {
    	URL url = new URL(link);
    	Image image = ImageIO.read(url);
    	image = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
    	label.setIcon((Icon) new ImageIcon(image));
    }
    

}
