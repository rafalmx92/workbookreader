package pl.rafal.mazurek.app.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;
import pl.rafal.mazurek.app.dto.WorkbookRecord;
import pl.rafal.mazurek.app.exception.ParsingException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PRNParser implements FileParser {

    private static final Logger LOGGER = LogManager.getLogger(PRNParser.class);

    @Override
    public ParsedWorkbook parseWorkbookFile(MultipartFile file) {
        LOGGER.info("Parsing .prn file: {}", file.getOriginalFilename());

        List<WorkbookRecord> records = new ArrayList<>();
        List<String> headers;

        try(InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, ISO_ENCODING))) {

            headers = listLineColumns(br.readLine());

            for(String line; (line = br.readLine()) != null; ) {
                records.add(parseLineToRecord(line));
            }
        } catch (IOException | RuntimeException e) {
            LOGGER.error("Error during parsing .prn file: {}", e.getMessage());
            throw new ParsingException(e.getMessage(), e);
        }
        return new ParsedWorkbook(records, headers);
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
