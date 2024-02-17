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
}
