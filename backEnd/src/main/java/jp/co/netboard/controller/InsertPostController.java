package jp.co.netboard.controller;

import jp.co.netboard.request.InsertPostRequest;
import jp.co.netboard.response.PostResponse;
import jp.co.netboard.service.InsertPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class InsertPostController {

    @Autowired
    private InsertPostService insertPostService;

    /**
     * 投稿コントローラー(JSON)
     *
     * @param request 投稿リクエスト
     * @return 投稿結果メッセージ
     */
    @PostMapping(value = "/post/insert",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Object insertPost(@Validated @RequestBody InsertPostRequest request) {
        return insertPostService.insertPost(request);
    }
}
