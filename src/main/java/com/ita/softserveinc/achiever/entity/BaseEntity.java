package com.ita.softserveinc.achiever.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -5268130166874652925L;

	// @Version Long version;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	/*@TableGenerator(name = "IdGenerator", pkColumnValue = "BaseEntityId", table = "Sequence_Table", allocationSize = 1)*/
	@Column(name = "ID")
	private Long id;

	/*
	 * @Column(name = "CREATED", columnDefinition =
	 * "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable =
	 * false) private Timestamp CREATED;
	 * 
	 * @Column(name = "LAST_UPDATE", columnDefinition =
	 * "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable =
	 * false) private Timestamp lastUpdate;
	 */

	public BaseEntity() {
		/* lastUpdate = new Timestamp(System.currentTimeMillis()); */
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	public void setId(Long id){
		this.id=id;
	}

}
