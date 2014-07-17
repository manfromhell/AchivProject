package com.ita.softserveinc.achiever.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 * @author Andriana
 *
 */
@Entity
@Table(name = "APPLICATIONS")
public class Application extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8213873526705936212L;

	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	private Group group;

	@OneToOne
	@PrimaryKeyJoinColumn(name="USER_ID")
	private User user;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
