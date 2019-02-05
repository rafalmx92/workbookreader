package pl.rafal.mazurek.app.parser;

import org.springframework.web.multipart.MultipartFile;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;
import pl.rafal.mazurek.app.dto.WorkbookRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PRNParser implements FileParser {

    @Override
    public ParsedWorkbook parseWorkbookFile(MultipartFile file) {
        List<WorkbookRecord> records = new ArrayList<>();
        List<String> header = new ArrayList<>();

        try(InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"))) {

            header = listLineColumns(br.readLine());

            for(String line; (line = br.readLine()) != null; ) {
                records.add(parseLineToRecord(line));
            }
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        return new ParsedWorkbook(records, header);
    }

    private WorkbookRecord parseLineToRecord(String line) {
        List<String> columns = listLineColumns(line);
        return new WorkbookRecord(columns.get(0), columns.get(1), columns.get(2), columns.get(3), columns.get(4), columns.get(5));
    }

    private List<String> listLineColumns(String line){
        List<String> columns = new ArrayList<>();

        columns.add(line.substring(0, 16).trim());
        columns.add(line.substring(16, 38).trim());
        columns.add(line.substring(38, 47).trim());
        columns.add(line.substring(47, 61).trim());
        columns.add(line.substring(61, 74).trim());
        columns.add(line.substring(74, line.length()).trim());
        return columns;
    }

}
