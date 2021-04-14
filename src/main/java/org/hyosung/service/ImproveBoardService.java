package org.hyosung.service;

import lombok.RequiredArgsConstructor;
import org.hyosung.domain.ImproveBoard;
import org.hyosung.repository.ImproveBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // final있는 필드만 생성자 만들어 준다.(요즘 선호)
@Transactional(readOnly = true) // // spring트랜잭션을 썰, 왜냐면 쓸수있는 옵션들이 많기 때문에
public class ImproveBoardService {

    private final ImproveBoardRepository improveBoardRepository;

    @Transactional
    public Long save(ImproveBoard improveBoard) {
        //validationDuplicateMember(member);
        improveBoardRepository.save(improveBoard);
        return improveBoard.getId();
    }

    //전체조회
    public List<ImproveBoard> findAll() {
        return improveBoardRepository.findAll();
    }

    // 1건 조회
    public ImproveBoard findOne(Long boardId) {
        return improveBoardRepository.findOne(boardId);
    }
}
