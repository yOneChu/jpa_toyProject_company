package org.hyosung.service;

import org.hyosung.domain.ErrBoard;
import org.hyosung.repository.ErrBoardRepository;
import lombok.RequiredArgsConstructor;
import org.hyosung.domain.ErrBoard;
import org.hyosung.repository.ErrBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // final있는 필드만 생성자 만들어 준다.(요즘 선호)
@Transactional(readOnly = true) // // spring트랜잭션을 썰, 왜냐면 쓸수있는 옵션들이 많기 때문에
public class ErrBoardService {

    private final ErrBoardRepository errBoardRepository;

    @Transactional
    public Long save(ErrBoard errBoard) {
        //validationDuplicateMember(member);
        errBoardRepository.save(errBoard);
        return errBoard.getId();
    }

    /*private void validationDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if( !findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }*/

    //전체조회
    public List<ErrBoard> findAll() {
        return errBoardRepository.findAll();
    }

    // 1건 조회
    public ErrBoard findOne(Long boardId) {
        return errBoardRepository.findOne(boardId);
    }
}


