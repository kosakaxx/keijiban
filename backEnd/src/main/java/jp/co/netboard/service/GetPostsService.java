package jp.co.netboard.service;

import jp.co.netboard.entity.KeijibanEntity;
import jp.co.netboard.repository.KeijibanRepository;
import jp.co.netboard.response.GetPostsResponse;
import jp.co.netboard.response.Posts;
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


    public GetPostsResponse getPosts() {

        List<Posts> postList = new ArrayList<Posts>();

        //DBから全ての記事を検索
        List<KeijibanEntity> postsEntityList = keijibanRepository.findAll();
        postsEntityList.forEach(entity -> {
            Posts posts = new Posts();
            BeanUtils.copyProperties(entity, posts);
            if (posts.getCreatedDatetime() != null) {
                postList.add(posts);
            }
        });
        //投稿日時を降順にしてソート
        postList.sort(Comparator.comparing(Posts::getCreatedDatetime).reversed());
        Integer postCount = postList.size();

        //レスポンスにセット
        GetPostsResponse response = new GetPostsResponse();
        response.setPostList(postList);
        response.setPostCount(postCount);
        return response;

    }
}
