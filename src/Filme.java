import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Filme {
    private String nome;
    private LocalDate dataDeLancamento;
    private Double orcamento;
    private String descricao;
    private Diretor diretor;
    private ArrayList<Ator> atores;

    public Filme(String nome, LocalDate dataDeLancamento, Double orcamento, String descricao, Diretor diretor, ArrayList<Ator> atores) {
        this(nome, dataDeLancamento, orcamento, descricao);
        this.diretor = diretor;
        this.atores = atores;
    }

    public Filme(String nome, LocalDate dataDeLancamento, Double orcamento, String descricao) {
        this(nome, dataDeLancamento);
        this.orcamento = orcamento;
        this.descricao = descricao;
    }

    public Filme(String nome, LocalDate dataDeLancamento) {
        this.atores = new ArrayList<>();
        this.nome = nome.trim();
        this.dataDeLancamento = dataDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public ArrayList<Ator> getAtores() {
        return atores;
    }

    public void setAtores(ArrayList<Ator> atores) {
        this.atores = atores;
    }

    public void adicionarAtor (Ator ator) {
        if (!this.atores.contains(ator)) {
            this.atores.add(ator);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nFilme =========================");
            sb.append("\n\tNome: ").append(nome);
            sb.append("\n\tLancamento: ").append(dataDeLancamento);
            sb.append("\n\tOrcamento: ").append(String.format("%.2f", orcamento));
            sb.append("\n\tDiretor: ").append(diretor);
            sb.append("\n\tAtores: ");
            for(Ator ator: atores){
                sb.append("\n\t\t").append(ator.getNome());
            }

        sb.append("\n===============================\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filme filme)) return false;
        return Objects.equals(nome, filme.nome) &&
                Objects.equals(dataDeLancamento, filme.dataDeLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataDeLancamento);
    }
}
