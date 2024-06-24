package WebProjectStudy.service.Board;

import WebProjectStudy.dto.Board.BoardDTO;
import WebProjectStudy.entity.BoardEntity;
import WebProjectStudy.exception.HandleIsNotFoundException;
import WebProjectStudy.repository.Board.BoardRepository;
import WebProjectStudy.uilityClass.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService implements BoardServiceInterface{

    private final Utility utility;
    private final BoardRepository boardRepository;

    @Override
    public void addBoard(BoardDTO board) {
        BoardEntity boardEntity = utility.boardDtoToEntity(board);
        boardRepository.save(boardEntity);
    }

    @Override
    public List<BoardEntity> findAll() {
        return boardRepository.findAll();

    }

    public boolean removeBoard(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new HandleIsNotFoundException("해당 게시물은 존재 하지 않습니다"));
        boardRepository.delete(boardEntity);
        return true;
    }

    public BoardEntity updateBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = boardRepository.findById(boardDTO.getId()).orElseThrow(() -> new HandleIsNotFoundException("해당 게시물은 존재하지 않습니다"));
        boardEntity.setTitle(boardDTO.getTitle());
        boardEntity.setDescriptions(boardDTO.getDescriptions());
        boardRepository.save(boardEntity);
        return boardEntity;
    }
}
