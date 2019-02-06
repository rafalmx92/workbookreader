package pl.rafal.mazurek.app.parser;

import org.springframework.web.multipart.MultipartFile;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;

public interface FileParser {

    String ISO_ENCODING = "ISO-8859-1";

    ParsedWorkbook parseWorkbookFile(MultipartFile file);
}
