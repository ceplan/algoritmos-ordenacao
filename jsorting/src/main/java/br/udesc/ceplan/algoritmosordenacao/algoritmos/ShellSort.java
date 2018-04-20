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
package br.udesc.ceplan.algoritmosordenacao.algoritmos;

import br.udesc.ceplan.algoritmosordenacao.core.AbstractSort;

/**
 * <p>
 * Criado por Donald Shell em 1959, publicado pela Universidade de Cincinnati,
 * Shell sort é o mais eficiente algoritmo de classificação dentre os de
 * complexidade quadrática. É um refinamento do método de inserção direta. O
 * algoritmo difere do método de inserção direta pelo fato de no lugar de
 * considerar o array a ser ordenado como um único segmento, ele considera
 * vários segmentos sendo aplicado o método de inserção direta em cada um deles.
 * Basicamente o algoritmo passa várias vezes pela lista dividindo o grupo maior
 * em menores. Nos grupos menores é aplicado o método da ordenação por
 * inserção.
 * </p>
 * 
 * <p>
 * Complexidade pior caso: Depende da sequência do gap. Melhor conhecida: O ( n
 * log_2 n )
 * </p>
 * 
 * <p>
 * Complexidade caso médio: Depende da sequência do gap 
 * </p>
 * 
 * <p>
 * Complexidade melhor caso: O ( n log_2 n )
 * </p>
 * 
 * <p>
 * Complexidade de espaços pior caso: O ( n^2 )
 * </p>
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class ShellSort extends AbstractSort {

    /**
     * Construtor
     * @param vetor Vetor que será ordenado
     */
    public ShellSort(int[] vetor) {
        super(vetor);
    }

    /**
     * Aplica a ordenação ShellSort no vetor
     */
    @Override
    public void sort() {
        int i, j, h = 1, temp;

        do {
            h = 3 * h + 1;
        } while (h < this.length);

        do {
            h /= 3;

            for (i = h; i < this.length; i++) {
                temp = this.vetor[i];
                j = i - h;
                while (j >= 0 && temp < this.vetor[j]) {
                    this.vetor[j + h] = this.vetor[j];
                    j -= h;
                }
                this.vetor[j + h] = temp;
            }
        } while (h > 1);
    }
}
