package com.ita.softserveinc.achiever.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "EVENTS")

public class Event extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2116639938850843156L;
	@Column(name = "DAY")
	private String day;
	@Column(name = "START_TIME")
	private String startTime;
	@Column(name = "END_TIME")
	private String endTime;
	@Column(name = "NAME")
	private String name;
	
	public Event() {
	}
	
	public Event(String title, String startTime, String endTime, String day) {
		this.name = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public String getTitle() {
		return name;
	}

	public void setTitle(String title) {
		this.name = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String beginTime) {
		this.startTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(name, startTime, endTime, day);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof Event) {
			Event that = (Event) object;
			return Objects.equal(this.name, that.name)
				&& Objects.equal(this.startTime, that.startTime)
				&& Objects.equal(this.endTime, that.endTime)
				&& Objects.equal(this.day, that.day);
		}
		return false;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
			.add("title", name)
			.add("beginTime", startTime)
			.add("endTime", endTime)
			.toString();
	}
		
}
