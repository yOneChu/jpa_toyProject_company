package org.hyosung.repository;

import org.hyosung.domain.ErrBoard;
import lombok.RequiredArgsConstructor;
import org.hyosung.domain.ErrBoard;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ErrBoardRepository {

    private final EntityManager em;

    //저장
    public void save(ErrBoard board){
        em.persist(board);
    }

    // 1건 조회
    public ErrBoard findOne(Long id) {
        return em.find(ErrBoard.class, id);
    }

    //전체 조회
    public List<ErrBoard> findAll() {
        return em.createQuery("select e from ErrBoard e", ErrBoard.class)
                .getResultList();
    }

    // 요청자 검색
    public List<ErrBoard> findByRequestor(String requestor) {
        return em.createQuery("select e from ErrBoard e where e.requestor = :requestor", ErrBoard.class)
                .setParameter("requestor", requestor)
                .getResultList();
    }

}
