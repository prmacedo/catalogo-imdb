import org.w3c.dom.ls.LSOutput;
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

        boolean filmeExiste = this.buscarFilme(new Filme(nome, dataDeLancamento)) != null;

        if (filmeExiste) {
            System.out.println("Filme já cadastrado!");
            return;
        }

        Filme filme = new Filme(nome, dataDeLancamento, orcamento, descricao);
        this.filmes.add(filme);
    }

    private Filme buscarFilme(Filme filme) {

        for (Filme filmeAtual : this.filmes) {
            if (filmeAtual.equals(filme)) {
                return filmeAtual;
            }
        }

        return null;
    }

    public ArrayList<Filme> buscarFilmes(String nome) {
        ArrayList<Filme> filmes = new ArrayList<>();
        for (Filme filme : this.filmes) {
            if (filme.getNome().toLowerCase().contains(nome.toLowerCase().trim())) {
                filmes.add(filme);
            }
        }
        return filmes;
    }

    public void cadastrarDiretor(String nome, String area) {
        boolean dadosSaoValidos =
                Validacao.campoEhValido(nome) &&
                        Validacao.campoEhValido(area);

        if (!dadosSaoValidos) {
            throw new IllegalArgumentException("Dados inválidos, não foi possível cadastrar um novo diretor!");
        }

        boolean diretorExiste = this.buscarDiretor(new Diretor(nome, area)) != null;

        if (diretorExiste) {
            System.out.println("Diretor já cadastrado!");
            return;
        }

        Diretor diretor = new Diretor(nome, area);
        this.diretores.add(diretor);
    }

    private Diretor buscarDiretor(Diretor diretor) {
        for (Diretor diretorAtual : this.diretores) {
            if (diretorAtual.equals(diretor)) {
                return diretorAtual;
            }
        }
        return null;
    }

    private Ator buscarAtor(Ator ator) {
        for (Ator atorAtual : this.atores) {
            if (atorAtual.equals(ator)) {
                return atorAtual;
            }
        }
        return null;
    }

    public void cadastrarAtor(String nome, String cpf) {
        if (!Validacao.validarDados(nome, cpf)) {
            throw new IllegalArgumentException("Dados inválidos!");
        }

        boolean atorExiste = this.buscarAtor(new Ator(nome, cpf)) != null;

        if (atorExiste) {
            System.out.println("Ator já cadastrado!");
        }

        Ator ator = new Ator(nome, cpf);
        this.atores.add(ator);
    }

    public void associaDiretorAFilme(Filme filmeAAssociar, Diretor diretorAAssociar) {
        Filme filmeBuscado = buscarFilme(filmeAAssociar);
        Diretor diretorBuscado = buscarDiretor(diretorAAssociar);

        if (filmeBuscado != null && diretorBuscado != null) {
            filmeBuscado.setDiretor(diretorBuscado);
        } else {
            System.out.println("Não há Filme ou Diretor com esses dados!!!");
        }
    }

    public void associarAtorAFilme(Filme filmeAAssociar, Ator atorAAssociar) {
        Filme filmeBuscado = buscarFilme(filmeAAssociar);
        Ator atorBuscado = buscarAtor(atorAAssociar);

        if (filmeBuscado != null && atorBuscado != null) {
            filmeBuscado.adicionarAtor(atorBuscado);
        } else {
            System.out.println("Não há Filme ou Ator com esses dados!!!");
        }
    }

    @Override
    public String toString() {
        return "CatalogoIMDB" +
                "\nfilmes=" + filmes +
                "\natores=" + atores +
                "\ndiretores=" + diretores;
    }
}
