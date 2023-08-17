package jp.co.netboard.response;

import lombok.Data;

import java.util.List;

@Data
public class GetPostsResponse {
    /**
     * 加点履歴リスト
     */
    public List<Post> postList;

    /**
     * 記事数
     */
    public Integer postCount;

}
