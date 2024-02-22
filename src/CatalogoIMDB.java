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

    public Filme cadastrarFilme(String nome, LocalDate dataDeLancamento, Double orcamento, String descricao) {
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
            return null;
        }

        Filme filme = new Filme(nome, dataDeLancamento, orcamento, descricao);
        this.filmes.add(filme);

        return filme;
    }

    public Filme cadastrarFilme(String nome, LocalDate dataDeLancamento, Double orcamento, String descricao, String diretorNome, String diretorArea, ArrayList<Ator> atores) {
        Filme filme = this.cadastrarFilme(nome, dataDeLancamento, orcamento, descricao);

        if (filme != null) {
            Diretor diretor = this.cadastrarDiretor(diretorNome, diretorArea);
            if (diretor != null) {
                this.associaDiretorAFilme(filme, diretor);
            }

            for (Ator ator : atores) {
                Ator atorCadastrado = this.cadastrarAtor(ator.getNome(), ator.getCpf());

                if (atorCadastrado != null) {
                    this.associarAtorAFilme(filme, atorCadastrado);
                }
            }
        }

        return filme;
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

    public Diretor cadastrarDiretor(String nome, String area) {
        boolean dadosSaoValidos =
                Validacao.campoEhValido(nome) &&
                        Validacao.campoEhValido(area);

        if (!dadosSaoValidos) {
            throw new IllegalArgumentException("Dados inválidos, não foi possível cadastrar um novo diretor!");
        }

        Diretor diretorBuscado = this.buscarDiretor(new Diretor(nome, area));

        if (diretorBuscado != null) {
            System.out.println("Diretor já cadastrado!");
            return diretorBuscado;
        }

        Diretor diretor = new Diretor(nome, area);
        this.diretores.add(diretor);

        return diretor;
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

    public Ator cadastrarAtor(String nome, String cpf) {
        if (!Validacao.validarDados(nome, cpf)) {
            throw new IllegalArgumentException("Dados inválidos!");
        }

        Ator atorBuscado = this.buscarAtor(new Ator(nome, cpf));

        if (atorBuscado != null) {
            System.out.println("Ator já cadastrado!");
            return atorBuscado;
        }

        Ator ator = new Ator(nome, cpf);
        this.atores.add(ator);

        return ator;
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
        final StringBuilder sb = new StringBuilder("\n============== CatalogoIMDB ==============");
        sb.append("\n");
        sb.append("\nFilmes:");
        for(Filme filme: filmes){
            sb.append("\n\tNome: ").append(filme.getNome());
            sb.append("\n\tLançamento: ").append(filme.getDataDeLancamento());
            sb.append("\n\tDiretor: ").append(filme.getDiretor());
            sb.append("\n\tAtores: ");
            for(Ator ator: filme.getAtores()){
                sb.append("\n\t\t").append(ator.getNome());
            }
            sb.append("\n\t===========================\n");
        }
        sb.append("\n==========================================\n");
        return sb.toString();
    }
}
