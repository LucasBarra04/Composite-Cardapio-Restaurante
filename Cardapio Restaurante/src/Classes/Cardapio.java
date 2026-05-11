package Classes;

public class Cardapio {
    private ItemCardapio ementa;

    public void setEmenta(ItemCardapio ementa) {
        this.ementa = ementa;
    }

    public String getEmenta() {
        return ementa.getConteudo();
    }
}