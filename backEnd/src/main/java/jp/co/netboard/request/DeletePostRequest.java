package jp.co.netboard.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DeletePostRequest {

    //ID
    @NotNull(message = "必須項目です")
    private Integer postId;

    //パスワード
    @NotBlank(message = "必須項目です")
    private String Password;


}
