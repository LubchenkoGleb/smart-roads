package com.kpi.diploma.smartroads.rest.primary;

import com.fasterxml.jackson.databind.JsonNode;
import com.kpi.diploma.smartroads.model.dto.MapObjectDto;
import com.kpi.diploma.smartroads.model.util.security.MongoUserDetails;
import com.kpi.diploma.smartroads.model.util.title.Fields;
import com.kpi.diploma.smartroads.service.primary.MapObjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "map-object-requests")
public class MapObjectController {

    private final MapObjectService mapObjectService;

    @Autowired
    public MapObjectController(MapObjectService mapObjectService) {
        this.mapObjectService = mapObjectService;
    }

    @PostMapping(value = "/create")
    private ResponseEntity<MapObjectDto> create(@AuthenticationPrincipal MongoUserDetails principal,
                                                @RequestBody MapObjectDto mapObjectDto) {
        log.info("'create' invoked with params'{}, {}'", principal.getUserId(), mapObjectDto);

        MapObjectDto response = mapObjectService.createMapObject(principal.getUserId(), mapObjectDto);
        log.info("'response={}'", response);

        return ResponseEntity.ok(response);
    }

    /**
     * @param principal
     * @param jsonNode  {"company_id":string, "map_object_id":string}
     */
    @PutMapping(value = "/set-company")
    private ResponseEntity<MapObjectDto> setCompany(@AuthenticationPrincipal MongoUserDetails principal,
                                                    @RequestBody JsonNode jsonNode) {
        log.info("'setCompany' invoked with params'{}, {}'", principal.getUserId(), jsonNode);

        String companyId = jsonNode.get(Fields.COMPANY_ID).asText();
        String mapObjectId = jsonNode.get(Fields.MAP_OBJECT_ID).asText();

        MapObjectDto mapObjectDto = mapObjectService.setCompany(companyId, mapObjectId);
        log.info("'mapObjectDto={}'", mapObjectDto);

        return ResponseEntity.ok(mapObjectDto);
    }

    /**
     * @param principal
     * @param jsonNode  {"map_object_id":string}
     */
    @DeleteMapping(value = "/unset-company")
    private ResponseEntity<MapObjectDto> unsetCompany(@AuthenticationPrincipal MongoUserDetails principal,
                                                      @RequestBody JsonNode jsonNode) {
        log.info("'unsetCompany' invoked with params'{}, {}'", principal.getUserId(), jsonNode);

        String mapObjectId = jsonNode.get(Fields.MAP_OBJECT_ID).asText();

        MapObjectDto mapObjectDto = mapObjectService.unsetCompany(mapObjectId);
        log.info("'mapObjectDto={}'", mapObjectDto);

        return ResponseEntity.ok(mapObjectDto);
    }
}
