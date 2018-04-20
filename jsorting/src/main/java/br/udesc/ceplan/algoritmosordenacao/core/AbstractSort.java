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
package br.udesc.ceplan.algoritmosordenacao.core;

import java.util.Arrays;

/**
 * Classe Abstrata de Ordenação
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public abstract class AbstractSort implements ISort {

    /**
     * Vetor que será ordenado
     */
    protected int[] vetor;

    /**
     * Tamanho do vetor que será ordenado
     */
    protected int length;

    /**
     *
     * @param vetor
     */
    public AbstractSort(int[] vetor) {
        // Guardo o tamanho do vetor, pois como vou usar muitas vezes não desejo 
        // gastar esforço computacional para obtê-lo
        this.length = vetor.length;

        // Crio uma cópia para não dar problema de referência
        this.vetor = Arrays.copyOf(vetor, this.length);
    }

    /**
     * Retorna o vetor
     *
     * @return Vetor
     */
    @Override
    public int[] get() {
        return this.vetor;
    }

    /**
     * Converte o vetor em string
     *
     * @return Vetor
     */
    @Override
    public String toString() {
        return Arrays.toString(vetor);
    }
}
