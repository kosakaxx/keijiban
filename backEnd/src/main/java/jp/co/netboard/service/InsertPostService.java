package jp.co.netboard.service;

import jp.co.netboard.entity.KeijibanEntity;
import jp.co.netboard.repository.KeijibanRepository;
import jp.co.netboard.request.InsertPostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InsertPostService {

    @Autowired
    private KeijibanRepository keijibanRepository;


    public String insertPost(InsertPostRequest request) {
        KeijibanEntity keijibanEntity = new KeijibanEntity();
        keijibanEntity.setUserName(request.getAuthorName());
        keijibanEntity.setPostMessage(request.getPostMessage());
        keijibanEntity.setPassword(request.getPassword());
        keijibanEntity.setCreatedDatetime(new Date());


        try {
            keijibanRepository.save(keijibanEntity);
            return "投稿に成功しました";
        } catch (Exception e) {
            e.printStackTrace();
            return "投稿に失敗しました";

        }

    }
}
