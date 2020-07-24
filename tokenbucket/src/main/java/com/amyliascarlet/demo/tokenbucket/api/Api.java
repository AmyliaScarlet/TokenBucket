package com.amyliascarlet.demo.tokenbucket.api;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@ResponseBody
public class Api {

    @RequireToken(BucketName="demo")
    @GetMapping("/demo")
    public String demo() {
        System.out.println("demo dosomething");
        return "ok";
    }

    @RequireToken(BucketName="demo2")
    @GetMapping("/demo2")
    public String demo2() {
        System.out.println("demo2 dosomething");
        return "ok";
    }

    @GetMapping("/test")
    public String test() {
         return "test";
    }
}
