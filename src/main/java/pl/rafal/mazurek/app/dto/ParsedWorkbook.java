package pl.rafal.mazurek.app.dto;

import java.util.List;
import java.util.Objects;

public class ParsedWorkbook {

    private List<WorkbookRecord> workbookRecords;
    private List<String> header;

    public List<WorkbookRecord> getWorkbookRecords() {
        return workbookRecords;
    }

    public void setWorkbookRecords(List<WorkbookRecord> workbookRecords) {
        this.workbookRecords = workbookRecords;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedWorkbook that = (ParsedWorkbook) o;
        return Objects.equals(workbookRecords, that.workbookRecords) &&
                Objects.equals(header, that.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workbookRecords, header);
    }

    @Override
    public String toString() {
        return "ParsedWorkbook{" +
                "workbookRecords=" + workbookRecords +
                ", header=" + header +
                '}';
    }
}
