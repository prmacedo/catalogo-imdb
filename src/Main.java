public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");


        Pessoa ator = new Ator("Rafael","1234567890");

        CatalogoIMDB catalogo = new CatalogoIMDB();

        catalogo.cadastrarAtor(null,"123456789");

        System.out.println(ator.nome);
    }
}