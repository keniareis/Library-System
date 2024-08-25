package org.example.controller;

import org.example.model.Membro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MembroControllerTest {
    private MembroController controller;

    @BeforeEach
    void setUp(){
        controller = new MembroController();
    }

    @Test
    void testAddMembro(){
        Membro membro = new Membro("João Silva", "12345678900", "11912345678", "São Paulo, SP");
        controller.membros.add(membro);

        assertEquals(1, controller.getMembros().size());
        assertEquals("João Silva", controller.getMembros().get(0).getNome());
    }

    @Test
    void testBuscarMembro(){
        Membro membro = new Membro("Maria Souza", "12345678900", "11912345699", "São Paulo, SP");
        controller.membros.add(membro);

        Membro foundMembro = controller.buscarMembro("Maria Souza");

        assertNotNull(foundMembro);
        assertEquals("Maria Souza", foundMembro.getNome());
    }

    //UpdateMember


    @Test
    void testRemoverMembro(){
        Membro membro = new Membro("Ana Pereira", "55566677788", "41955556666", "Curitiba, PR");
        controller.membros.add(membro);

        controller.removerMembro("Ana Pereira");

        Membro removido = controller.buscarMembro("Ana Pereira");
        assertNull(removido);
    }

    @Test
    void testVerMembros(){
        Membro membro1 = new Membro("Lucas Lima", "22233344455", "61933334444", "Brasília, DF");
        Membro membro2 = new Membro("Mariana Santos", "77788899900", "71977778888", "Salvador, BA");

        controller.membros.add(membro1);
        controller.membros.add(membro2);

        List<Membro> membros = controller.membros;

        assertEquals(2, membros.size());
        assertTrue(membros.contains(membro1));
        assertTrue(membros.contains(membro2));
    }
}
