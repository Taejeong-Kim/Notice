# Notice Project

## What is This?
* 공지사항 등록/조회/수정/삭제 기능을 지원하는 기본 게시판입니다.

## Documentation
* 프로젝트 실행 방법은 README.md 에 명시되어 있습니다.

## Software Requirement
* 스프링 부트(STS) 
  - https://spring.io/tools3/sts/all  
* H2 DB(DBMS)
  - 프로젝트 내의 Dependency 설정과 프로퍼티 설정을 통하여 구축하였습니다.  
* MyBatis
  - Dependency, 프로퍼티 설정  

## Installing the source
**Download Zip**
  - github 프로젝트 주소 접속 후, 'Clone or download'에서 DownloadZIP 으로 다운로드
  - 압축 해제 후, STS에서 Project Import -> Directory에서 압축 해제한 폴더 지정
  - Notice-master\Notice-master\assignment 체크 후 Finish
  
## Compiling
**프로젝트 빌드 및 실행**
1. STS에 프로젝트 Import 후, Window > Show View > Spring > Boot Dashboard에서 assignment 우클릭 start
2. 프로젝트(assignment) 우클릭, Run As > Spring Boot App

## 참고사항
**1. 최초 로그인 계정은 두 가지 입니다.**
  - ID : admin, PW : admin // 공지사항 등록, 조회, 수정, 삭제 권한
  - ID : user1, PW : user1 // 공지사항 조회 권한

**2. 초기 데이터는 페이징 기능 시연을 위해 공지사항 총 133 건이 기본 Insert됩니다.**  
**3. 공지사항 수정 시, 초기 비밀번호는 모두 '1234' 입니다.**  
**4. 한글 인코딩은 UTF-8 입니다.**
