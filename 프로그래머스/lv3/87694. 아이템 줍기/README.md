# [level 3] 아이템 줍기 - 87694 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87694) 

### 성능 요약

메모리: 75.5 MB, 시간: 0.41 ms

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

### 채점결과

Empty

### 문제 설명

<p data-afsc-id="55" style="font-size: 8px !important;">다음과 같은 다각형 모양 지형에서 캐릭터가 아이템을 줍기 위해 이동하려 합니다.</p>

<p data-afsc-id="56" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/9b96b07f-72db-4b1c-bd7a-6a9c9b8d0dc6/rect_1.png" title="" alt="rect_1.png" data-afsc-id="57"></p>

<p data-afsc-id="58" style="font-size: 8px !important;">지형은 각 변이 x축, y축과 평행한 직사각형이 겹쳐진 형태로 표현하며, 캐릭터는 이 다각형의 둘레(굵은 선)를 따라서 이동합니다. </p>

<p data-afsc-id="59" style="font-size: 8px !important;">만약 직사각형을 겹친 후 다음과 같이 중앙에 빈 공간이 생기는 경우, 다각형의 가장 바깥쪽 테두리가 캐릭터의 이동 경로가 됩니다.</p>

<p data-afsc-id="60" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/38b0739b-8dd8-40d8-ac44-c71678d28d07/rect_2.png" title="" alt="rect_2.png" data-afsc-id="61"></p>

<p data-afsc-id="62" style="font-size: 8px !important;">단, 서로 다른 두 직사각형의 x축 좌표 또는 y축 좌표가 같은 경우는 없습니다.</p>

<p data-afsc-id="63" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/ec976181-987e-494e-bb2d-0615ce16252f/rect_4.png" title="" alt="rect_4.png" data-afsc-id="64"></p>

<p data-afsc-id="65" style="font-size: 8px !important;">즉, 위 그림처럼 서로 다른 두 직사각형이 꼭짓점에서 만나거나, 변이 겹치는 경우 등은 없습니다.</p>

<p data-afsc-id="66" style="font-size: 8px !important;">다음 그림과 같이 지형이 2개 이상으로 분리된 경우도 없습니다.</p>

<p data-afsc-id="67" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7eda8d92-ebe0-4b5f-bd15-0c9dc7af3a3e/rect_3.png" title="" alt="rect_3.png" data-afsc-id="68"></p>

<p data-afsc-id="69" style="font-size: 8px !important;">한 직사각형이 다른 직사각형 안에 완전히 포함되는 경우 또한 없습니다.</p>

<p data-afsc-id="70" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/1e178b0d-6580-4981-aae3-dd82a1b95362/rect_7.png" title="" alt="rect_7.png" data-afsc-id="71"></p>

<p data-afsc-id="72" style="font-size: 8px !important;">지형을 나타내는 직사각형이 담긴 2차원 배열 rectangle, 초기 캐릭터의 위치 characterX, characterY, 아이템의 위치 itemX, itemY가 solution 함수의 매개변수로 주어질 때, 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리를 return 하도록 solution 함수를 완성해주세요.</p>

<h5 data-afsc-id="73" style="font-size: 7px !important;">제한사항</h5>

<ul data-afsc-id="74">
<li data-afsc-id="75" style="font-size: 8px !important;">rectangle의 세로(행) 길이는 1 이상 4 이하입니다.</li>
<li data-afsc-id="76" style="font-size: 8px !important;">rectangle의 원소는 각 직사각형의 [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y] 좌표 형태입니다.

<ul data-afsc-id="77">
<li data-afsc-id="78" style="font-size: 8px !important;">직사각형을 나타내는 모든 좌표값은 1 이상 50 이하인 자연수입니다.</li>
<li data-afsc-id="79" style="font-size: 8px !important;">서로 다른 두 직사각형의 x축 좌표, 혹은 y축 좌표가 같은 경우는 없습니다.</li>
<li data-afsc-id="80" style="font-size: 8px !important;">문제에 주어진 조건에 맞는 직사각형만 입력으로 주어집니다.</li>
</ul></li>
<li data-afsc-id="81" style="font-size: 8px !important;">charcterX, charcterY는 1 이상 50 이하인 자연수입니다.

<ul data-afsc-id="82">
<li data-afsc-id="83" style="font-size: 8px !important;">지형을 나타내는 다각형 테두리 위의 한 점이 주어집니다.</li>
</ul></li>
<li data-afsc-id="84" style="font-size: 8px !important;">itemX, itemY는 1 이상 50 이하인 자연수입니다.

<ul data-afsc-id="85">
<li data-afsc-id="86" style="font-size: 8px !important;">지형을 나타내는 다각형 테두리 위의 한 점이 주어집니다.</li>
</ul></li>
<li data-afsc-id="87" style="font-size: 8px !important;">캐릭터와 아이템의 처음 위치가 같은 경우는 없습니다.</li>
</ul>

<hr data-afsc-id="88">

<ul data-afsc-id="89">
<li data-afsc-id="90" style="font-size: 8px !important;">전체 배점의 50%는 직사각형이 1개인 경우입니다.<br data-afsc-id="91"></li>
<li data-afsc-id="92" style="font-size: 8px !important;">전체 배점의 25%는 직사각형이 2개인 경우입니다.<br data-afsc-id="93"></li>
<li data-afsc-id="94" style="font-size: 8px !important;">전체 배점의 25%는 직사각형이 3개 또는 4개인 경우입니다.<br data-afsc-id="95"></li>
</ul>

