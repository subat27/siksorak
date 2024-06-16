package kr.co.clover.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "eventinfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventInfo {
	@Id
	@Column(name = "contentid")
	private String contentid;

	private String addr1;			// 주소
	private String addr2;			// 상세주소
	private String areacode;		// 지역코드
	private String createdtime;		// 등록일
	private String eventstartdate;	// 행사시작일	
	private String eventenddate;	// 행사종료일
	private String firstimage;		// 대표이미지(원본)
	private String mapx;			// GPS X좌표
	private String mapy;			// GPS Y좌표
	private String modifiedtime;	// 수정일
	private String tel;				// 전화번호
	private String title;			// 제목
	private String booktour;
	private String firstimage2;		// 대표이미지(원본)
	private String contenttypeid;
	private String cpyrhtDivCd;
	private String mlevel;
	private String cat1;
	private String cat2;
	private String cat3;
	private String sigungucode;
	
	


}
