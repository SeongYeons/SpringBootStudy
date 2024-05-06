package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String BoardWriteForm(){


        return "boardwrite";
    }

    @PostMapping("/board/writepro")
   public String boardWritePro(Board board){

    boardService.write(board);

        return "";
   }

   @GetMapping("/board/list")
    public String boardlist(Model model){

        model.addAttribute("list",boardService.boardList());

        return  "boardlist";
   }

   @GetMapping("/board/view")
    public String BoardView(Model model, @RequestParam("id") int id){

        model.addAttribute("board",boardService.boardView(id));

        return "boardview";
   }

   @GetMapping("/board/delete")
    public String boardDelete(@RequestParam("id") int id){

        boardService.boardDelete(id);

        return "redirect:/board/list";
   }
}
