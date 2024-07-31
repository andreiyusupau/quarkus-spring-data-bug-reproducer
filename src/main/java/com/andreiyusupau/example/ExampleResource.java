package com.andreiyusupau.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/")
public class ExampleResource {

    private final ExampleRepository exampleRepository;
    private final ExampleRepository2 exampleRepository2;

    ExampleResource(ExampleRepository exampleRepository, ExampleRepository2 exampleRepository2) {
        this.exampleRepository = exampleRepository;
        this.exampleRepository2 = exampleRepository2;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/error")
    public String error() {
        var exampleOptional = exampleRepository.findFirstByOrderByCreatedAtDesc();
        return "Example is " + (exampleOptional.isPresent() ? "present" : "absent");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ok")
    public String ok() {
       var exampleOptional = Optional.ofNullable(exampleRepository2.findFirstByOrderByCreatedAtDesc());
        return "Example is " + (exampleOptional.isPresent() ? "present" : "absent");
    }

}
