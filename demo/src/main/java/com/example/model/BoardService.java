package com.example.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.BoardRequestDto;
import com.example.dto.BoardResponseDto;
import com.example.entity.Board;
import com.example.entity.BoardRepository;
import com.example.exception.CustomException;
import com.example.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	//JPA Repository �������̽�
	private final BoardRepository boardRepository;

    /**
     * �Խñ� ����
     */
	//JPA�� ����Ѵٸ�, ����(Service) Ŭ�������� �ʼ������� ���Ǿ�� �ϴ� ������̼�
	//�Ϲ������� �޼��� ������ �����ϰ� �Ǹ�, �޼����� ����, ����, ���ܸ� �������� ���� ����(begin), ����(commit), ����(rollback)�� �ڵ����� ó��
    @Transactional
    public Integer save(final BoardRequestDto params) {
    	// Entity Ŭ���������� ���� ��û/���� ��� �ȵǱ⿡ DTO���� ����
        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    /**
     * �Խñ� ����Ʈ ��ȸ
     */
    public List<BoardResponseDto> findAll() {
    	//sort ��ü�� ORDER BY id DESC, registDt DESC�� �ǹ�
        Sort sort = Sort.by(Direction.DESC, "id", "registDt");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    /**
     * �Խñ� ����
     */
    @Transactional
    public Integer update(final int id, final BoardRequestDto params) {
    	// Entity Ŭ������ ���ڵ带 ������ update ó���ϴ� ���
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContents(), params.getWriter());
        return id;
    }
}
