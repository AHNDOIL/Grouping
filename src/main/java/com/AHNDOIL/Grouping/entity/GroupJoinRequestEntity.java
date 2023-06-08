package com.AHNDOIL.Grouping.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "JOIN_REQUEST")
public class GroupJoinRequestEntity extends BaseEntity{

//    1. 그룹 가입 요청이 생성되면 해당 요청은 데이터베이스에 저장
//    2. 그룹 리더는 주기적으로 데이터베이스를 조회하여 새로운 가입 요청이 있는지 확인
//    3. 가입 요청을 확인한 리더는 요청에 대한 처리를 진행 수락 or 거절
//    4. 리더가 가입 요청을 처리하면 결과는 데이터베이스에 반영
//    5. 가입 요청을 보낸 사용자는 가입 요청이 수락되거나 거절되었는지 확인
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity requester;

    @ManyToOne
    @JoinColumn(name = "group_id") //group에 leader 이미 포함됨
    private GroupEntity groupEntity;

    private String status; //요청 상태
}
