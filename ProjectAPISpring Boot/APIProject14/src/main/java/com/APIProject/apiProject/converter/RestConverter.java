package com.APIProject.apiProject.converter;

public interface RestConverter<Entity, Response, Request> {

    Response toResponse(Entity entity);

    Entity fromRequest(Request dto);
}
