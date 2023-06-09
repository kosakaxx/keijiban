package jp.co.netboard.controller;

import jp.co.netboard.response.PostResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class InsertPostController {

    @PostMapping(value = "/post/insert",
            produces = {"application/json"},
            consumes = {"application/json"})
    public PostResponse hello (){
        String hello = "Hello World";
        String code = "200";

        PostResponse response = new PostResponse(code,hello);

        return response;
    }
}
