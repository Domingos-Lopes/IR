package Test;

import Entities.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    Pessoa pessoa;

    @BeforeEach
    void setUp(){
        pessoa = new Pessoa("Carlos", "123456", 5000, 140);
    }

    @Test
    void getNome() {
        String nome = pessoa.getNome();
        assertEquals("Carlos", nome);
    }

    @Test
    void getCpf() {
        String cpf = pessoa.getCpf();
        assertEquals("123456", cpf);
    }


    @Test
    void getTotalRendimentos() {
        double rendimentos = pessoa.getTotalRendimentos();
        double dif = rendimentos - pessoa.getTotalRendimentos();
        assertTrue(Math.abs(dif) < 1.0);
    }


    @Test
    void getContribuicaoPrevidenciaria() {
        double contribuicao = pessoa.getContribuicaoPrevidenciaria();
        double dif = contribuicao - pessoa.getContribuicaoPrevidenciaria();
        assertTrue(Math.abs(dif) < 1.0);
    }
}