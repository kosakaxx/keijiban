package jp.co.netboard.repository;

import jp.co.netboard.entity.KeijibanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  KeijibanRepository extends JpaRepository<KeijibanEntity, Integer>{
}
