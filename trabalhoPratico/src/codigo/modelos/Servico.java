package codigo.modelos;

  // Serviços a serem realizados

public class Servico extends Item {
      // Declaração de atributos únicos
    private float horas;
      // Construtor
    public Servico(String descricao, String codigo, float preco, float horas) {
        super(descricao, codigo, preco);  // Herda os atributos de Item
        this.horas = horas;
    }

      // Relatório para organizar informações para mostrar para o usuário (Implementação de metodo da superclasse)
    public String relatorio() {
        String resposta = "";  // Herda informações de Item
        resposta += "Descrição: " + descricao + "\n";
        resposta += "Código: " + codigo + "\n";
        resposta += "Preço: " + preco + "\n";
        resposta += "TEMPO NECESSÁRIO: " + horas +
                    "\nTIPO: SERVIÇO\n";

        return resposta;
     }


}
