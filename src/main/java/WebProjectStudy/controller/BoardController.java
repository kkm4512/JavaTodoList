package WebProjectStudy.controller;

import WebProjectStudy.dto.Board.BoardDTO;
import WebProjectStudy.entity.BoardEntity;
import WebProjectStudy.service.Board.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/add")
    public boolean addBoard(@Valid @RequestBody BoardDTO board){
        boardService.addBoard(board);
        return true;
    }

    @GetMapping("/findAll")
    public List<BoardEntity> findAllBoards(){
        return boardService.findAll();
    }

    @GetMapping("/removeBoard/{id}")
    public boolean removeBoard(@PathVariable("id") Long id){
        System.out.println(id);
        boardService.removeBoard(id);
        return true;
    }
}
