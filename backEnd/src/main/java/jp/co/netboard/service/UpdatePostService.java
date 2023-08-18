package jp.co.netboard.service;

import jp.co.netboard.entity.KeijibanEntity;
import jp.co.netboard.repository.KeijibanRepository;
import jp.co.netboard.request.UpdatePostRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class UpdatePostService {

    @Autowired
    private KeijibanRepository keijibanRepository;

    /**
     * 投稿更新サービス
     *
     * @param request 更新データ
     * @return メッセージ
     */
    public String updatePost(UpdatePostRequest request) {
        //リクエストのIdに一致する投稿データを取得する
        KeijibanEntity keijibanEntity = keijibanRepository.findById(request.getPostId()).orElseThrow();

        //取得した投稿データにパスワードが設定されていない場合は、更新できない
        if (ObjectUtils.isEmpty(keijibanEntity.getPassword())) {
            return "パスワードを設定していない投稿は更新できません";
        }

        //リクエストのパスワードと取得したデータのパスワードが一致しない場合は、更新しない。
        if (keijibanEntity.getPassword().equals(request.getPassword())) {
            //リクエストの投稿名・本文が更新されていなければ、更新処理を行わない
            if (keijibanEntity.getAuthorName().equals(request.getAuthorName())
                    && keijibanEntity.getPostMessage().equals(request.getPostMessage())) {
                return "投稿者名、もしくは本文を更新してください";
            }

            //投稿更新処理
            keijibanEntity.setPostMessage(request.getPostMessage());
            keijibanEntity.setAuthorName(request.getAuthorName());
            keijibanRepository.save(keijibanEntity);
            return "更新に成功しました";

        } else {
            return "パスワードが異なります";
        }
    }
}
