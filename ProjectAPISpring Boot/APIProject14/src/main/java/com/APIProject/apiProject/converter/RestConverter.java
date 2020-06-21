package com.APIProject.apiProject.converter;

public interface RestConverter<Entity, Response, Request, RequestUnit> {

    Response toResponse(Entity entity);

    Entity fromRequest(Request dto);

    Entity fromRequestUnits(RequestUnit dto, String warfare);
}
