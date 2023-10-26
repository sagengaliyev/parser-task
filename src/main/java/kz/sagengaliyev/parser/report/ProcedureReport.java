package kz.sagengaliyev.parser.report;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcedureReport {
    private String message;
    public ProcedureReport(String message) {
        this.message = message;
    }
}
