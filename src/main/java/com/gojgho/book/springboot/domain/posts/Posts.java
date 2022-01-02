package com.gojgho.book.springboot.domain.posts;


import com.gojgho.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //5 기본생성자 자동추가 public Posts() {} 와 같은 효과
@Entity //1 테이블과 링크될 클래스임을 나타냄, 기본값 클래스의 카멜케이스 이름을언더스코어 네이밍으로 테이블 이름을 매칭
//ex) SalesManager.java = > sales_manager table
public class Posts extends BaseTimeEntity {
        @Id //2 해당 테이블의 PK 필드를 나타냄
        @GeneratedValue(strategy = GenerationType.IDENTITY) //3 PK생성규칙 이옵션추가해야만 auto_increment가 됨
        private Long id;

        @Column(length = 500, nullable = false) //4 테이블의 칼럼을 나타내며 선언하지않아도 해당클래스의 필드는 모두 컬럼이 됨
        private String title;

        @Column(columnDefinition = "TEXT", nullable = false)
        private String content;

        private String author;

        @Builder //7
        public Posts(String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;

        }

        public void update(String title, String content){
            this.title = title;
            this.content = content;

        }


}



