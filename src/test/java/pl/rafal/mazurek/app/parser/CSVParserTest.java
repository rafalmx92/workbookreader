package pl.rafal.mazurek.app.parser;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import pl.rafal.mazurek.app.dto.ParsedWorkbook;
import pl.rafal.mazurek.app.exception.ParsingException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

/*
 * Sample tests
 */
@RunWith(MockitoJUnitRunner.class)
public class CSVParserTest {

    private CSVParser csvParser = new CSVParser();

    private static final MultipartFile MULTIPART_FILE = new MockMultipartFile("data", "filename.csv", "text/plain", ParserTestUtils.CSV_CONTENT.getBytes());
    private static final MultipartFile MULTIPART_FILE_CORRUPTED = new MockMultipartFile("data", "filename.csv", "text/plain", ParserTestUtils.CSV_CONTENT_CORRUPTED.getBytes());

    @Test(expected = ParsingException.class)
    public void shouldThrowParsingExceptionDueToCorruptedContent(){
        //when
        csvParser.parseWorkbookFile(MULTIPART_FILE_CORRUPTED);

        //then
        fail();
    }

    @Test
    public void shouldGetAppropriateHeaders(){
        //when
        ParsedWorkbook parsedWorkbook = csvParser.parseWorkbookFile(MULTIPART_FILE);

        //then
        ParserTestUtils.assertThatHeadersParsedCorrectly(parsedWorkbook);
    }

    @Test
    public void shouldGetSevenRecordsFromFile(){
        //when
        ParsedWorkbook parsedWorkbook = csvParser.parseWorkbookFile(MULTIPART_FILE);

        //then
        assertThat(parsedWorkbook.getWorkbookRecords().size(), is(equalTo(7)));
    }
}
