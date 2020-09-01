package com.apigateway.apigateway;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GatewayController {

    @RequestMapping("/countryFallback")
    public @ResponseBody String countryFallback() {
        return "This is error message for country api. Try again later.";
    }

    @RequestMapping("/pokemonFallback")
    public @ResponseBody String pokemonFallback() {
        return "This is error message for pokemon go api. Try again later.";
    }

}
