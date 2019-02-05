package pl.rafal.mazurek.app.parser;

import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;
import pl.rafal.mazurek.app.dto.WorkbookRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParser implements FileParser {

    @Override
    public ParsedWorkbook parseWorkbookFile(MultipartFile file) {
        List<WorkbookRecord> records = new ArrayList<>();
        List<String> header = new ArrayList<>();

        BufferedReader br;
        CSVReader csvReader = null;
        try {
            String line[];
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));

            csvReader = new CSVReader(br);

            header = Arrays.asList(csvReader.readNext());
            while ((line = csvReader.readNext()) != null) {
                records.add(new WorkbookRecord(line[0],line[1],line[2],line[3],line[4],line[5]));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new ParsedWorkbook(records, header);
    }
}
