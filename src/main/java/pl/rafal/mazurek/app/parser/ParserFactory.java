package pl.rafal.mazurek.app.parser;

public class ParserFactory {

    public static FileParser getParser(String fileName){
        if(fileName.endsWith(".csv")){
            return new CSVParser();
        }
        if(fileName.endsWith(".prn")){
            return new PRNParser();
        }
        throw new IllegalStateException("File format not supported! Given File: " + fileName);
    }
}
