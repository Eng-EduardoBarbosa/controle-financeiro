public class Lancamento {

    private int id;
    private String descricao;
    private double valor;
    private String tipo;

    public Lancamento(int id, String descricao, double valor, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}