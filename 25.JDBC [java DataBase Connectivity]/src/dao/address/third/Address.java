package dao.address.third;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO(Value Object),DTO(Data Transfer Object)
 * 	- address테이블 1개 row의 데이타의 값을 가지는객체
 *  - address테이블 1개 row의 데이타값을 전달(파라메타,리턴데이타)시키기위한객체
 *  - address테이블의 컬럼과 동일한수의 멤버필드를 가지는객체
 */

//값을 가진 객체는 필드밖에 없다


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Address {
private int no;
private String name;
private String phone;
private String address;



	
}
