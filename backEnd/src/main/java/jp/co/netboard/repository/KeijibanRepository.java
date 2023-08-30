package jp.co.netboard.repository;

import jp.co.netboard.entity.KeijibanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface KeijibanRepository extends JpaRepository<KeijibanEntity, Integer> {

    // SELECT e FROM Employee e WHERE e.hiredAt BETWEEN ?1 AND ?2
    List<KeijibanEntity> findByCreatedDatetimeBetween(Date from, Date to);
}
