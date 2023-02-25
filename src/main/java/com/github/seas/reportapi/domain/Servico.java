package com.github.seas.reportapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "report_api_seas", name = "SERVICO")
public class Servico {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Integer id;

	@Column(name = "NOMECLATURA")
	private String nomeclatura;
}
