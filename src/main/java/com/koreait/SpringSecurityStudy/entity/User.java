package com.koreait.SpringSecurityStudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String username;
    @JsonIgnore
    private String password;
    private String email;

    //According to definition of Entity, is it against the law?
    //JPA를 사용한다면 위배 될 수 있다, 하지만 Mybatis에서는 Entity가 DTO의 개념을 함께 가지고 있다
    //그럼 어차피 userId로 조인해서 조회하면 되는데 왜 굳이 멤버변수로 추가하냐?
    //객체 지향적 설게를 위함 => 객체를 참조할 수 있는 구조를 선호
    private List<UserRole> userRoles;
}

//권한 목록과 유저 권한 목록을 따로 둔 이유
//만약 유저당 하나의 권한만 가질 수 있을 때
//User는 1개의 Role만 가질 수 있음
//Role은 N명의 사용자에게 부여될 수 있음
//==> 1:N 관계
//하지만 이러면 관리자 이면서 일반 사용자인 경우 동시에 두 개의 권한을 가질 수 없다.
//User는 야러 Role을 가질 수 있음
//Role도 여러 User에게 부여될 수 있음
//==> N:M 관계
//이러면 권한 관리가 복잡해지기 때문에 권한 목록인 중간 테이블을 따로 분리해서 관리