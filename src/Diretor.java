import pessoa.Pessoa;

import java.util.Objects;

public class Diretor extends Pessoa {

    private String area;

    public Diretor( String nome, String area) {
        super(nome);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.area + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Diretor)) {
            return false;
        }
        Diretor diretor = (Diretor) o;

        return this.getNome().equals(diretor.getNome()) && this.getArea().equals(diretor.getArea());

    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, area);
    }
}
