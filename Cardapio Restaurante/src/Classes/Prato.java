package Classes;

public class Prato extends ItemCardapio {
    private double preco;

    public double getPreco()         { return preco; }
    public void setPreco(double p)   { this.preco = p; }

    @Override
    public String getConteudo() {
        return "   - " + getDescricao() + " R$" + preco;
    }
}