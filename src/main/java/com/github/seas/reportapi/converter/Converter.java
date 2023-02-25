package com.github.seas.reportapi.converter;

import java.util.Objects;

public abstract class Converter <M, D> {
		public abstract M fromDto(D dto);
		public abstract D toDto(M model);
		protected boolean valideIfIsNull(Object object) {
				if (Objects.isNull(object)) {
						return true;
				} else {
						return false;
				}

		}
}
