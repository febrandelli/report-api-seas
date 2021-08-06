package com.github.seas.reportapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Servico {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Long id;

	@Column(name = "NOMECLATURA")
	private String nomeclatura;
}
