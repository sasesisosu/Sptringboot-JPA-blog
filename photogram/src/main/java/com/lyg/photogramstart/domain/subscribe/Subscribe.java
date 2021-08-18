package com.lyg.photogramstart.domain.subscribe;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.lyg.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
	uniqueConstraints = {
			@UniqueConstraint(
				name="subscribe_uk",
				columnNames = {"fromUserId", "toUserId"}
			)
	}
)
public class Subscribe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JoinColumn(name="fromUserId")
	@ManyToOne
	private User fromUser;

	@JoinColumn(name="toUserId")
	@ManyToOne
	private User toUser;
	
	@CreationTimestamp 
	private Timestamp createDate;
}