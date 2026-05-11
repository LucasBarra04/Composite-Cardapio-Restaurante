package Classes;

public abstract class ItemCardapio {
    private String descricao;

    public String getDescricao()              { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public abstract String getConteudo();
}