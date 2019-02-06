package pl.rafal.mazurek.app.parser;

import com.opencsv.CSVReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;
import pl.rafal.mazurek.app.dto.WorkbookRecord;
import pl.rafal.mazurek.app.exception.ParsingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser implements FileParser {

    private static final Logger LOGGER = LogManager.getLogger(CSVParser.class);

    @Override
    public ParsedWorkbook parseWorkbookFile(MultipartFile file) {
        LOGGER.info("Parsing .csv file: {}", file.getOriginalFilename());

        List<WorkbookRecord> records = new ArrayList<>();
        List<String> headers;

        try(InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, ISO_ENCODING));
            CSVReader csvReader = new CSVReader(br)) {
            String line[];

            headers = Arrays.asList(csvReader.readNext());

            while ((line = csvReader.readNext()) != null) {
                records.add(new WorkbookRecord(line[0],line[1],line[2],line[3],line[4],line[5]));
            }
        } catch (IOException | RuntimeException e) {
            LOGGER.error("Error during parsing .csv file: {}", e.getMessage());
            throw new ParsingException(e.getMessage(), e);
        }
        return new ParsedWorkbook(records, headers);
    }
}
