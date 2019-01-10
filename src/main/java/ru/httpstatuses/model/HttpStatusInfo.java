package ru.httpstatuses.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class HttpStatusInfo {

    private Integer code;
    private String description;

}
