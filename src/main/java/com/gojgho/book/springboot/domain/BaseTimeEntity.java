package com.gojgho.book.springboot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //1 JPA Entity클래스들이 BaseTimeEntity를 상속할 경우 필드들 (생성d수정d) 도 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //2 해당클래스 에 Auditing 기능 포함

public class BaseTimeEntity {
    @CreatedDate //3 Entity가 생성되어 저장시 시간이 자동저장
    private LocalDateTime createDate;

    @LastModifiedDate //4 조회한 Entity 의 값을 변경할떄 시간이 자동저장
    private LocalDateTime modifiedDate;

}
