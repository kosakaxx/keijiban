package jp.co.netboard.response;

import lombok.Data;

@Data
public class PostResponse {

    private String code;
    private String message;

    public PostResponse(String code,String messsage){
        this.code = code;
        this.message = messsage;
    }
}
