package com.jbground.community.web.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonController {

    @RequestMapping(value = "/alertRedirect")
    public String alertRedirect(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        return "";
    }
}
