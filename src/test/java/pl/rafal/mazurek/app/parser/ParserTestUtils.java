package pl.rafal.mazurek.app.parser;

import pl.rafal.mazurek.app.dto.ParsedWorkbook;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ParserTestUtils {

    protected final static String PRN_CONTENT = "Name            Address               Postcode Phone         Credit Limit Birthday\n" +
            "Johnson, John   Voorstraat 32         3122gg   020 3849381        1000000 19870101\n" +
            "Anderson, Paul  Dorpsplein 3A         4532 AA  030 3458986       10909300 19651203\n" +
            "Wicket, Steve   Mendelssohnstraat 54d 3423 ba  0313-398475          93400 19640603\n" +
            "Benetar, Pat    Driehoog 3zwart       2340 CC  06-28938945             54 19640904\n" +
            "Gibson, Mal     Vredenburg 21         3209 DD  06-48958986           5450 19781109\n" +
            "Friendly, User  Sint Jansstraat 32    4220 EE  0885-291029           6360 19800810\n" +
            "Smith, John     Břrkestraße 32        87823    +44 728 889838      989830 19990920\n";

    protected final static String PRN_CONTENT_CORRUPTED = "Name            Address               Postcode Phone         Credit Limit Birthday\n" +
            "Johnson, John   Voorstraat 32         3122gg   020 3849381        1000000 19870101\n" +
            "Anderson, Paul  Dorpsplein 3A         4532 AA  030 3458986       10909300 19651203\n" +
            "Wicket, Steve   Mendelssohnstraat 54d 3423 ba  0313-398475          93400 19640603\n" +
            "Benetar, Pat    Driehoog 3zwart       \n" +
            "Gibson, Mal     Vredenburg 21         3209 DD  06-48958986           5450 19781109\n" +
            "Friendly, User  Sint Jansstraat 32    4220 EE  0885-291029         \n" +
            "Smith, John     Břrkestraße 32        87823    +44 728 889838      989830 19990920\n";

    protected final static String CSV_CONTENT = "Name,Address,Postcode,Phone,Credit Limit,Birthday\n" +
            "Johnson, John,Voorstraat 32,3122gg,020 3849381,10000,01/01/1987\n" +
            "Anderson, Paul,Dorpsplein 3A,4532 AA,030 3458986,109093,03/12/1965\n" +
            "Wicket, Steve,Mendelssohnstraat 54d,3423 ba,0313-398475,934,03/06/1964\n" +
            "Benetar, Pat,Driehoog 3zwart,2340 CC,06-28938945,54,04/09/1964\n" +
            "Gibson, Mal,Vredenburg 21,3209 DD,06-48958986,54.5,09/11/1978\n" +
            "Friendly, User,Sint Jansstraat 32,4220 EE,0885-291029,63.6,10/08/1980\n" +
            "Smith, John,Břrkestraße 32,87823,+44 728 889838,9898.3,20/09/1999\n";

    protected final static String CSV_CONTENT_CORRUPTED = "Name,Address,Postcode,Phone,Credit Limit,Birthday\n" +
            "Johnson, John,Voorstraat 32,3122gg,020 3849381,10000,01/01/1987\n" +
            "Anderson, Paul,Dorpsplein 3A,4532 AA,030 3458986,109093,03/12/1965\n" +
            "Wicket, Steve,Mendelssohnstraat 54d,3423 ba,0313-398475,934,03/06/1964\n" +
            "Benetar, Pat,Driehoog 3zwart,\n" +
            "Gibson, Mal,Vredenburg 21,3209 DD,06-48958986,54.5,09/11/1978\n" +
            "Friendly, User,Sint Jansstraat 32,4220 EE,0885-291029,63.6,10/08/1980\n" +
            "Smith, John,Břrkestraße 32,87823,+44 728 889838,9898.3,20/09/1999\n";

    protected static void assertThatHeadersParsedCorrectly(ParsedWorkbook parsedWorkbook) {
        assertThat(parsedWorkbook.getHeaders().get(0), is(equalTo("Name")));
        assertThat(parsedWorkbook.getHeaders().get(1), is(equalTo("Address")));
        assertThat(parsedWorkbook.getHeaders().get(2), is(equalTo("Postcode")));
        assertThat(parsedWorkbook.getHeaders().get(3), is(equalTo("Phone")));
        assertThat(parsedWorkbook.getHeaders().get(4), is(equalTo("Credit Limit")));
        assertThat(parsedWorkbook.getHeaders().get(5), is(equalTo("Birthday")));
    }
}
