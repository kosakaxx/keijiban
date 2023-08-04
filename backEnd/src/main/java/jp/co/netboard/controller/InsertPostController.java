package jp.co.netboard.controller;

import jp.co.netboard.request.InsertPostRequest;
import jp.co.netboard.service.InsertPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class InsertPostController {

    @Autowired
    InsertPostService insertPostService;

    @PostMapping(value = "/post/insert",
            produces = {"application/json"},
            consumes = {"application/json"})
    public String insertPost(@RequestBody InsertPostRequest request) throws Exception {
        return insertPostService.insertPost(request);
    }
}
