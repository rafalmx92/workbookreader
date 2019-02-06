package pl.rafal.mazurek.app.dto;

import java.util.List;
import java.util.Objects;

public class ParsedWorkbook {

    private List<WorkbookRecord> workbookRecords;
    private List<String> headers;

    public ParsedWorkbook(List<WorkbookRecord> workbookRecords, List<String> headers) {
        this.workbookRecords = workbookRecords;
        this.headers = headers;
    }

    public List<WorkbookRecord> getWorkbookRecords() {
        return workbookRecords;
    }

    public void setWorkbookRecords(List<WorkbookRecord> workbookRecords) {
        this.workbookRecords = workbookRecords;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedWorkbook that = (ParsedWorkbook) o;
        return Objects.equals(workbookRecords, that.workbookRecords) &&
                Objects.equals(headers, that.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workbookRecords, headers);
    }

    @Override
    public String toString() {
        return "ParsedWorkbook{" +
                "workbookRecords=" + workbookRecords +
                ", headers=" + headers +
                '}';
    }
}
