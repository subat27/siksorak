package kr.co.clover.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	private Integer memberId;
    private String locationId;
	
}
