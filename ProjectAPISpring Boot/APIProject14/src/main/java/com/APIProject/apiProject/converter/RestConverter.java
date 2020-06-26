package com.APIProject.apiProject.converter;

import com.APIProject.apiProject.Model.ResultWarfare;
import com.APIProject.apiProject.dto.WarfareDTO;

public interface RestConverter<Entity, Response, Request, RequestUnit> {

    Response toResponse(Entity entity);

    WarfareDTO.ResponseWarfare toResponseWarfare(Entity entity, ResultWarfare newWarfare);

    Entity fromRequest(Request dto);

    Entity fromRequestUnits(RequestUnit dto, String warfare);
}
