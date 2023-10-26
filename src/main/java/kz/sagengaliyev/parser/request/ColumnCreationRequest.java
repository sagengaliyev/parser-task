package kz.sagengaliyev.parser.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnCreationRequest {
    @NotBlank(message = "Название не должно быть пустым!")
    private String name;
    @NotBlank(message = "Тип не должен быть пустым!")
    private String type;
}
