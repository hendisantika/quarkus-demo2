package com.hendisantika.customer;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.slf4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-demo2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/22
 * Time: 20.22
 */
@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private final CustomerService customerService;
    private final Logger logger;

    public CustomerResource(CustomerService customerService, Logger logger) {
        this.customerService = customerService;
        this.logger = logger;
    }

    @GET
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Get All Customers",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = SchemaType.ARRAY, implementation = Customer.class)))
            }
    )
    public Response get() {
        return Response.ok(customerService.findAll()).build();
    }

    @GET
    @Path("/{customerId}")
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Get Customer by customerId",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = SchemaType.OBJECT, implementation = Customer.class))),
                    @APIResponse(
                            responseCode = "404",
                            description = "No Customer found for customerId provided",
                            content = @Content(mediaType = "application/json")),
            }
    )
    public Response getById(@PathParam("customerId") Integer customerId) {
        Optional<Customer> optional = customerService.findById(customerId);
        return !optional.isEmpty() ? Response.ok(optional.get()).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

}
