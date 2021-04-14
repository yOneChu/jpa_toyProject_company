package org.hyosung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hyosung.domain.ErrBoard;
import org.hyosung.service.ErrBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final ErrBoardService errBoardService;

    /**
     * 조회화면
     * @param model
     * @return
     */
    @GetMapping("/board")
    public String home(Model model) {

        List<ErrBoard> errBoards = errBoardService.findAll();

       /* for (ErrBoard errBoard : errBoards) {
            System.out.println(" id == " + errBoard.getId());
        }*/

        model.addAttribute("boards", errBoards);
        model.addAttribute("form", new ErrBoardForm());
        return "errboard/errBoard";
    }

    @GetMapping("/contextList")
    public String contextList(Model model) {

        //List<ErrBoard> errBoards = errBoardService.findAll();

        //model.addAttribute("boards", errBoards);
        return "/errboard/errBoard";
    }


    /**
     * 등록
     */
    @PostMapping("/board/save")
    public String save(ErrBoardForm form){
        log.info(" ### save ###");

        log.info("form === " + form);
        log.info("form.getGubunStatus() === " + form.getGubunStatus());
        log.info("form.getTargetsw() === " + form.getTargetsw());
        log.info("form.getReqContent() === " + form.getReqContent());
        log.info("form.getRequestor() === " + form.getRequestor());
        log.info("form.getAdministrator() === " + form.getAdministrator());
        log.info("form.getCause() === " + form.getCause());
        log.info("form.getComContent() === " + form.getComContent());

        ErrBoard board = new ErrBoard();
        board.setGubunStatus(form.getGubunStatus());
        board.setTargetsw(form.getTargetsw());
        board.setReqContent(form.getReqContent()); // 요청내용
        board.setRequestor(form.getRequestor()); // 요청자
        board.setAdministrator(form.getAdministrator()); //담당자
        board.setCause(form.getCause()); //원인
        board.setComContent(form.getComContent()); //처리내역



        log.info("board === " + board);
        errBoardService.save(board);

        //return "/vocBoard/vocBoard";
        return "redirect:/board";
    }

    /**
     * 수정화면
     * @param boardId
     * @param model
     * @return
     */
    @GetMapping("/board/{boardId}/edit")
    public String updateErrBoardForm(@PathVariable("boardId") Long boardId, Model model) {
        log.info(" ### updateErrBoardForm ###");
        log.info("boardId === " + boardId);

        ErrBoard board = (ErrBoard) errBoardService.findOne(boardId);
        log.info("board.setAdministrator === " + board.getAdministrator());


        ErrBoardForm form = new ErrBoardForm();
        form.setId(board.getId());
        form.setGubunStatus(board.getGubunStatus());
        form.setTargetsw(board.getTargetsw());
        form.setReqContent(board.getReqContent());
        form.setRequestor(board.getRequestor());
        form.setAdministrator(board.getAdministrator());
        form.setCause(board.getCause());
        form.setComContent(board.getComContent());


        log.info("form.getId === " + form.getId());
        log.info("form.setReqContent === " + form.getReqContent());
        log.info("form.setAdministrator === " + form.getAdministrator());

        model.addAttribute("form", form);
        return "/errboard/updateErrBoardForm";
    }


    /***
     * 수정로직
     * @param boardId
     * @param form
     * @return
     */
    @PostMapping("/board/{boardId}/edit")
    public void updateErrBoard(@PathVariable("boardId") Long boardId, @ModelAttribute("form") ErrBoardForm form) {
        log.info(" ### updateErrBoard ###");

        log.info("boardId === " + boardId);
        log.info("form.getReqContent === " + form.getReqContent());

        ErrBoard board = new ErrBoard();
        board.setId(form.getId());
        board.setTargetsw(form.getTargetsw());
        board.setGubunStatus(form.getGubunStatus());
        board.setReqContent(form.getReqContent());
        board.setRequestor(form.getRequestor());
        board.setAdministrator(form.getAdministrator());

        board.setCause(form.getCause());
        board.setComContent(form.getComContent());

        errBoardService.save(board);

        //return "redirect:/board/";
    }
}
