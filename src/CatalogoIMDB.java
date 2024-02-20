import utils.Validacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CatalogoIMDB {
    private List<Filme> filmes;
    private List<Ator> atores;
    private List<Diretor> diretores;

    public CatalogoIMDB() {
        this.filmes = new ArrayList<Filme>();
        this.atores = new ArrayList<Ator>();
        this.diretores = new ArrayList<Diretor>();
    }

    public void cadastrarFilme(String nome, LocalDate dataDeLancamento, Double orcamento, String descricao) {
        boolean dadosSaoValidos =
                Validacao.campoEhValido(nome) &&
                Validacao.campoEhValido(dataDeLancamento) &&
                Validacao.campoEhValido(orcamento) &&
                Validacao.campoEhValido(descricao);

        if (!dadosSaoValidos) {
            throw new IllegalArgumentException("Dados inválidos, não foi possível cadastrar um novo filme!");
        }

        boolean filmeExiste = this.buscarFilme(nome, dataDeLancamento) != null;

        if (filmeExiste) {
            System.out.println("Filme já cadastrado!");
            return;
        }

        Filme filme = new Filme(nome, dataDeLancamento, orcamento, descricao);
        this.filmes.add(filme);
    }

    public void cadastrarDiretor( String nome, String area){
        boolean dadosSaoValidos =
                Validacao.campoEhValido(nome) &&
                        Validacao.campoEhValido(area);

        if (!dadosSaoValidos) {
            throw new IllegalArgumentException("Dados inválidos, não foi possível cadastrar um novo diretor!");
        }

        boolean diretorExiste = this.buscarDiretor(nome, area) != null;

        if (diretorExiste) {
            System.out.println("Diretor já cadastrado!");
            return;
        }

        Diretor diretor = new Diretor(nome, area);
        this.diretores.add(diretor);
    }

    public Diretor buscarDiretor(String nome, String area){
        Diretor diretorBuscado = new Diretor(nome, area);

        for(Diretor diretor: this.diretores){
            if(diretor.equals(diretorBuscado)){
                return diretor;
            }
        }
        return null;
    }

    public Filme buscarFilme(String nome, LocalDate dataDeLancamento) {
        Filme filmeBuscado = new Filme(nome, dataDeLancamento);

        for (Filme filme : this.filmes) {
            if (filme.equals(filmeBuscado)) {
                return filme;
            }
        }

        return null;
    }
}
