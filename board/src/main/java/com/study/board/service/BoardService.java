package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.Boardrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private Boardrepository boardrepository;

    //글작성
    public void write(Board board){

        boardrepository.save(board);

    }
    //게시글 리스트 처리
    public List<Board> boardList(){

        return boardrepository.findAll();
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardrepository.findById(id).get();
    }

    //특정 게시글 삭제

    public void boardDelete(Integer id){

        boardrepository.deleteById(id);
    }
}
