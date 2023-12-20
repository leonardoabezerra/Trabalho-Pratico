package codigo;

import codigo.modelos.Cliente;
import codigo.modelos.OrdemServico;


public class Cadastro {

      // Cadastro do cliente
    static Cliente[] cliente = new Cliente[0];

     static void cadastrarCliente(Cliente temp) {  // Adicionar no array de clientes
        Cliente tempC[] = new Cliente[cliente.length+1];
        for (int i = 0; i < cliente.length; i++) {
            tempC[i] = cliente[i];
        }

        tempC[cliente.length] = temp;
        cliente = tempC;
    }

      // Cadastro da Ordem de Serviço
    static OrdemServico[] ordemServico = new OrdemServico[0];

     static void cadastrarOrdemServico(OrdemServico temp) {  // adicionar no array de OS
        OrdemServico tempO[] = new OrdemServico[ordemServico.length+1];
        for (int i = 0; i < ordemServico.length; i++) {
            tempO[i] = ordemServico[i];
        }

        tempO[ordemServico.length] = temp;
        ordemServico = tempO;

    }
}
