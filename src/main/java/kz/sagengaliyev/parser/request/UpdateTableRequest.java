package kz.sagengaliyev.parser.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateTableRequest {
    @NotBlank
    private String name;
}
