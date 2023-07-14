package jp.co.netboard.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "trn_posts")
public class KeijibanEntity {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    /**
     * 名前
     */
    @Column(name = "author_name")
    private String userName;

    /**
     * 本文
     */
    @Column(name = "post_message")
    private String postMessage;

    /**
     * パスワード
     */
    @Column(name = "password")
    private String password;

    /**
     * 投稿日時
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新日時
     */
    @Column(name = "update_date")
    private Date updateDate;
}
