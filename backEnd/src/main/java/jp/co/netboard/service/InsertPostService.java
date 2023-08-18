package jp.co.netboard.service;

import jp.co.netboard.entity.KeijibanEntity;
import jp.co.netboard.repository.KeijibanRepository;
import jp.co.netboard.request.InsertPostRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InsertPostService {

    @Autowired
    private KeijibanRepository keijibanRepository;

    /**
     * 投稿サービス
     *
     * @param request 投稿リクエスト
     * @return 投稿結果メッセージ
     */
    public String insertPost(InsertPostRequest request) {
        KeijibanEntity keijibanEntity = new KeijibanEntity();
        BeanUtils.copyProperties(request, keijibanEntity);

        //投稿処理
        keijibanRepository.save(keijibanEntity);
        return "投稿に成功しました";
    }
}
