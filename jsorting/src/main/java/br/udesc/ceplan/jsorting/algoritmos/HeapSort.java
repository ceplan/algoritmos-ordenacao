/*
 * Copyright 2018 Marcelo Wischniowski <marcelowisc at gmail.com>.
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
 *
 * <p>
 * O algoritmo heapsort é um algoritmo de ordenação generalista, e faz parte da
 * família de algoritmos de ordenação por seleção. Foi desenvolvido em 1964 por
 * Robert W. Floyd e J.W.J Williams.</p>
 *
 * <p>
 * Tem um desempenho em tempo de execução muito bom em conjuntos ordenados
 * aleatoriamente, tem um uso de memória bem comportado e o seu desempenho em
 * pior cenário é praticamente igual ao desempenho em cenário médio. Alguns
 * algoritmos de ordenação rápidos têm desempenhos espectacularmente ruins no
 * pior cenário, quer em tempo de execução, quer no uso da memória. O heapsort
 * trabalha no lugar e o tempo de execução em pior cenário para ordenar n
 * elementos é de O (n lg n). Lê-se logaritmo (ou log) de "n" na base 2. Para
 * valores de n, razoavelmente grandes, o termo log n é quase constante, de modo
 * que o tempo de ordenação é quase linear com o número de itens a ordenar.</p>
 *
 * <ul>
 * <li>Comparações no pior caso: 2n log2n + O(n) é o mesmo que 2n lgn +
 * O(n)</li>
 * <li>Trocas no pior caso: n log2n + O(n) é o mesmo que n lgn + O(n)</li>
 * <li>Melhor e pior caso: O(n log2n) é o mesmo que O(n lgn)</li>
 * </ul>
 *
 * @author Marcelo Wischniowski <marcelowisc at gmail.com>
 */
public class HeapSort extends AbstractSort {

    /**
     * Construtor
     *
     * @param vetor Vetor que será ordenado
     */
    public HeapSort(int[] vetor) {
        super(vetor);
    }

    /**
     * Aplica a ordenação HeapSort no vetor
     */
    @Override
    public void sort() {
        for (int i = this.length / 2 - 1; i >= 0; i--) {
            heapify(this.vetor, this.length, i);
        }
        for (int i = this.length - 1; i >= 0; i--) {
            int temp = this.vetor[0];
            this.vetor[0] = this.vetor[i];
            this.vetor[i] = temp;

            heapify(this.vetor, i, 0);
        }
    }

    /**
     * Heapify cria uma Árvore Binária Completa. Se o nó pai for armazenado no
     * índice rootElementIndex, o filho da esquerda pode ser calculado por 2 *
     * rootElementIndex + 1 e filho da direita por 2 * rootElementIndex + 2
     * (assumindo que a indexação começa em 0).
     *
     * @param arr
     * @param arrayLength
     * @param rootElementIndex
     */
    public void heapify(int arr[], int arrayLength, int rootElementIndex) {

        int leftIndex = 2 * rootElementIndex + 1;
        int rightIndex = 2 * rootElementIndex + 2;
        int largest = rootElementIndex;

        if (leftIndex < arrayLength && arr[leftIndex] > arr[largest]) {
            largest = leftIndex;
        }

        if (rightIndex < arrayLength && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }

        if (largest != rootElementIndex) {
            int swap = arr[rootElementIndex];
            arr[rootElementIndex] = arr[largest];
            arr[largest] = swap;
            heapify(arr, arrayLength, largest);
        }
    }
}
