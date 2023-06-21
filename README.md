# 커머스 프로젝트
온라인 쇼핑몰 서비스입니다.

## 프로젝트 기능 및 설계
* 회원가입 기능
  * 판매자와 구매자 둘 중 하나로 회원가입을 할 수 있다.
  * 회원가입 시 아이디와 패스워드, 이름, 이메일, 닉네임, 생년월일을 입력받으며, 아이디, 이메일, 닉네임은 unique 해야한다. (이메일 하나 당 회원 한 명)
  * 모든 사용자는 회원가입 시 이메일 인증을 해야한다.
 
* 로그인 기능
  * 사용자는 로그인을 할 수 있다.
  * 로그인 시 회원가입 때 사용한 아이디와 패스워드가 일치해야 한다.
 
* 상품명 검색 기능
  * 모든 회원과 비회원은 상품을 검색할 수 있다.
  * 상품명, 가격, 평점을 보여준다.
 
* 상품 상세 정보 기능
  * 해당 상품의 상품명, 별점, 가격, 옵션, 상품평을 보여준다.

* 상품 등록 기능
  * 상품 등록은 판매자만 가능하다.
  * 상품의 옵션과 수량, 가격을 등록해야 한다.
 
* 상품 장바구니 기능
  * 장바구니 기능은 로그인한 사용자만 이용할 수 있다.
  * 비회원이 장바구니 기능 사용 시 에러를 발생시킨다.
  * 상품 담기, 장바구니 조회, 장바구니 상품 삭제, 수량 증가, 수량 감소 기능을 사용할 수 있다.
  * 상품 담기 시 해당 상품의 최대 수량 또는 잔여 수량을 넘길 수 없다.
  * 상품 담기 시 해당 상품의 개수는 1개 이상이어야 한다. (1개에서 수량 감소 기능 불가)
 
* 장바구니 접근 허가 기능
  *  로그인 시에만 장바구니에 접근할 수 있다.
  *  로그아웃 후 다시 로그인 시 이전 장바구니에 넣은 상품 유지

* 리뷰 목록 조회 기능
  * 상품 상세 정보 조회 시 리뷰목록도 함께 조회된다.
  * 회원, 비회원 모두 리뷰 목록을 조회할 수 있다.
  * 로그인한 회원만 다른 회원의 리뷰에 평가를 남길 수 있다. (도움이 됨, 도움이 되지 않음)
  * 리뷰는 도움이 됨 개수가 많은 리뷰 순으로 보여준다.
  * 도움이 됨과 도움이 되지 않음 평가는 버튼 형식으로 둘 중 하나를 누르게 되면 해당 숫자가 올라가는 형식이다.
  * 하나의 리뷰에 도움이 됨/도움이 되지 않음 중 하나의 평가만 할 수 있고, 한 번만 평가 할 수 있다.
  * 도움이 됨 개수가 같으면 최신 리뷰가 먼저 나오게 된다.
  * 작성자 닉네임, 별점, 제목, 내용을 보여준다.
 
* 리뷰 작성 기능
  * 로그인한 사용자는 리뷰를 작성할 수 있다.
  * 리뷰는 작성자 닉네임, 제목, 내용, 별점으로 이루어져 있다.
 
## ERD
![db 설계 수정](https://github.com/hg051510/CommerceProject/assets/81662934/95241645-1120-4ba3-8a63-b40ac6468ec2)

## 트러블 슈팅
[go to the trouble shooting section](https://github.com/hg051510/CommerceProject/blob/main/doc/TROUBLE_SHOOTING.md)

## 기술 스택
