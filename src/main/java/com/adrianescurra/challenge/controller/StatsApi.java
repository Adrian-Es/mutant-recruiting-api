/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.adrianescurra.challenge.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adrianescurra.challenge.model.Stats;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "api-mutant", description = "Everything about your Pets")
public interface StatsApi {

    /**
     * GET /stats : Get all humans in the database
     *
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getAllStats",
        summary = "Get all humans in the database",
        tags = { "api-mutant" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Stats.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/stats",
        produces = { "application/json" }
    )
    ResponseEntity<List<Stats>> getAllStats(
        
    );

}
