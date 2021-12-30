package btg.testetecnico.api.cliente;

import lombok.Getter;

@Getter
public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");

	private final String description;

	Sexo(String description) {
		this.description = description;
	}

	public static Sexo getSexo(String descricao) {
		for (Sexo sexo : Sexo.values()) {
			if (sexo.getDescription().equals(descricao)) {
				return sexo;
			}
		}
		return null;
	}
}
