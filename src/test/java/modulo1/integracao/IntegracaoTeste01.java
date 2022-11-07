package modulo1.integracao;

import modulo1.*;
import modulo3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.*;

public class IntegracaoTeste01 {
    // Victoria Tests:
    @Test
    public void getEstudantesByPeriodo() {
        Estudante estudante = Mockito.mock(Estudante.class);
        Mockito.when(estudante.findByPeriodo(2)).thenReturn(Arrays.asList("Maria Victória", "Katarina", "Arthur"));
        List<String> estudantes = estudante.findByPeriodo(1);
        Assertions.assertFalse(estudantes.size() > 2);
    }

    @Test
    public void getEstudantesByPeriodoverifyTrue(){
        Estudante estudante = Mockito.mock(Estudante.class);
        Mockito.when(estudante.findByPeriodo(1)).thenReturn(Arrays.asList("Maria Victória", "Katarina", "Arthur"));
        List<String> estudantes = estudante.findByPeriodo(1);
        Assertions.assertTrue(estudantes.size()>2);
        Mockito.verify(estudante).findByPeriodo(1);
    }

    @Test
    public void getEstudantesByPeriodoverifyFalse(){
        Estudante estudante = Mockito.mock(Estudante.class);
        Mockito.when(estudante.findByPeriodo(2)).thenReturn(Arrays.asList("Maria Victória", "Katarina", "Arthur"));
        List<String> estudantes = estudante.findByPeriodo(1);
        Assertions.assertFalse(estudantes.size()>2);
        Mockito.verify(estudante).findByPeriodo(1);
    }

    @Test
    public void InsertEstudante(){
        Estudante estudante = Mockito.mock(Estudante.class);
        List<Estudante> estudantes = Arrays.asList(new Estudante());
        Mockito.when(estudante.insertEstudantes(estudantes)).thenReturn(true);
        Assertions.assertTrue(estudante.insertEstudantes(estudantes));
    }

    @Test
    public void InsertEstudanteverify(){
        Estudante estudante = Mockito.mock(Estudante.class);
        List<Estudante> estudantes = Arrays.asList(new Estudante());
        Mockito.when(estudante.insertEstudantes(estudantes)).thenReturn(true);
        Assertions.assertTrue(estudante.insertEstudantes(estudantes));
        Mockito.verify(estudante).insertEstudantes(estudantes);
    }

    // Ângelo Tests:
    @Test
    public void InsertEstudanteFalse(){
        Estudante estudante = Mockito.mock(Estudante.class);
        List<Estudante> estudantes = Arrays.asList(new Estudante());
        Mockito.when(estudante.insertEstudantes(estudantes)).thenReturn(false);
        Assertions.assertFalse(estudante.insertEstudantes(estudantes));
        Mockito.verify(estudante).insertEstudantes(estudantes);
    }

    @Test
    public void getBibliotecaFromBibliotecarioSucess(){
        Bibliotecario bibliotecario = Mockito.mock(Bibliotecario.class);
        Mockito.when(bibliotecario.findBibliotecaById()).thenReturn("UNICAP");
        Assertions.assertEquals("UNICAP", bibliotecario.findBibliotecaById());
        Mockito.verify(bibliotecario, Mockito.times(1)).findBibliotecaById();
    }

    @Test
    public void getBibliotecaFromBibliotecarioError(){
        Bibliotecario bibliotecario = Mockito.mock(Bibliotecario.class);
        Mockito.when(bibliotecario.findBibliotecaById()).thenReturn("UNICAP");
        Assertions.assertNotEquals("UNIBRATEC", bibliotecario.findBibliotecaById());
        Mockito.verify(bibliotecario, Mockito.atLeastOnce()).findBibliotecaById();
    }

    @Test
    public void insertFaculdadeTrue(){
        Faculdade faculdade = Mockito.mock(Faculdade.class);
        faculdade.setNome("UNICAP");
        Mockito.when(faculdade.salvarFaculdade()).thenReturn(true);
        Assertions.assertTrue(faculdade.salvarFaculdade());
        Mockito.verify(faculdade).salvarFaculdade();
    }

    @Test
    public void insertFaculdadeFalse(){
        Faculdade faculdade = Mockito.mock(Faculdade.class);
        faculdade.setNome(null);
        Mockito.when(faculdade.salvarFaculdade()).thenReturn(false);
        Assertions.assertFalse(faculdade.salvarFaculdade());
        Mockito.verify(faculdade).salvarFaculdade();
    }
}
