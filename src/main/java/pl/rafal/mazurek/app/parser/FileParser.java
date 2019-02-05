package pl.rafal.mazurek.app.parser;

import org.springframework.web.multipart.MultipartFile;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;

public interface FileParser {

    ParsedWorkbook parseWorkbookFile(MultipartFile file);
}
