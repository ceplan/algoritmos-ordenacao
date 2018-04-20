/*
 * Copyright 2018 Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.udesc.ceplan.jsorting.algoritmos;

import br.udesc.ceplan.jsorting.core.AbstractSort;

/**
 * <p>
 * Bogosort (também conhecido como CaseSort ou Estou com Sort), é um algoritmo
 * de ordenação extremamente ineficiente. É baseado na reordenação aleatória dos
 * elementos. Não é utilizado na prática, mas pode ser usado no ensino de
 * algorítmos mais eficientes.
 * </p>
 *
 * <p>
 * Esse algoritmo é probabilístico por natureza. Se todos os elementos a serem
 * ordenados são distintos, a complexidade esperada é O(n×n!). O tempo exato de
 * execução esperado depende do quantos diferentes valores de elementos ocorrem,
 * e quantas vezes cada um deles ocorre, mas para casos não-triviais o tempo
 * esperado de execução é exponencial ou super-exponencial a n. Ele termina pela
 * mesma razão do teorema do macaco infinito; existe alguma probabilidade de que
 * aconteça a permutação correta, dado que em um infinito número de tentativas
 * fatalmente a encontrará.
 * </p>
 *
 * <p>
 * Deve-se notar que com os algoritmos geradores de números pseudo-aleatórios,
 * que têm um número finito de estados e não são realmente aleatórios, o
 * algoritmo pode nunca terminar para certos conjuntos de valores a serem
 * ordenados.
 * </p>
 *
 * <p>
 * Bogosort é um algoritmo de ordenação não estável.
 * </p>
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class BogoSort extends AbstractSort {

    /**
     *
     * @param vetor
     */
    public BogoSort(int[] vetor) {
        super(vetor);
    }

    @Override
    public void sort() {
        // Verifica se o vetor está ordenado
        while (!isSorted(this.vetor)) {
            // Embaralha o vetor pra tentar ordenar aleatoriamente
            shuffle(this.vetor);
        }
    }

    /**
     * Verifica se o vetor está ordenado
     *
     * @param vetor
     * @return
     */
    private static boolean isSorted(int[] vetor) {
        for (int i = 0; i < (vetor.length - 1); ++i) {
            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Embaralha o vetor pra tentar ordenar aleatoriamente
     *
     * @param vetor Vetor a ser ordenado
     */
    private static void shuffle(int[] vetor) {
        for (int x = 0; x < vetor.length; ++x) {
            int index1 = (int) (Math.random() * vetor.length),
                    index2 = (int) (Math.random() * vetor.length);
            int a = vetor[index1];
            vetor[index1] = vetor[index2];
            vetor[index2] = a;
        }
    }
}
