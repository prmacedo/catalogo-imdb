import utils.Validacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    private Filme buscarFilme(String nome, LocalDate dataDeLancamento) {
        Filme filmeBuscado = new Filme(nome, dataDeLancamento);

        for (Filme filme : this.filmes) {
            if (filme.equals(filmeBuscado)) {
                return filme;
            }
        }

        return null;
    }

    public ArrayList<Filme> buscarFilmes (String nome) {
        ArrayList<Filme> filmes = new ArrayList<>();
        for (Filme filme : this.filmes) {
            if (filme.getNome().toLowerCase().contains(nome.toLowerCase().trim())) {
                filmes.add(filme);
            }
        }
        return filmes;
    }
  
    public void cadastrarDiretor(String nome, String area){
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

    public Ator buscarAtor(String nome, String cpf){
        Ator atorBuscado = new Ator(nome, cpf);
        for(Ator ator : this.atores){
            if(ator.equals(atorBuscado)){
                return ator;
            }
        }
        return null;
    }

    public void cadastrarAtor(String nome, String cpf){
        if(!Validacao.validarDados(nome,cpf)){
            throw new IllegalArgumentException("Dados inválidos!");
        }
        boolean atorExiste = this.buscarAtor(nome,cpf) != null;

        if(atorExiste){
            System.out.println("Ator já cadastrado!");
        }

        Ator ator = new Ator(nome,cpf);
        this.atores.add(ator);
    }
}
