package pl.juglodz.szkolenie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.juglodz.szkolenie.parser.ParseException;

public class WebPageParserImpl implements WebPageParser {

    URL url;
    private InputStream is;
    private BufferedReader br;
    private Pattern emailPattern;
    
    public WebPageParserImpl(String urlString) throws MalformedURLException {
        url = new URL(urlString);
        emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+.)+[a-zA-Z].");
    }

    @Override
    public List<String> parse() throws ParseException {
        try {
            is = url.openStream();
        } catch (IOException e) {
            throw new ParseException("Nie można polaczyć się ze stroną " + url); 
        }  
        br = new BufferedReader(new InputStreamReader(is));

        String line;
        List<String> links = new  ArrayList<String>();
        try {
            while ((line = br.readLine()) != null) {
                Matcher matcher = emailPattern.matcher(line);
                while (matcher.find()) {
                    links.add(matcher.group(0));
                }
            }
        } catch (IOException e) {
            throw new ParseException("Strina zla");
        }
        System.out.println(links);
        return links;
    }
    
    

}
