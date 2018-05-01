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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Bucket sort, ou bin sort, é um algoritmo de ordenação que funciona dividindo
 * um vetor em um número finito de recipientes. Cada recipiente é então ordenado
 * individualmente, seja usando um algoritmo de ordenação diferente, ou usando o
 * algoritmo bucket sort recursivamente. O bucket sort tem complexidade linear
 * (Θ(n)) quando o vetor a ser ordenado contém valores que são uniformemente
 * distribuídos.</p>
 * <p>
 * Bucket sort funciona do seguinte modo:</p>
 *
 * <ol>
 * <li>Inicialize um vetor de "baldes", inicialmente vazios.</li>
 * <li>Vá para o vetor original, incluindo cada elemento em um balde.</li>
 * <li>Ordene todos os baldes não vazios.</li>
 * <li>Coloque os elementos dos baldes que não estão vazios no vetor
 * original.</li>
 * </ol>
 *
 * <p>
 * complexidade pior caso: O(n^{2})</p>
 * <p>
 * complexidade caso médio	{\displaystyle O(n+k)} </p>
 * <p>
 * complexidade melhor caso	{\displaystyle O(n+k)} </p>
 *
 * @author Marcelo Wischniowski <marcelowisc at gmail.com>
 */
public class BucketSort extends AbstractSort {

    /**
     * Construtor
     *
     * @param vetor Vetor que será ordenado
     */
    public BucketSort(int[] vetor) {
        super(vetor);
    }

    /**
     * Aplica a ordenação BucketSort no vetor
     */
    @Override
    public void sort() {

        final int[] code = hash(this.vetor);
       
        // criar e inicializa buckets
        List<Integer>[] buckets = new List[code[1]];
        for (int i = 0; i < code[1]; i++) {
            buckets[i] = new ArrayList<>();
        }
        // distribuir dados em buckets
        for (int i : this.vetor) {
            buckets[hash(i, code)].add(i);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }
        
        int ndx = 0;

        for (List<Integer> bucket : buckets) {
            for (int v : bucket) {
                this.vetor[ndx++] = v;
            }
        }
    }

    /**
     * @param input Vetor
     * @return array contendo hash de input
     */
    private int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }
        return new int[]{m, (int) Math.sqrt(input.length)};
    }

    /**
     * @param i Index atual
     * @param code Array
     * @return Retorna Hash para o Index atual
     */
    private int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }
}
