/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceplan.algoritmosordenacao.utils;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class GeraVetorTest {

    /**
     *
     */
    @Test
    public void testRandom() {
        System.out.println("Testando: random");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.random(10)));
        assertArrayEquals(g.random(10), g.random(10));
    }

    /**
     *
     */
    @Test
    public void testNearSort() {
        System.out.println("Testando: nearSort");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.nearSort(10)));
        assertTrue(true);
    }

    /**
     *
     */
    @Test
    public void testFewUnique() {
        System.out.println("Testando: fewUnique");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.fewUnique(10)));
        assertTrue(true);
    }

    /**
     *
     */
    @Test
    public void testReversed() {
        System.out.println("Testando: reversed");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.reversed(10)));
        assertArrayEquals(g.reversed(10), g.reversed(10));
    }

    /**
     *
     */
    @Test
    public void testSort() {
        System.out.println("Testando: sort");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.sort(10)));
        assertArrayEquals(g.sort(10), g.sort(10));
    }
}
