package pl.juglodz.szkolenie;

import java.util.List;

import pl.juglodz.szkolenie.parser.ParseException;

public interface WebPageParser {

    
    public List<String> parse() throws ParseException;
    
}

