import java.time.LocalDate;
import java.util.ArrayList;

public class Diretor extends Pessoa {
    private int numeroFilmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, int numeroFilmesDirigidos) {
        super(nome, dataNascimento);
        this.numeroFilmesDirigidos = numeroFilmesDirigidos;
    }

    public int getNumeroFilmesDirigidos() {
        return numeroFilmesDirigidos;
    }

    public void setNumeroFilmesDirigidos(int numeroFilmesDirigidos) {
        this.numeroFilmesDirigidos = numeroFilmesDirigidos;
    }

    public static Diretor buscarDiretor(ArrayList<Diretor> diretores, String nomeDiretor) {
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nomeDiretor)) {
                return diretor;
            }
        }
        return null;
    }

    public static void cadastrarDiretor(ArrayList<Diretor> diretores, Diretor diretor) {
        diretores.add(diretor);
    }
}
