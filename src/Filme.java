import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Filme {
    private String nome;
    private Date dataDeLancamento;
    private Double orcamento;
    private String descricao;
    private Diretor diretor;
    private ArrayList<Ator> atores;

    public Filme(String nome, Date dataDeLancamento, Double orcamento, String descricao, Diretor diretor, ArrayList<Ator> atores) {
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = atores;
    }

    public Filme(String nome, Date dataDeLancamento, Double orcamento, String descricao) {
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(Date dataDeLancamento) {
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

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dataDeLancamento=" + dataDeLancamento +
                ", orcamento=" + orcamento +
                ", descricao='" + descricao + '\'' +
                ", diretor=" + diretor +
                ", atores=" + atores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filme filme)) return false;
        return Objects.equals(nome, filme.nome) &&
                Objects.equals(dataDeLancamento, filme.dataDeLancamento) &&
                Objects.equals(orcamento, filme.orcamento) &&
                Objects.equals(descricao, filme.descricao) &&
                Objects.equals(diretor, filme.diretor) &&
                Objects.equals(atores, filme.atores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataDeLancamento, orcamento, descricao, diretor, atores);
    }
}
