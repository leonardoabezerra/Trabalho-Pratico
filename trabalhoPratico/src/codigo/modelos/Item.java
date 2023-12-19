package codigo.modelos;

  // Classe de Itens que somam ao preço total da ordem de serviço

abstract public class Item {
      // Declaração dos atributos
    public String descricao, codigo;
    public float preco;

      // Construtor
    public Item(String descricao, String codigo, float preco) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.preco = preco;
    }

      // Relatório para organizar informações do item para mostrar ao usuário
    public abstract String relatorio();

      // Metodos de get/set
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
