# ✒ Grouping
![Screenshot 2023-03-28 at 14 09 23](https://github.com/AHNDOIL/Grouping/assets/103185987/bc4f93de-b80a-4e38-9480-bd7430312d81)


## 📢 프로젝트 소개
해당 시스템은 배달음식의 배달비를 여러 사람이 분담하는 시스템이다. 같은 위치의 음식점에서 주문을 하는 사람들끼리 배달비를 나누어, 갈수록 높아지는 배달비의 부담을 감소시키는 것을 목표로 한다. 그룹을 지어 동일한 음식점에서 주문을 한다하여 시스템의 이름은 Grouping이라 정했다. 


## ⌚ 개발 기간
- Conceptualization phase (2023. 03.13 ~ 03.31)
- Analysis phase (2023. 04.03 ~ 05.05)
- Design phase  (2023. 05.06 ~ 05.26)


## ⚙ 개발 환경
- Spring Boot
- MySQL
- Spring Security
- Docker
- JPA
- Thymeleaf


## 📌 시스템 구상도
![시스템 구상도](https://github.com/AHNDOIL/Grouping/assets/103185987/b175beef-4ff7-49c6-921f-aa7fa76f3147)

## 📌 Use Case Diagram
![Use Case Diagram](https://github.com/AHNDOIL/Grouping/assets/103185987/1787ad15-df93-41df-b135-ea50ded0731e)

## 📌 추가해야할 사항
- 멤버의 그룹 신청 및 그룹장의 그룹 관리 기능
- 예외 처리

## 📌 현재 구현된 기능
- Spring Security 로그인/로그아웃
- 그루핑 게시글 CRUD
- 댓글 CRUD
- 그룹장이 그루핑 게시글 생성시 자동으로 자신이 속한 그룹 생성
- Mypage
  

## 📌 프로젝트 실행 방법
- 1.해당 프로젝트 clone
  ```
  https://github.com/AHNDOIL/Grouping
  ```
- 2.MySQL schema 생성
  ```
  schema : localhost-grouping
  username : newuser
  password : grouping1234
  ```
- 3.IntelliJ로 해당 프로젝트를 연 뒤 GroupingApplication 실행
- 4.localhost:8080/home을 접속

- 현재 프로젝트는 Docker의 가상 컨테이너에 mysql을 생성 후 사용중이므로 동작이 다를 수 있습니다.
- application.yml에서 원하는 schema, username, password를 설정할 수 있습니다.


