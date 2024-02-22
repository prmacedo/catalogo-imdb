import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        Ator ator1 = new Ator("Rafael", "1234567890");
        Ator ator2 = new Ator("Paulo", "1234567890");
        Ator ator3 = new Ator("Luiz", "1234567890");
        Diretor diretor1 = new Diretor("Stevão Espilber", "Ecletico");
        Filme et = new Filme("Et, O Extra-Terrestre", LocalDate.of(1982, 01, 01));
        CatalogoIMDB catalogo = new CatalogoIMDB();

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