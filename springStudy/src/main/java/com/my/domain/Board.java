package com.my.domain;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
@Table(name="T_BOARD")
@Entity
public class Board {
	
	@GeneratedValue
	@Id
	private Long id;
	private String title;
	private String content;
	private String category;
	
	@OneToOne
	@JoinColumn(name="regId")
	private User regId;
	

	@Convert(converter = LocalDateConverter.class)
	private LocalDate regDt;

	@OneToOne
	@JoinColumn(name="modifyId")
	private User modifyId;
	
	
	@Convert(converter = LocalDateConverter.class)
	private LocalDate modifyDt;
	

}