<hr data-afsc-id="96">

<h5 data-afsc-id="97" style="font-size: 7px !important;">입출력 예</h5>
<table class="table" data-afsc-id="98">
        <thead data-afsc-id="99"><tr data-afsc-id="100">
<th data-afsc-id="101" style="font-size: 8px !important;">rectangle</th>
<th data-afsc-id="102" style="font-size: 8px !important;">characterX</th>
<th data-afsc-id="103" style="font-size: 8px !important;">characterY</th>
<th data-afsc-id="104" style="font-size: 8px !important;">itemX</th>
<th data-afsc-id="105" style="font-size: 8px !important;">itemY</th>
<th data-afsc-id="106" style="font-size: 8px !important;">result</th>
</tr>
</thead>
        <tbody data-afsc-id="107"><tr data-afsc-id="108">
<td data-afsc-id="109" style="font-size: 8px !important;">[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]</td>
<td data-afsc-id="110" style="font-size: 8px !important;">1</td>
<td data-afsc-id="111" style="font-size: 8px !important;">3</td>
<td data-afsc-id="112" style="font-size: 8px !important;">7</td>
<td data-afsc-id="113" style="font-size: 8px !important;">8</td>
<td data-afsc-id="114" style="font-size: 8px !important;">17</td>
</tr>
<tr data-afsc-id="115">
<td data-afsc-id="116" style="font-size: 8px !important;">[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]</td>
<td data-afsc-id="117" style="font-size: 8px !important;">9</td>
<td data-afsc-id="118" style="font-size: 8px !important;">7</td>
<td data-afsc-id="119" style="font-size: 8px !important;">6</td>
<td data-afsc-id="120" style="font-size: 8px !important;">1</td>
<td data-afsc-id="121" style="font-size: 8px !important;">11</td>
</tr>
<tr data-afsc-id="122">
<td data-afsc-id="123" style="font-size: 8px !important;">[[1,1,5,7]]</td>
<td data-afsc-id="124" style="font-size: 8px !important;">1</td>
<td data-afsc-id="125" style="font-size: 8px !important;">1</td>
<td data-afsc-id="126" style="font-size: 8px !important;">4</td>
<td data-afsc-id="127" style="font-size: 8px !important;">7</td>
<td data-afsc-id="128" style="font-size: 8px !important;">9</td>
</tr>
<tr data-afsc-id="129">
<td data-afsc-id="130" style="font-size: 8px !important;">[[2,1,7,5],[6,4,10,10]]</td>
<td data-afsc-id="131" style="font-size: 8px !important;">3</td>
<td data-afsc-id="132" style="font-size: 8px !important;">1</td>
<td data-afsc-id="133" style="font-size: 8px !important;">7</td>
<td data-afsc-id="134" style="font-size: 8px !important;">10</td>
<td data-afsc-id="135" style="font-size: 8px !important;">15</td>
</tr>
<tr data-afsc-id="136">
<td data-afsc-id="137" style="font-size: 8px !important;">[[2,2,5,5],[1,3,6,4],[3,1,4,6]]</td>
<td data-afsc-id="138" style="font-size: 8px !important;">1</td>
<td data-afsc-id="139" style="font-size: 8px !important;">4</td>
<td data-afsc-id="140" style="font-size: 8px !important;">6</td>
<td data-afsc-id="141" style="font-size: 8px !important;">3</td>
<td data-afsc-id="142" style="font-size: 8px !important;">10</td>
</tr>
</tbody>
      </table>
<h5 data-afsc-id="143" style="font-size: 7px !important;">입출력 예 설명</h5>

<p data-afsc-id="144" style="font-size: 8px !important;">입출력 예 #1</p>

<p data-afsc-id="145" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7b89552b-f7b6-47e7-8bbd-deaf01907f70/rect_5.png" title="" alt="rect_5.png" data-afsc-id="146"></p>

<p data-afsc-id="147" style="font-size: 8px !important;">캐릭터 위치는 (1, 3)이며, 아이템 위치는 (7, 8)입니다. 위 그림과 같이 굵은 선을 따라 이동하는 경로가 가장 짧습니다.</p>

<p data-afsc-id="148" style="font-size: 8px !important;">입출력 예 #2</p>

<p data-afsc-id="149" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/ac6911d0-e386-472b-a109-2542214c8d6b/rect_6.png" title="" alt="rect_6.png" data-afsc-id="150"></p>

<p data-afsc-id="151" style="font-size: 8px !important;">캐릭터 위치는 (9, 7)이며, 아이템 위치는 (6, 1)입니다. 위 그림과 같이 굵은 선을 따라 이동하는 경로가 가장 짧습니다.</p>

<p data-afsc-id="152" style="font-size: 8px !important;">입출력 예 #3</p>

<p data-afsc-id="153" style="font-size: 8px !important;"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/9c47ca5c-df4b-4b2e-8c5b-faf0815de665/rect_8.png" title="" alt="rect_8.png" data-afsc-id="154"></p>

<p data-afsc-id="155" style="font-size: 8px !important;">캐릭터 위치는 (1, 1)이며, 아이템 위치는 (4, 7)입니다. 위 그림과 같이 굵은 선을 따라 이동하는 경로가 가장 짧습니다.</p>

<p data-afsc-id="156" style="font-size: 8px !important;">입출력 예 #4, #5</p>

<p data-afsc-id="157" style="font-size: 8px !important;">설명 생략</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges