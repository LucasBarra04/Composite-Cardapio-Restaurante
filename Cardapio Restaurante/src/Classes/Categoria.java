package Classes;

import java.util.ArrayList;
import java.util.List;

public class Categoria extends ItemCardapio {
    private List<ItemCardapio> itens = new ArrayList<>();

    public void addItem(ItemCardapio item) {
        itens.add(item);
    }

    @Override
    public String getConteudo() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(getDescricao()).append("]\n");
        for (ItemCardapio item : itens) {
            sb.append(item.getConteudo()).append("\n");
        }
        return sb.toString();
    }
}