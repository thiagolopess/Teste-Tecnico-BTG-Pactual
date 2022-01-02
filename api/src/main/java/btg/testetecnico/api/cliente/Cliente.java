package btg.testetecnico.api.cliente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table
public class Cliente {
	public Cliente() {
	}

	@Id
	@Size(min = 11, max = 11, message = "O CPF deve conter 11 caracteres")
	private String cpf;

	@Column
	@NotNull(message = "O Nome não pode ser nulo")
	private String nomeCompleto;

	@Column
	@NotNull(message = "A Data de nascimento é obrigatória")
	private LocalDate dtNascimento;

	@Transient
	private int idade;

	@Column(columnDefinition = "ENUM('MASCULINO', 'FEMININO')")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O sexo é obrigatório")
	private Sexo sexo;

	@Column(columnDefinition = "ENUM('SOLTEIRO', 'CASADO', 'DIVORCIADO', 'VIUVO')")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O estado civil é obrigatório")
	private EstadoCivil estadoCivil;

	@Column(unique = true)
	@NotNull(message = "O campo Email é obrigatório")
	@Email(message = "O email deve ser válido")
	private String email;

	@Column(unique = true)
	@NotNull
	@Size(min = 11, max = 11, message = "O celular deve conter 11 caracteres (DDD + número)")
	private String celular;

	@Column
	@NotNull (message = "O CEP é obrigatório")
	private String cep;

	@Column
	@NotNull (message = "O logradouro é obrigatório")
	private String logradouro;

	@Column
	@NotNull(message = "O bairro é obrigatório")
	private String bairro;

	@Column
	@NotNull(message = "O número do endereço é obrigatório")
	private int numero;

	@Column
	private String complemento;

	@Column
	@NotNull
	@Size(min = 2, max = 2, message = "Preencha o campo Estado com a sigla do Estado de residência")
	private String estado;

	@Column
	@NotNull(message = "A cidade é obrigatória")
	private String cidade;

	public int getIdade() {
		return Period.between(this.dtNascimento, LocalDate.now()).getYears();
	}
}
