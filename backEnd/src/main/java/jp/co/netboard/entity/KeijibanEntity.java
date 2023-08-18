package jp.co.netboard.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
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
    private String authorName;

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
    @Column(name = "created_datetime", updatable = false)
    @CreatedDate
    private Date createdDatetime;

    /**
     * 更新日時
     */
    @Column(name = "updated_datetime", insertable = false)
    @LastModifiedDate
    private Date updatedDatetime;
}
