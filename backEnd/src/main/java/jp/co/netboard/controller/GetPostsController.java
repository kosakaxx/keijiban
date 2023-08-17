package jp.co.netboard.controller;

import jp.co.netboard.response.GetPostsResponse;
import jp.co.netboard.service.GetPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class GetPostsController {

    @Autowired
    private GetPostsService getPostsService;

    /**
     * 投稿取得コントローラー
     *
     * @return GetPostsResponse　投稿一覧レスポンス
     */
    @RequestMapping(value = "/post/list",
            produces = {"application/json"},
            consumes = {"application/json"})
    public GetPostsResponse getPosts() {
        return getPostsService.getPosts();
    }
}
