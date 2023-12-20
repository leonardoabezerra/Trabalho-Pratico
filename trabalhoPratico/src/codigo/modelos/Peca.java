package codigo.modelos;

  // Peças a serem substituidas

public class Peca extends Item{
      // Declaração dos atributos únicos
    private String marca, unidade;

      // Construtor
    public Peca(String descricao, String codigo, float preco, String marca, String unidade) {
        super(descricao, codigo, preco);  // Herda os atributos de Item
        this.marca = marca;
        this.unidade = unidade;
    }

      // Relatório para organizar informações para mostrar ao usuário (Implementação do metodo da superclasse)
    public String relatorio() {
        String resposta = relatorio();  // Herda informações de Item
        resposta += "MARCA: " + marca + "\n";
        resposta += "UNIDADE: " + unidade + 
                    "\nTIPO: PEÇA\n";

        return resposta;
    }

}
