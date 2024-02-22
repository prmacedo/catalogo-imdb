import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        Ator ator1 = new Ator("Rafael", "1234567890");
        Ator ator2 = new Ator("Paulo", "1234567890");
        Ator ator3 = new Ator("Luiz", "1234567890");
        Diretor diretor1 = new Diretor("Stevão Espilber", "Ecletico");
        Filme et = new Filme("Et, O Extra-Terrestre", LocalDate.of(1982, 01, 01));
        CatalogoIMDB catalogo = new CatalogoIMDB();

        ArrayList<Ator> atores = new ArrayList<>();
        atores.add(ator2);
        atores.add(ator1);
        atores.add(ator3);
        atores.add(ator3);
        catalogo.cadastrarFilme("Toy Story", LocalDate.of(1994, 12, 12), 30_000_000d, "descricao qualquer", "Diretor", "Arte", atores);
        atores.remove(0);
        catalogo.cadastrarFilme("Toy Story 2", LocalDate.of(1998, 12, 12), 30_000_000d, "descricao qualquer", "Diretor", "Arte", atores);

        catalogo.cadastrarFilme("Et, O Extra-Terrestre", LocalDate.of(1982, 01, 01), 34_000_000.00, "Et de varginhaa americano dando role");
        catalogo.associaDiretorAFilme(et, diretor1);

        catalogo.cadastrarDiretor("Stevão Espilber", "Ecletico");
        catalogo.associaDiretorAFilme(et, diretor1);

        System.out.println(catalogo.buscarFilmes("Et"));
        System.out.println(catalogo);

        catalogo.cadastrarAtor("Luiz Gabriel", "2345678990-12");
        catalogo.cadastrarAtor("Paulo", "1234567890");
        catalogo.cadastrarAtor("Luiz", "1234567890");
        catalogo.associarAtorAFilme(et,ator1);
        catalogo.associarAtorAFilme(et,new Ator("Luiz Gabriel", "2345678990-12"));
        System.out.println(catalogo);

    }
}