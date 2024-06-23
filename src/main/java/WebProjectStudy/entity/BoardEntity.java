package WebProjectStudy.entity;

import WebProjectStudy.dto.Board.BoardDTO;
import WebProjectStudy.exception.HandleIsNotFoundException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name="Boards")
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "board_descriptions", joinColumns = @JoinColumn(name = "board_id"))
    @Column(name = "description")
    private List<String> descriptions;

    BoardEntity() {};

    public BoardEntity(BoardDTO board){
        this.title = board.getTitle();
        this.descriptions = board.getDescriptions();
        validate();
    }

    protected void validate(){
        if (title.isEmpty()) throw new HandleIsNotFoundException("[Entity] 제목은 공백 일 수 없습니다");
        for ( String des : descriptions ) {
            if (des.isEmpty()) throw new HandleIsNotFoundException("[Entity] 본문은 공백 일 수 없습니다");
        }
    }
}
