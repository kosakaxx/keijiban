package jp.co.netboard.service;

import jp.co.netboard.entity.KeijibanEntity;
import jp.co.netboard.repository.KeijibanRepository;
import jp.co.netboard.request.DeletePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DeletePostService {

    @Autowired
    private KeijibanRepository keijibanRepository;

    /**
     * 投稿削除サービス
     *
     * @param request 更新データ
     * @return メッセージ
     */
    public String deletePost(DeletePostRequest request) {
        //リクエストのIdに一致する投稿データを取得する
        KeijibanEntity keijibanEntity = keijibanRepository.findById(request.getPostId()).orElseThrow();

        //取得した投稿データにパスワードが設定されていない場合は、削除できない
        if (StringUtils.isEmpty(keijibanEntity.getPassword())) {
            return "パスワードを設定していない投稿は削除できません";
        }

        //リクエストのパスワードと取得したデータのパスワードが一致しない場合は、更新しない。
        if (keijibanEntity.getPassword().equals(request.getPassword())) {

            //投稿削除処理
            keijibanRepository.delete(keijibanEntity);
            return "削除に成功しました";

        } else {
            return "パスワードが異なります";
        }
    }
}
