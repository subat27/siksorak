package kr.co.clover.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
	@Id
	@Column(name = "contentid")
	private String contentid;

	private String addr1;
	private String addr2;
	private Integer areacode;
	private String sigungucode;
	private String cat1;
	private String cat2;
	private String cat3;
	private String contenttypeid;
	private String createdtime;
	private String modifiedtime;
	private String firstimage;
	private String firstimage2;
	private Double mapx;
	private Double mapy;
	private String tel;
	private String title;
	private String zipcode;
	private String booktour;
	private String mlevel;
	private String cpyrhtDivCd;
	
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private List<MemberLocation> members = new ArrayList<>();

	private int count;
	
	public void setCount() {
		this.count = members.size();
	}

}
