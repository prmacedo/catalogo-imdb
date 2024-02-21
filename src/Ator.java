import java.util.Objects;

public class Ator extends Pessoa{

    private String cpf;

    public Ator(String nome, String cpf){
        super(nome);
        this.cpf = cpf;

    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }
    @Override
    public int hashCode(){
        return Objects.hash(nome,cpf);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Ator)) {
            return false;
        }
        Ator ator = (Ator) o;

        return this.getNome().equals(ator.getNome()) && this.getCpf().equals(ator.getCpf());
    }

    @Override
    public String toString() {
        return "Ator{" +
                "nome='" + nome + '\'' +
                '}';
    }
}