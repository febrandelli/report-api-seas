package com.github.seas.reportapi.controller.dto;

import com.github.seas.reportapi.domain.enums.DocumentTypeEnum;
import lombok.Data;

@Data
public class DocumentTypeDto {
	public String id;
	public String nomeclatura;

	public DocumentTypeDto (DocumentTypeEnum documentEnum) {
		this.id = documentEnum.id;
		this.nomeclatura = documentEnum.nomeclatura;
	}
}
