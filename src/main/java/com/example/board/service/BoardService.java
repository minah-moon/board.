package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.dto.PageRequestDTO;
import com.example.board.dto.PageResultDTO;
import com.example.board.entity.Board;
import com.example.board.entity.User;


public interface BoardService {
  Long register(BoardDTO dto);

  PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

  BoardDTO get(Long bno);

  void removeWithReplies(Long bno);

  default Board dtoToEntity(BoardDTO dto) {
    User user = User.builder().email(dto.getWriterEmail()).build();
    Board board = Board.builder()
        .bno(dto.getBno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(user)
        .build();
    return board;
  }

  default BoardDTO entityToDTO(Board board, User user, Long replyCount) {
    BoardDTO boardDTO = BoardDTO.builder()
        .bno(board.getBno())
        .title(board.getTitle())
        .content(board.getContent())
        .regDate(board.getRegDate())
        .modDate(board.getModDate())
        .writerEmail(user.getEmail())
        .writerName(user.getName())
        .replyCount(replyCount.intValue())
        .build();
    return boardDTO;
  }

  void modify(BoardDTO boardDTO);
}

