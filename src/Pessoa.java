import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
    private final String nome;


    public Pessoa(String nome, LocalDate dataNascimento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(nome, pessoa.nome);
    }
}