package pl.rafal.mazurek.app.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.rafal.mazurek.app.exception.FileFormatNotSupportedException;

public class ParserFactory {

    private static final Logger LOGGER = LogManager.getLogger(ParserFactory.class);

    public static FileParser getParser(String fileName){
        if(fileName.endsWith(".csv")){
            return new CSVParser();
        }
        if(fileName.endsWith(".prn")){
            return new PRNParser();
        }
        String errorMessage = "File format not supported! Given File: " + fileName;
        LOGGER.error(errorMessage);
        throw new FileFormatNotSupportedException(errorMessage);
    }
}
