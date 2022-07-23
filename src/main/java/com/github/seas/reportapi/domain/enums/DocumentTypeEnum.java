package com.github.seas.reportapi.domain.enums;

import java.util.Arrays;
import java.util.List;

public enum DocumentTypeEnum {
	RG("RG", "RG"),
	CPF("CPF", "CPF"),
	CERTIDAO("CERTIDAO", "CERTIDA DE NASCIMENTO"),
	ALVARA("ALVARA","ALVARA DE SOLTURA"),
	BO("BO","BOLETIM DE OCORRENCIA"),
	OUTROS("OUTROS","OUTROS");

	public final String id;
	public final String nomeclatura;

	DocumentTypeEnum(String id, String nomeclatura){
		this.id = id;
		this.nomeclatura = nomeclatura;
	}

	public static List<DocumentTypeEnum> getAllDocumentType() {
		return Arrays.asList(DocumentTypeEnum.values());
	}
}
