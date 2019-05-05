package com.other.hibernate.bean;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "balance")
@AllArgsConstructor
@NoArgsConstructor
public class Balance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	@Column(name = "amount", nullable = false, unique = false)
	public long amount;
	
	@Column(name = "name", nullable = false, unique = false)
	public String name;

	@Column(name = "created_at", nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	public Date createdAt;

	@Column(name = "updated_at", nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	public Date updatedAt;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(id);
		sb.append("name:").append(name);
		sb.append("amount:").append(amount);
		sb.append("created_ad:").append(createdAt);
		sb.append("updated_ad:").append(updatedAt);
		return sb.toString();
	}
}
