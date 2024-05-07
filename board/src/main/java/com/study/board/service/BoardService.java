// BoardService.java
package com.study.board.service;

import com.study.board.DTO.Board;
import com.study.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public String postBoard(Board board) {
        Board savedBoard = boardRepository.save(board);
        // 저장된 엔티티의 ID를 추출하여 반환
        return "Board saved with ID: " + savedBoard.getId();
    }





}
