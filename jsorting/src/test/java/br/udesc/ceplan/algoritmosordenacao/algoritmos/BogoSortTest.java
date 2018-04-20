/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceplan.algoritmosordenacao.algoritmos;

import br.udesc.ceplan.algoritmosordenacao.utils.GeraVetor;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class BogoSortTest {

    /**
     *
     */
    @Test
    public void testBogoSort() {
        GeraVetor geraVetor = new GeraVetor();

        // Crio um novo vetor
        int[] vetor = geraVetor.random(10);

        // Faço uma cópia dele
        int[] experado = Arrays.copyOf(vetor, vetor.length);

        // Ordeno a cópia com uma ordenação do Java
        Arrays.sort(experado);

        // Testo o BogoSort
        BogoSort bogoSort = new BogoSort(vetor);
        bogoSort.sort();

        System.out.println("BogoSort: " + bogoSort.toString());
        System.out.println("Experado: " + Arrays.toString(experado));

        Assert.assertArrayEquals(experado, bogoSort.get());
    }
}
