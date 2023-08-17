package jp.co.netboard.response;

import lombok.Data;


import java.util.Date;

@Data
public class Post {

    /**
     * ID
     */
    private Integer postId;

    /**
     * 名前
     */
    private String authorName;

    /**
     * 本文
     */
    private String postMessage;

    /**
     * 投稿日時
     */
    private Date createdDatetime;

    /**
     * 更新日時
     */
    private Date updatedDatetime;
}
