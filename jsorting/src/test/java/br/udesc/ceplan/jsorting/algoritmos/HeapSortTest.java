/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceplan.jsorting.algoritmos;

import br.udesc.ceplan.jsorting.utils.GeraVetor;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {

    /**
     *
     * @author Marcelo Wischniowski <marcelowisc at gmail.com>
     */
    @Test
    public void HeapSortTest() {
        GeraVetor geraVetor = new GeraVetor();

        // Crio um novo vetor
        int[] vetor = geraVetor.random(10);

        // Faço uma cópia dele
        int[] experado = Arrays.copyOf(vetor, vetor.length);

        // Ordeno a cópia com uma ordenação do Java
        Arrays.sort(experado);

        // Testo o HeapSort
        HeapSort heapSort = new HeapSort(vetor);
        heapSort.sort();

        System.out.println("HeapSort: " + heapSort.toString());
        System.out.println("Experado: " + Arrays.toString(experado));

        Assert.assertArrayEquals(experado, heapSort.get());
    }
}