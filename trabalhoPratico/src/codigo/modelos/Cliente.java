package codigo.modelos;

import javax.swing.JOptionPane;

public class Cliente {
      // Declaração de atributos
    private String nome, contato, cpf;

      // Construtor
    public Cliente(String nome, String contato, String cpf) {
        this.nome = nome;
        this.contato = contato;  // email/telefone
        this.cpf = cpf;
    }

      // Relatorio para mostrar dados do cliente ao usuário
    public String relatorio() {
        String resposta = "";
        resposta += "**** DADOS DO CLIENTE ****\n"; 
        resposta += "NOME: " + nome + "\n";
        resposta += "CONTATO: " + contato + "\n";
        resposta += "CPF: " + cpf + "\n";

        return resposta;
    }

      // Método para realizar cadastro do veículo do cliente
    static Veiculo[] veiculo = new Veiculo[0];

    public static void cadastrarVeiculo() {
          // Obter dados do veículo
        String marca = JOptionPane.showInputDialog("Informe a marca do veículo");
        String cor = JOptionPane.showInputDialog("Informe a cor do veículo");
        String modelo = JOptionPane.showInputDialog("Informe o modelo do veículo");
        String stranoModelo = JOptionPane.showInputDialog("Informe o ano do modelo");
        String stranoFabricacao = JOptionPane.showInputDialog("Informe o ano de fabricação do veículo");
        String strcombustivel = JOptionPane.showInputDialog("Informe o nível de combustível do veículo, em porcentagem");
        String strquilometragem = JOptionPane.showInputDialog("Informe o valor da quilometragem atual");

        int anoModelo = Integer.parseInt(stranoModelo);  // String --> int
        int anoFabricacao = Integer.parseInt(stranoFabricacao);
        int combustivel = Integer.parseInt(strcombustivel);
        float quilometragem = Float.parseFloat(strquilometragem);  // String --> float

        Veiculo tempVeiculo = new Veiculo(marca, cor, modelo, anoModelo, anoFabricacao, combustivel, quilometragem);  // Referencia temporaria para segurar os dados do veiculo

          // Adicionar novo veiculo no array de veiculos
        Veiculo tempV[] = new Veiculo[veiculo.length+1];
        for (int i = 0; i < veiculo.length; i++) {
        tempV[i] = veiculo[i];
        }

        tempV[veiculo.length] = tempVeiculo;
        veiculo = tempV;

    }

    public static String getVeiculo(int i) {
        return veiculo[i].relatorio();
    }

}
