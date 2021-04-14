package org.hyosung.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hyosung.domain.ImproveBoard;
import org.hyosung.service.ImproveBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ImproveController {

    private final ImproveBoardService improveBoardService;

    /**
     * 조회화면
     * @param model
     * @return
     */
    @GetMapping("/improve")
    public String home(Model model) {

        List<ImproveBoard> improveBoards = improveBoardService.findAll();

       /* for (ErrBoard errBoard : errBoards) {
            System.out.println(" id == " + errBoard.getId());
        }*/

        model.addAttribute("boards", improveBoards);
        model.addAttribute("form", new ImproveForm());
        return "improve/improveBoard";
    }

    /**
     * 등록
     */
    @PostMapping("/improve/save")
    public String save(ImproveForm form) {
        log.info(" ### save ###");

        log.info("form === " + form);
        log.info("form.getGubun() === " + form.getGubun());
        log.info("form.getImproveContent() === " + form.getImproveContent());

        ImproveBoard board = new ImproveBoard();
        board.setGubun(form.getGubun());
        board.setTypename(form.getTypename());
        board.setCategory(form.getCategory());
        board.setImproveContent(form.getImproveContent());
        board.setCause(form.getCause());
        board.setDetail(form.getDetail());
        board.setMemo(form.getMemo());

        improveBoardService.save(board);

        return "redirect:/improve";
    }


    /**
     * 수정화면
     */
    @GetMapping("/improve/{boardId}/edit")
    public String updateImproveBoardForm(@PathVariable("boardId") Long boardId, Model model) {
        log.info(" ### updateImproveBoardForm ###");

        log.info("boardId === " + boardId);

        ImproveBoard improveBoard = (ImproveBoard) improveBoardService.findOne(boardId);
        log.info("improveBoard === " + improveBoard.getImproveContent());

        ImproveForm form = new ImproveForm();
        form.setId(improveBoard.getId());
        form.setGubun(improveBoard.getGubun());
        form.setTypename(improveBoard.getTypename());
        form.setCategory(improveBoard.getCategory());
        form.setImproveContent(improveBoard.getImproveContent());
        form.setCause(improveBoard.getCause());
        form.setDetail(improveBoard.getDetail());
        form.setMemo(improveBoard.getMemo());

        model.addAttribute("form", form);
        return "/improve/updateImproveBoardForm";
    }
}
