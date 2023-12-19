package codigo.modelos;

public class Veiculo {
      // Declaração de atributos
    private String marca, cor, modelo;
    private int anoModelo, anoFabricacao, combustivel;
    private float quilometragem;

      // Relatorio para mostrar informações do veículo para o usuário
    public String relatorio() {
        String resposta = "";
        resposta += "**** DADOS DO VEÍCULO ****\n";
        resposta += "MARCA: " + marca + "\n";
        resposta += "COR: " + cor + "\n";
        resposta += "MODELO: " + modelo + "\n";
        resposta += "ANO DO MODELO: " + anoModelo + "\n";
        resposta += "ANO DE FABRICAÇÃO: " + anoFabricacao + "\n";
        resposta += "NÍVEL DE COMBUSTÍVEL: " + combustivel + "%\n";
        resposta += "QUILOMETRAGEM ATUAL: " + quilometragem + "\n";

        return resposta;
    }

      // Construtor
    public Veiculo(String marca, String cor, String modelo, int anoModelo, int anoFabricacao, int combustivel, float quilometragem) {
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.combustivel = combustivel;
        this.quilometragem = quilometragem;
    }

      
    
}
