package de.jikugmbh.kanbanboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String getIndex() {

        return "index";
    }

    @RequestMapping("/product")
    public String getProduct() {

        return "product";
    }
}
