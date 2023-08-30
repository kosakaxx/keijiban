package jp.co.netboard.controller;

import jp.co.netboard.response.GetPostsResponse;
import jp.co.netboard.service.GetPostsService;
import jp.co.netboard.service.GetRecentlyPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class GetRecentlyPostsController {

    @Autowired
    private GetRecentlyPostsService getRecentlyPostsService;

    /**
     * 投稿取得コントローラー
     *
     * @return GetPostsResponse　投稿一覧レスポンス
     */
    @RequestMapping(value = "/post/list/recently",
            produces = {"application/json"})
    public GetPostsResponse getRecentlyPosts() {
        return getRecentlyPostsService.getRecentlyPosts();
    }
}
