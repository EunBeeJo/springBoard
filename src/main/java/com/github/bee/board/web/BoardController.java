package com.github.bee.board.web;

import com.github.bee.board.domain.Board;
import com.github.bee.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/list/{page}")
    public void boardList(@RequestParam int page, Model model) {
        model.addAttribute("list", boardService.list(page));
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public void writeBoardForm() {
        // return 글 쓰기 화면
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String writeBoardPost(@Valid Board board, BindingResult result) {
        if (result.hasErrors()) {
            return "board/write";
        }
        boardService.insertBoard(board);
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/read/{seq}")
    public void readBoard(@RequestParam int seq, Model model) {
        model.addAttribute("readBoard", boardService.readBoard(seq));
    }

    @RequestMapping(value = "/edit/{seq}", method = RequestMethod.GET)
    public void editBoardForm(@RequestParam int seq, Model model) {
        model.addAttribute("editBoard", boardService.readBoard(seq));
        // return editForm.jsp
    }

    @RequestMapping(value = "/edit/{seq}", method = RequestMethod.POST)
    public String editBoardProcess(@Valid Board board, BindingResult result) {
        if (result.hasErrors()) {
            return "board/edit";
        }
        boardService.editBoard(board);
        return "redirect:/board/read/{seq}";
    }

    @RequestMapping(value = "/delete/{seq}")
    public String deleteBoard(@RequestParam int seq) {
        boardService.deleteBoard(seq);
        return "board/list";
    }
}
