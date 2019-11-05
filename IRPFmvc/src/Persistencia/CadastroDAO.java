package Persistencia;

import Negocio.Contribuinte;

import java.util.List;

public interface CadastroDAO {

    void salvarContribuinte(Contribuinte c, double desconto, double imposto);

    List<Contribuinte> getTodos();
}