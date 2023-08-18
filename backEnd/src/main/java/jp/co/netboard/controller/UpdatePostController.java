package jp.co.netboard.controller;

import jp.co.netboard.request.UpdatePostRequest;
import jp.co.netboard.response.PostResponse;
import jp.co.netboard.service.UpdatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class UpdatePostController {

    @Autowired
    private UpdatePostService updatePostService;

    /**
     * 投稿を更新します(JSON)
     *
     * @param request 投稿更新リクエスト
     * @return 更新結果メッセージ
     */
    @PostMapping(value = "/post/update",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Object insertPost(@Validated @RequestBody UpdatePostRequest request) {
        String message = updatePostService.updatePost(request);
        return PostResponse.builder().message(message).build();
    }
}
