package kz.sagengaliyev.parser.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateColumnRequest {
    private String name;
    private String type;
}
