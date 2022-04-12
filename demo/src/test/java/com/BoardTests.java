package com;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.entity.Board;
import com.board.entity.BoardRepository;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {

        // 1. �Խñ� �Ķ���� ����
        Board params = Board.builder()
                .title("1�� �Խñ� ����")
                .contents("1�� �Խñ� ����")
                .userId("������")
                .hits(0)
                .delYn('N')
                .build();

        // 2. �Խñ� ����
        boardRepository.save(params);

        // 3. 1�� �Խñ� ���� ��ȸ
        Board entity = boardRepository.findById((int) 1).get();
        assertThat(entity.getTitle()).isEqualTo("1�� �Խñ� ����");
        assertThat(entity.getContents()).isEqualTo("1�� �Խñ� ����");
        assertThat(entity.getUserId()).isEqualTo("������");
    }

    @Test
    void findAll() {
        // 1. ��ü �Խñ� �� ��ȸ
        long boardsCount = boardRepository.count();
        // 2. ��ü �Խñ� ����Ʈ ��ȸ
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {
        // 1. �Խñ� ��ȸ
        Board entity = boardRepository.findById((int) 1).get();
        // 2. �Խñ� ����
        boardRepository.delete(entity);
    }

}
