package com.APIProject.apiProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
    private Class type;
    private String id;

    public <ID> RecordNotFoundException(Class type, ID id) {
        super("Record not found " +
                type.getSimpleName() +
                " with key: " +
                id);
        this.type = type;
        this.id = id.toString();
    }

    public Class getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
