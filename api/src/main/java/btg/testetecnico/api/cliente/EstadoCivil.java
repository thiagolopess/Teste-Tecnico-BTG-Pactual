package btg.testetecnico.api.cliente;

import lombok.Getter;

@Getter
public enum EstadoCivil {

	SOLTEIRO("Solteiro"),
	CASADO("Casado"),
	DIVORCIADO("Divorciado"),
	VIUVO("Viúvo");

	private final String description;

	EstadoCivil(String description) {
		this.description = description;
	}

	public static EstadoCivil getEstadoCivil(String descricao) {
		for (EstadoCivil estadoCivil : EstadoCivil.values()) {
			if (estadoCivil.getDescription().equals(descricao)) {
				return estadoCivil;
			}
		}
		return null;
	}

}
