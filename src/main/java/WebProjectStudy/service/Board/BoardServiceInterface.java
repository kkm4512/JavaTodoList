package WebProjectStudy.service.Board;

import WebProjectStudy.dto.Board.BoardDTO;
import WebProjectStudy.entity.BoardEntity;

import java.util.List;

public interface BoardServiceInterface {
    public void addBoard(BoardDTO board);
    public List<BoardEntity> findAll();
    public boolean removeBoard(Long id);
}
