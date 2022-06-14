package com.whiteboard.whiteboard.config.random.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonTransducer {
    public String message;
    public String status_code;
    public String photo_id;
}
