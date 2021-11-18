package Model;

public class Produto {
    private String nome;
    private int ID;
    private Double valor;

    public Produto() {
    }

    public Produto(String nome, int ID, Double valor) {
        this.nome = nome;
        this.ID = ID;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", ID=" + ID +
                ", valor=" + valor +
                '}';
    }
}
