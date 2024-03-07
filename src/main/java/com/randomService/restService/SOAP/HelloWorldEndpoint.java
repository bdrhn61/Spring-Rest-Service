package com.randomService.restService.SOAP;


import com.randomService.restService.SOAP.HelloRequest;
import com.randomService.restService.SOAP.HelloResponse;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class HelloWorldEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/aaa";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "helloRequest")
    @ResponsePayload
    public HelloResponse sayHello(@RequestPayload HelloRequest request) {
        HelloResponse response = new HelloResponse();
        response.setMessage("Hello, " + request.getName() + "!");
        return response;
    }
}