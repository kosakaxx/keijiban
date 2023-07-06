package jp.co.netboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.netboard.request.InsertPostRequest;
import jp.co.netboard.service.InsertPostService;


@RestController
@RequestMapping("")
public class InsertPostController {

    @PostMapping(value = "/post/insert",
            produces = {"application/json"},
            consumes = {"application/json"})
    public String insertPost (InsertPostRequest request) throws Exception{
        InsertPostService  insertPostService = new InsertPostService();
        return insertPostService.insertPost(request);
    }
}
