package jp.co.netboard.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InsertPostRequest {

    //投稿者名
    @NotBlank(message = "必須項目です")
    private String authorName;

    //本文
    @NotBlank(message = "必須項目です")
    private String postMessage;

    //パスワード
    private String Password;


}
