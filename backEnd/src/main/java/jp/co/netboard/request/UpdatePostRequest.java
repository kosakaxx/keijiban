package jp.co.netboard.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdatePostRequest {

    //ID
    @NotNull(message = "必須項目です")
    private Integer postId;

    //投稿者名
    @NotBlank(message = "必須項目です")
    private String authorName;

    //本文
    @NotBlank(message = "必須項目です")
    private String postMessage;

    //パスワード
    @NotBlank(message = "必須項目です")
    private String Password;


}
