package jp.co.netboard.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponse {

    //メッセージ
    private String message;

}
