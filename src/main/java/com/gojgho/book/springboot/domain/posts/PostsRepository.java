package com.gojgho.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    // 보통 mybatis에서 dao 라고 불리는 db_layer 접근자이며 JPA에선 Repository 라고 부르는 인터페이스를 생성
    //단순 인터페이스 생성후 Repository<Entity class,PK타입> 을 상속하면 기본 CRUD 메소드가 자동생성된다

}
