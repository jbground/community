package com.jbground.community.web.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAccountController {

    @PostMapping(name = "/checkId.do")
    public String validateId(){


        return "";
    }
}
