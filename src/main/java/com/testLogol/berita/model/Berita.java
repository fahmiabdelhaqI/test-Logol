package com.testLogol.berita.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name ="berita")
public class Berita {
	
	@Id
	private String id;
	private String judul;
	
	@Column(columnDefinition = "text")
	private String deskripsi;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date create_date;
	
	@Override
	public String toString() {
		return "Berita [id=" + id +", judul=" + judul + ", deskripsi=" + deskripsi + ", create_date=" + create_date +"]";
	}

}
