package com.github.bee.board.service;


import com.github.bee.board.domain.Board;

import java.util.List;

public interface BoardService {

    List<Board> list(int page);

    void insertBoard(Board board);

    Board readBoard(int seq);

    void editBoard(Board board);

    void deleteBoard(int seq);
}
