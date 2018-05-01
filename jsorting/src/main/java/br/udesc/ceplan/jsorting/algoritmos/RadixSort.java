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
 *<p>O <b>Radix sort<b> é um algoritmo de ordenação rápido e estável que pode ser usado para ordenar itens que estão identificados por chaves únicas. 
Cada chave é uma cadeia de caracteres ou número, e o radix sort ordena estas chaves em qualquer ordem relacionada com a lexicografia.
</p>

<p>Na ciência da computação, radix sort é um algoritmo de ordenação que ordena inteiros processando dígitos individuais. 
Como os inteiros podem representar strings compostas de caracteres (como nomes ou datas) e pontos flutuantes especialmente formatados, 
radix sort não é limitado somente a inteiros.
</p>
<p>
Computadores, na sua maioria, representam internamente todos os tipo de dados como números binários, por isso processar os dígitos na forma de inteiros em grupos 
representados por dígitos binários se torna mais conveniente. Existem duas classificações do radix sort, que são:
<p>
<p>
- Least significant digit (LSD – Dígito menos significativo) radix sort; - Most significant digit (MSD – Dígito mais significativo) radix sort.
</p>
<p>
O radix sort LSD começa do dígito menos significativo até o mais significativo, ordenando tipicamente da seguinte forma: chaves curtas vem antes de chaves longas,
 e chaves de mesmo tamanho são ordenadas lexicograficamente. Isso coincide com a ordem normal de representação dos inteiros, como a seqüência
  "1, 2, 3, 4, 5, 6, 7, 8, 9, 10". Os valores processados pelo algoritmo de ordenação são frequentemente chamados de “chaves”, que podem existir por si próprias 
  ou associadas a outros dados. As chaves podem ser strings de caracteres ou números.
</p>
<p>
Já o radix sort MSD trabalha no sentido contrário, usando sempre a ordem lexicográfica, que é adequada para ordenação de strings, como palavras, ou representações de 
inteiros com tamanho fixo. A seqüência "b, c, d, e, f, g, h, i, j, ba" será ordenada lexicograficamente como "b, ba, c, d, e, f, g, h, i, j". Se essa ordenação for usada
 para ordenar representações de inteiros com tamanho variável, então a representação dos números inteiros de 1 a 10 terá a saída "1, 10, 2, 3, 4, 5, 6, 7, 8, 9".
</p>
<p>
O radix sort LSD opera na notação Big O, em O(nk), onde "n" é o número de chaves, e "k" é o comprimento médio da chave. É possível garantir esse desempenho 
para chaves com comprimento variável agrupando todas as chaves que tem o mesmo comprimento e ordenando separadamente cada grupo de chaves, do mais curto para
 o mais comprido, de modo a evitar o processamento de uma lista inteira de chaves em cada passo da ordenação.
</p>
<p>
Em muitas aplicações em que é necessário velocidade, o radix sort melhora as ordenações por comparação, como heapsort e o mergesort, que necessitam de Ω(n · log n)
 comparações, onde "n" é o número de itens a serem ordenados. Em compensação, algoritmos de ordenação baseados em comparações oferecem flexibilidade por serem aptos a 
 ordenar de outras formas que não a lexicográfica. No entanto, essa habilidade é de pouca importância em várias aplicações práticas.
</p>
<p>
O algoritmo de ordenação radix foi originalmente usado para ordenar cartões perfurados. Um algoritmo computacional para o radix sort foi inventado em 1954
 no MIT por Harold H. Seward.
 </p>
<p>
<b>Características</b>
</p>

<p>Complexidade de Tempo: Θ(nk).</p>

<p>Complexidade de espaço: Θ(n + s).</p>

<p>– n = número de elementos.</p>

<p>– k = tamanho string.</p>

<p>– s = tamanho do alfabeto.</p>

 * 
 * @author Marcelo Wischniowski <marcelowisc at gmail.com>
 */
public class RadixSort extends AbstractSort {   
    /**
     * Construtor
     * @param vetor Vetor que será ordenado
     */
    public RadixSort(int[] vetor){
        super(vetor);
    };
    /**
     * Aplica a ordenação RadixSorte no vetor
     */
	@Override
	public void sort() {
        int length = vetor.length,
            i,
            exp = 1,
            higher = vetor[0];
            int[] temp = new int[10];

            for (i = 1; i < length; i++)
                if (vetor[i] > higher)
                    higher = vetor[i];           
            while (higher / exp > 0){
                int[] bucket = new int[10];    
                for (i = 0; i < length; i++)
                    bucket[(vetor[i] / exp) % 10]++;
                
                for (i = 1; i < 10; i++)
                    bucket[i] += bucket[i - 1];
                
                for (i = length - 1; i >= 0; i--)
                    temp[--bucket[(vetor[i] / exp) % 10]] = vetor[i];
                
                for (i = 0; i < length; i++)
                    vetor[i] = temp[i];
                
                exp = exp * 10;        
            }		
	}
}