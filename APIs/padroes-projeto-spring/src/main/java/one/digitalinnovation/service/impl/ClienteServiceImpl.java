package one.digitalinnovation.service.impl;

import one.digitalinnovation.model.Cliente;
import one.digitalinnovation.model.ClienteRepository;
import one.digitalinnovation.model.Endereco;
import one.digitalinnovation.model.EnderecoRepository;
import one.digitalinnovation.service.ClienteService;
import one.digitalinnovation.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do spring com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na Interface
    // Facade : Abstrair integrações com subsistemas, provendo uma interface simples

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar cliente por Id.
        // Optional porque o cliente pode ou não existir.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        // Verificar se o Endereço do Ciente já existe (pelo Cep).
        salvarClienteComCep(cliente);
    }


    @Override
    public void atualizar(Cliente cliente, Long id) {
        // Buscar Cliente por Id
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Cliente por Id.
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereço do Ciente já existe (pelo Cep).
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com ViaCep e persistir retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);

        //Inserir o Cliente, vinculando o endereço (novo ou existente)
        clienteRepository.save(cliente);
    }
}
