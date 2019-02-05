package pl.rafal.mazurek.app.parser;

import pl.rafal.mazurek.app.dto.ParsedWorkbook;

import java.io.File;

public interface FileParser {

    ParsedWorkbook parseWorkbookFile(File file);
}
