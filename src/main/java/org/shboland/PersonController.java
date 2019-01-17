package org.shboland;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping("")
    public String greeting(@RequestParam(value="name", defaultValue = "you") String name) {
        return "Hello " + name;
    }
}
