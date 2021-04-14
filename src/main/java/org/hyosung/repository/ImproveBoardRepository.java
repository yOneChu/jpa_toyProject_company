package org.hyosung.repository;

import lombok.RequiredArgsConstructor;
import org.hyosung.domain.ImproveBoard;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImproveBoardRepository {

    private final EntityManager em;

    //저장
    public void save(ImproveBoard board){
        em.persist(board);
    }

    // 1건 조회
    public ImproveBoard findOne(Long id) {
        return em.find(ImproveBoard.class, id);
    }

    //전체 조회
    public List<ImproveBoard> findAll() {
        return em.createQuery("select e from ImproveBoard e", ImproveBoard.class)
                .getResultList();
    }
}
