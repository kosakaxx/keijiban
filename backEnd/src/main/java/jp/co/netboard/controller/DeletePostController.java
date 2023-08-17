package jp.co.netboard.controller;

import jp.co.netboard.request.DeletePostRequest;
import jp.co.netboard.request.UpdatePostRequest;
import jp.co.netboard.service.DeletePostService;
import jp.co.netboard.service.UpdatePostService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class DeletePostController {

    @Autowired
    private DeletePostService deletePostService;

    /**
     * 投稿削除コントローラー
     *
     * @param request 投稿削除リクエスト
     * @return 削除結果メッセージ
     */
    @PostMapping(value = "/post/delete",
            produces = {"application/json"},
            consumes = {"application/json"})
    public String deletePost(@Validated @RequestBody DeletePostRequest request) {
        return deletePostService.deletePost(request);
    }
}
