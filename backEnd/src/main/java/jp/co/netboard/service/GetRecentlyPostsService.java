package jp.co.netboard.service;

import jp.co.netboard.entity.KeijibanEntity;
import jp.co.netboard.repository.KeijibanRepository;
import jp.co.netboard.response.GetPostsResponse;
import jp.co.netboard.response.Post;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetRecentlyPostsService {

    @Autowired
    KeijibanRepository keijibanRepository;

    /**
     * 投稿取得サービス
     *
     * @return GetPostsResponse　投稿一覧レスポンス
     */
    public GetPostsResponse getRecentlyPosts() {

        //本日の0時０分と23時59分を算出
        LocalDateTime from = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime to = LocalDateTime.now().with(LocalTime.MAX);
        ZonedDateTime zonedFrom = from.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedTo = to.atZone(ZoneId.systemDefault());
        Date fromDate = Date.from(zonedFrom.toInstant());
        Date toDate = Date.from(zonedTo.toInstant());

        //DBから本日に投稿された記事を取得
        List<KeijibanEntity> postEntityList = keijibanRepository.findByCreatedDatetimeBetween(fromDate, toDate);

        List<Post> postList = new ArrayList<Post>();
        postEntityList.forEach(entity -> {
            Post post = new Post();
            BeanUtils.copyProperties(entity, post);
            postList.add(post);
        });

        //投稿日時を降順にしてソート
        postList.sort(Comparator.comparing(Post::getCreatedDatetime).reversed());

        //投稿数の算出
        Integer postCount = postList.size();

        //レスポンスにセット
        GetPostsResponse response = new GetPostsResponse();
        response.setPostList(postList);
        response.setPostCount(postCount);
        return response;

    }
}
