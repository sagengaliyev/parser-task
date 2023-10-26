package kz.sagengaliyev.parser.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TableCreationRequest {
    @NotBlank(message = "Название не должно быть пустым!")
    private String name;
}
