package com.github.seas.reportapi.domain.enums;

public enum ModalityEnum {
		CHAMADO("CHAMADO"),
		RONDA("RONDA"),
		OPERACAO_NOITES_FRIAS("OPERAÇÃO NOITES FRIAS"),
		BUSCA_ATIVA("BUSCA ATIVA"),
		ACAO_CONJUNTA("AÇÃO CONJUNTA");

		private String nomenclatura;

		ModalityEnum(String nomenclatura) {
				this.nomenclatura = nomenclatura;
		}

		public String getNomenclatura() {
				return nomenclatura;
		}
}
