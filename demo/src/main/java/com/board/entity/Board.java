package com.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity Ŭ������ ���̺�(Table) �Ǵ� ���ڵ�(Record) ������ �ϴ� �����ͺ��̽� �� ��ü
 * ��û(Request)�̳� ����(Response)�� ���Ǿ�� �ȵȴ� 
 * @author SJ
 *
 */

//�ش� Ŭ������ ���Ե� ��� ������ ��� getter �޼��带 ����
@Getter
//�ش� Ŭ������ �⺻ �����ڸ� ������ �ִ� ������̼�
//access �Ӽ��� �̿��ؼ� ������ ��Ű�� ���� Ŭ���������� ��ü�� ������ �� �ֵ��� ����
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//�ش� Ŭ������ ���̺�� ���εǴ� JPA�� ��ƼƼ(Entity) Ŭ�������� �ǹ�
//�⺻������ Ŭ������(Camel Case)�� ���̺��(Snake Case)���� ����
//���� ���, user_role�̶�� ���̺��� UserRole�̶�� �̸��� Ŭ������ ���̹�
//Ȥ�ö� Ŭ������� ���̺���� �ٸ� ���ۿ� ���� ��Ȳ������ Ŭ���� ������ @Table�� ����
//@Table(name = "user_role")�� ���� name �Ӽ��� �̿��ؼ� ó��
@Entity
@SequenceGenerator(name="board_pk_generator", sequenceName = "board_seq", initialValue = 1, allocationSize = 1)
public class Board {

    @Id // PK���� �ǹ�
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_pk_generator") // PK ������
    private Integer boardId; // PK
    private String title; // ����
    private String contents; // ����
    private String userId; // �ۼ���ID
    private String userNm; // �ۼ��ڸ�
    private int hits; // ��ȸ ��
    private char delYn; // ���� ����
    private LocalDateTime registDt = LocalDateTime.now(); // ������
    private LocalDateTime updtDt; // ������

    //�Һ����� �������ִ� ������� �������, ������ ��ſ� �̿��ϴ� ����
    @Builder
    public Board(String title, String contents, String userId, String userNm, int hits, char delYn) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
        this.userNm = userNm;
        this.hits = hits;
        this.delYn = delYn;
    }
    
    //update ������ �����ϴ� ������ ���� -> JPA������ ���Ӽ��̶� ���ؽ�Ʈ��� �������� �ڵ� ����
    public void update(String title, String contents, String userId) {
    	this.title = title;
    	this.contents = contents;
    	this.userId = userId;
    	this.updtDt = LocalDateTime.now();
    }
    
    /**
     * ��ȸ �� ����
     */
    public void increaseHits() {
        this.hits++;
    }

    /**
     * �Խñ� ����
     */
    public void delete() {
        this.delYn = 'Y';
    }

}
