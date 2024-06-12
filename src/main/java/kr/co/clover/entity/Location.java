package kr.co.clover.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String addr1;
	private String addr2;
	private Integer areacode;
	private Integer sigungucode;
	private String cat1;
	private String cat2;
	private String cat3;
	private String contentid;
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
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
	private List<MemberLocation> memberlocationList;

}
