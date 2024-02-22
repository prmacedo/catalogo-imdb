import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        Pessoa ator1 = new Ator("Rafael", "1234567890");
        Diretor diretor1 = new Diretor("Stevão Espilber", "Ecletico");
        Filme et = new Filme("Et, O Extra-Terrestre", LocalDate.of(1982, 01, 01));
        CatalogoIMDB catalogo = new CatalogoIMDB();

        catalogo.cadastrarFilme("Et, O Extra-Terrestre", LocalDate.of(1982, 01, 01), 34_000_000.00, "Et de varginhaa americano dando role");
        catalogo.associaDiretorAFilme(et, diretor1);

        catalogo.cadastrarDiretor("Stevão Espilber", "Ecletico");
        catalogo.associaDiretorAFilme(et, diretor1);

        System.out.println(catalogo.buscarFilmes("Et"));
        System.out.println(catalogo);
    }
}