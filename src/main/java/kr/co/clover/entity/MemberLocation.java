package kr.co.clover.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "memberlocation")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberLocation {
	
	@EmbeddedId
	private MemberLocationId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("memberId")
	private Member member;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("contentid")
    private Location location;
	
}

