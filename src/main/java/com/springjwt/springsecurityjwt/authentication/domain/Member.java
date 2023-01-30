package com.springjwt.springsecurityjwt.authentication.domain;

import com.springjwt.springsecurityjwt.common.baseEntity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SequenceGenerator(
	name = "MEMBER_SEQ_GENERATOR",
	sequenceName = "MEMBER_SEQ",
	initialValue = 1,
	allocationSize = 50
)
@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "email", "password"})
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "MEMBER_SEQ_GENERATOR"
	)
	@Column(name = "member_id")
	private Long id;

	@Column(name = "name")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Builder.Default
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role = Role.USER;


	private Member(final Long id, final String username, final String email, final String password,
		final Role role) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public void update(final Member updateMember) {
		updateUsername(updateMember.username);
		updateEmail(updateMember.email);
		updatePassword(updateMember.password);
	}

	public String getRole() {
		return role.getRoleName();
	}

	private void updateUsername(String username) {
		this.username = username;
	}

	private void updateEmail(String email) {
		this.email = email;
	}

	private void updatePassword(String password) {
		this.password = password;
	}

}


















