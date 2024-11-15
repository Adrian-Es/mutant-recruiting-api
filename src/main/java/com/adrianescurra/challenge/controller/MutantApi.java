/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.adrianescurra.challenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adrianescurra.challenge.model.DNA;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "api-mutant", description = "Everything about your Pets")
public interface MutantApi {

    /**
     * POST /mutant : Verify if the human is a mutant
     *
     * @param DNA Send a DNA from a human (required)
     * @return DNA is from a Mutant (status code 200)
     *         or DNA is from a No Mutant (status code 403)
     *         or DNA is invalid (status code 400)
     */
    @Operation(
        operationId = "verifyMutant",
        summary = "Verify if the human is a mutant",
        tags = { "api-mutant" },
        responses = {
            @ApiResponse(responseCode = "200", description = "DNA is from a Mutant"),
            @ApiResponse(responseCode = "403", description = "DNA is from a No Mutant"),
            @ApiResponse(responseCode = "400", description = "DNA is invalid")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/mutant",
        consumes = { "application/json" }
    )
    ResponseEntity<Void> verifyMutant(
        @Parameter(name = "DNA", description = "Send a DNA from a human", required = true) @RequestBody DNA DNA
    );

}
	