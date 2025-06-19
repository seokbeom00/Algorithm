# [Gold II] Mania de Par - 13595 

[문제 링크](https://www.acmicpc.net/problem/13595) 

### 성능 요약

메모리: 43800 KB, 시간: 484 ms

### 분류

그래프 이론, 최단 경로, 데이크스트라, 홀짝성

### 제출 일자

2025년 6월 19일 14:54:44

### 문제 설명

<p>Patrícia é uma ótima desenvolvedora de software. No entanto, como quase toda pessoa brilhante, ela tem algumas manias estranhas, e uma delas é que tudo que ela faz tem que ser em número par. Muitas vezes essa mania não atrapalha, apesar de causar estranhamento nos outros. Alguns exemplos: ela tem que fazer diariamente um número par de refeições; no café da manhã toma duas xícaras de café, duas torradas e duas fatias de queijo; sempre que vai ao cinema compra dois bilhetes de entrada (felizmente sempre tem um amigo ou amiga lhe acompanhando); e toma dois banhos por dia (ou quatro, ou seis...).</p>

<p>Mas algumas vezes essa mania de Patrícia atrapalha. Por exemplo, ninguém gosta de viajar de carro com ela, pois se no trajeto ela tem que pagar pedágios, o número de pedágios que ela paga tem que ser par.</p>

<p>Patrícia mora em um país em que todas as estradas são bidirecionais e têm exatamente um pedágio. Ela precisa ir visitar um cliente em uma outra cidade, e deseja calcular o mínimo valor total de pedágios que ela tem que pagar, para ir da sua cidade à cidade do cliente, obedecendo à sua estranha mania de que o número de pedágios pagos tem que ser par.</p>

### 입력 

 <p>A entrada consiste de diversas linhas. A primeira linha contém 2 inteiros C e V, o número total de cidades e o número de estradas (2 ≤ C ≤ 10<sup>4 </sup>e 0 ≤ V ≤ 50000). As cidades são identificadas por inteiros de 1 a C. Cada estrada liga duas cidades distintas, e há no máximo uma estrada entre cada par de cidades. Cada uma das V linhas seguintes contém três inteiros C<sub>1</sub>, C<sub>2</sub> e G, indicando que o valor do pedágio da estrada que liga as cidades C<sub>1</sub> e C<sub>2</sub> é G (1 ≤ C<sub>1</sub>, C<sub>2</sub> ≤ C e 1 ≤ G ≤ 10<sup>4</sup>). Patrícia está atualmente na cidade 1 e a cidade do cliente é C.</p>

### 출력 

 <p>Uma única linha deve ser impressa, contendo um único inteiro, o custo total de pedágios para Patrícia ir da cidade 1 à cidade C, pagando um número par de pedágios, ou, se isso não for possível, o valor −1.</p>

