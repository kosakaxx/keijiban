package jp.co.netboard.service;

import jp.co.netboard.entity.KeijibanEntity;
import jp.co.netboard.repository.KeijibanRepository;
import jp.co.netboard.response.GetPostsResponse;
import jp.co.netboard.response.Post;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GetPostsService {

    @Autowired
    KeijibanRepository keijibanRepository;

    /**
     * 投稿取得サービス
     *
     * @return GetPostsResponse　投稿一覧レスポンス
     */
    public GetPostsResponse getPosts() {

        List<Post> postList = new ArrayList<Post>();

        //DBから全ての記事を検索
        List<KeijibanEntity> postsEntityList = keijibanRepository.findAll();
        postsEntityList.forEach(entity -> {
            Post post = new Post();
            BeanUtils.copyProperties(entity, post);
            if (post.getCreatedDatetime() != null) {
                postList.add(post);
            }
        });
        //投稿日時を降順にしてソート
        postList.sort(Comparator.comparing(Post::getCreatedDatetime).reversed());
        Integer postCount = postList.size();

        //レスポンスにセット
        GetPostsResponse response = new GetPostsResponse();
        response.setPostList(postList);
        response.setPostCount(postCount);
        return response;

    }
}
