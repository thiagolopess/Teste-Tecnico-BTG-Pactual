package btg.testetecnico.api.movimentacao;

import lombok.Getter;

@Getter
public enum TipoMovimentacao {
	DEPOSITO("Depósito"),
	SAQUE("Saque");

	private final String description;

	TipoMovimentacao(String description) {
		this.description = description;
	}

	public static TipoMovimentacao getTipoMovimentacao(String descricao) {
		for (TipoMovimentacao estadoCivil : TipoMovimentacao.values()) {
			if (estadoCivil.getDescription().equals(descricao)) {
				return estadoCivil;
			}
		}
		return null;
	}
}
