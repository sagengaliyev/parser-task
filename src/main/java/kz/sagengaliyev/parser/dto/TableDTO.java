package kz.sagengaliyev.parser.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableDTO {
    private Long id;
    private String name;
    private List<ColumnDTO> columns;
}
