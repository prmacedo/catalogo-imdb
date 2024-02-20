import java.util.ArrayList;

public class Diretor extends Pessoa {

    String area;

    public Diretor(String area, String nome) {
        super(nome);
        this.area = area;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
