# [level 2] 주차 요금 계산 - 92341 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/92341) 

### 성능 요약

메모리: 75.2 MB, 시간: 0.46 ms

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

### 채점결과

Empty

### 문제 설명

<h5 data-afsc-id="60" style="font-size: 7px !important;">문제 설명</h5>

<p data-afsc-id="61" style="font-size: 8px !important;">주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.</p>

<ul data-afsc-id="62">
<li data-afsc-id="63" style="font-size: 8px !important;"><strong data-afsc-id="64">요금표</strong></li>
</ul>
<table class="table" data-afsc-id="65">
        <thead data-afsc-id="66"><tr data-afsc-id="67">
<th data-afsc-id="68" style="font-size: 8px !important;">기본 시간(분)</th>
<th data-afsc-id="69" style="font-size: 8px !important;">기본 요금(원)</th>
<th data-afsc-id="70" style="font-size: 8px !important;">단위 시간(분)</th>
<th data-afsc-id="71" style="font-size: 8px !important;">단위 요금(원)</th>
</tr>
</thead>
        <tbody data-afsc-id="72"><tr data-afsc-id="73">
<td data-afsc-id="74" style="font-size: 8px !important;">180</td>
<td data-afsc-id="75" style="font-size: 8px !important;">5000</td>
<td data-afsc-id="76" style="font-size: 8px !important;">10</td>
<td data-afsc-id="77" style="font-size: 8px !important;">600</td>
</tr>
</tbody>
      </table>
<p data-afsc-id="78" style="font-size: 8px !important;">&nbsp;</p>

<ul data-afsc-id="79">
<li data-afsc-id="80" style="font-size: 8px !important;"><strong data-afsc-id="81">입/출차 기록</strong></li>
</ul>
<table class="table" data-afsc-id="82">
        <thead data-afsc-id="83"><tr data-afsc-id="84">
<th data-afsc-id="85" style="font-size: 8px !important;">시각(시:분)</th>
<th data-afsc-id="86" style="font-size: 8px !important;">차량 번호</th>
<th data-afsc-id="87" style="font-size: 8px !important;">내역</th>
</tr>
</thead>
        <tbody data-afsc-id="88"><tr data-afsc-id="89">
<td data-afsc-id="90" style="font-size: 8px !important;">05:34</td>
<td data-afsc-id="91" style="font-size: 8px !important;">5961</td>
<td data-afsc-id="92" style="font-size: 8px !important;">입차</td>
</tr>
<tr data-afsc-id="93">
<td data-afsc-id="94" style="font-size: 8px !important;">06:00</td>
<td data-afsc-id="95" style="font-size: 8px !important;">0000</td>
<td data-afsc-id="96" style="font-size: 8px !important;">입차</td>
</tr>
<tr data-afsc-id="97">
<td data-afsc-id="98" style="font-size: 8px !important;">06:34</td>
<td data-afsc-id="99" style="font-size: 8px !important;">0000</td>
<td data-afsc-id="100" style="font-size: 8px !important;">출차</td>
</tr>
<tr data-afsc-id="101">
<td data-afsc-id="102" style="font-size: 8px !important;">07:59</td>
<td data-afsc-id="103" style="font-size: 8px !important;">5961</td>
<td data-afsc-id="104" style="font-size: 8px !important;">출차</td>
</tr>
<tr data-afsc-id="105">
<td data-afsc-id="106" style="font-size: 8px !important;">07:59</td>
<td data-afsc-id="107" style="font-size: 8px !important;">0148</td>
<td data-afsc-id="108" style="font-size: 8px !important;">입차</td>
</tr>
<tr data-afsc-id="109">
<td data-afsc-id="110" style="font-size: 8px !important;">18:59</td>
<td data-afsc-id="111" style="font-size: 8px !important;">0000</td>
<td data-afsc-id="112" style="font-size: 8px !important;">입차</td>
</tr>
<tr data-afsc-id="113">
<td data-afsc-id="114" style="font-size: 8px !important;">19:09</td>
<td data-afsc-id="115" style="font-size: 8px !important;">0148</td>
<td data-afsc-id="116" style="font-size: 8px !important;">출차</td>
</tr>
<tr data-afsc-id="117">
<td data-afsc-id="118" style="font-size: 8px !important;">22:59</td>
<td data-afsc-id="119" style="font-size: 8px !important;">5961</td>
<td data-afsc-id="120" style="font-size: 8px !important;">입차</td>
</tr>
<tr data-afsc-id="121">
<td data-afsc-id="122" style="font-size: 8px !important;">23:00</td>
<td data-afsc-id="123" style="font-size: 8px !important;">5961</td>
<td data-afsc-id="124" style="font-size: 8px !important;">출차</td>
</tr>
</tbody>
      </table>
<p data-afsc-id="125" style="font-size: 8px !important;">&nbsp;</p>

<ul data-afsc-id="126">
<li data-afsc-id="127" style="font-size: 8px !important;"><strong data-afsc-id="128">자동차별 주차 요금</strong></li>
</ul>
<table class="table" data-afsc-id="129">
        <thead data-afsc-id="130"><tr data-afsc-id="131">
<th data-afsc-id="132" style="font-size: 8px !important;">차량 번호</th>
<th data-afsc-id="133" style="font-size: 8px !important;">누적 주차 시간(분)</th>
<th data-afsc-id="134" style="font-size: 8px !important;">주차 요금(원)</th>
</tr>
</thead>
        <tbody data-afsc-id="135"><tr data-afsc-id="136">
<td data-afsc-id="137" style="font-size: 8px !important;">0000</td>
<td data-afsc-id="138" style="font-size: 8px !important;">34 + 300 = 334</td>
<td data-afsc-id="139" style="font-size: 8px !important;">5000 + <code data-afsc-id="140">⌈</code>(334 - 180) / 10<code data-afsc-id="141">⌉</code> x 600 = 14600</td>
</tr>
<tr data-afsc-id="142">
<td data-afsc-id="143" style="font-size: 8px !important;">0148</td>
<td data-afsc-id="144" style="font-size: 8px !important;">670</td>
<td data-afsc-id="145" style="font-size: 8px !important;">5000 +<code data-afsc-id="146">⌈</code>(670 - 180) / 10<code data-afsc-id="147">⌉</code>x 600 = 34400</td>
</tr>
<tr data-afsc-id="148">
<td data-afsc-id="149" style="font-size: 8px !important;">5961</td>
<td data-afsc-id="150" style="font-size: 8px !important;">145 + 1 = 146</td>
<td data-afsc-id="151" style="font-size: 8px !important;">5000</td>
</tr>
</tbody>
      </table>
<ul data-afsc-id="152">
<li data-afsc-id="153" style="font-size: 8px !important;">어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.

<ul data-afsc-id="154">
<li data-afsc-id="155" style="font-size: 8px !important;"><code data-afsc-id="156">0000</code>번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.</li>
</ul></li>
<li data-afsc-id="157" style="font-size: 8px !important;">00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다. </li>
<li data-afsc-id="158" style="font-size: 8px !important;">누적 주차 시간이 <code data-afsc-id="159">기본 시간</code>이하라면, <code data-afsc-id="160">기본 요금</code>을 청구합니다.<br data-afsc-id="161"></li>
<li data-afsc-id="162" style="font-size: 8px !important;">누적 주차 시간이 <code data-afsc-id="163">기본 시간</code>을 초과하면, <code data-afsc-id="164">기본 요금</code>에 더해서, 초과한 시간에 대해서 <code data-afsc-id="165">단위 시간</code> 마다 <code data-afsc-id="166">단위 요금</code>을 청구합니다.

<ul data-afsc-id="167">
<li data-afsc-id="168" style="font-size: 8px !important;">초과한 시간이 <code data-afsc-id="169">단위 시간</code>으로 나누어 떨어지지 않으면, <code data-afsc-id="170">올림</code>합니다.<br data-afsc-id="171"></li>
<li data-afsc-id="172" style="font-size: 8px !important;"><code data-afsc-id="173">⌈</code>a<code data-afsc-id="174">⌉</code> : a보다 작지 않은 최소의 정수를 의미합니다. 즉, <code data-afsc-id="175">올림</code>을 의미합니다.</li>
</ul></li>
</ul>

<p data-afsc-id="176" style="font-size: 8px !important;">주차 요금을 나타내는 정수 배열 <code data-afsc-id="177">fees</code>, 자동차의 입/출차 내역을 나타내는 문자열 배열 <code data-afsc-id="178">records</code>가 매개변수로 주어집니다. <strong data-afsc-id="179">차량 번호가 작은 자동차부터</strong> 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.</p>

<h5 data-afsc-id="180" style="font-size: 7px !important;">제한사항</h5>

<ul data-afsc-id="181">
<li data-afsc-id="182" style="font-size: 8px !important;"><p data-afsc-id="183" style="font-size: 8px !important;"><code data-afsc-id="184">fees</code>의 길이 = 4</p>

<ul data-afsc-id="185">
<li data-afsc-id="186" style="font-size: 8px !important;">fees[0] = <code data-afsc-id="187">기본 시간(분)</code></li>
<li data-afsc-id="188" style="font-size: 8px !important;">1 ≤ fees[0] ≤ 1,439 </li>
<li data-afsc-id="189" style="font-size: 8px !important;">fees[1] = <code data-afsc-id="190">기본 요금(원)</code></li>
<li data-afsc-id="191" style="font-size: 8px !important;">0 ≤ fees[1] ≤ 100,000</li>
<li data-afsc-id="192" style="font-size: 8px !important;">fees[2] = <code data-afsc-id="193">단위 시간(분)</code></li>
<li data-afsc-id="194" style="font-size: 8px !important;">1 ≤ fees[2] ≤ 1,439</li>
<li data-afsc-id="195" style="font-size: 8px !important;">fees[3] = <code data-afsc-id="196">단위 요금(원)</code> </li>
<li data-afsc-id="197" style="font-size: 8px !important;">1 ≤ fees[3] ≤ 10,000</li>
</ul></li>
<li data-afsc-id="198" style="font-size: 8px !important;"><p data-afsc-id="199" style="font-size: 8px !important;">1 ≤ <code data-afsc-id="200">records</code>의 길이 ≤ 1,000</p>

<ul data-afsc-id="201">
<li data-afsc-id="202" style="font-size: 8px !important;"><code data-afsc-id="203">records</code>의 각 원소는 <code data-afsc-id="204">"시각 차량번호 내역"</code> 형식의 문자열입니다.</li>
<li data-afsc-id="205" style="font-size: 8px !important;"><code data-afsc-id="206">시각</code>, <code data-afsc-id="207">차량번호</code>, <code data-afsc-id="208">내역</code>은 하나의 공백으로 구분되어 있습니다.</li>
<li data-afsc-id="209" style="font-size: 8px !important;"><code data-afsc-id="210">시각</code>은 차량이 입차되거나 출차된 시각을 나타내며, <code data-afsc-id="211">HH:MM</code> 형식의 길이 5인 문자열입니다.

<ul data-afsc-id="212">
<li data-afsc-id="213" style="font-size: 8px !important;"><code data-afsc-id="214">HH:MM</code>은 00:00부터 23:59까지 주어집니다.</li>
<li data-afsc-id="215" style="font-size: 8px !important;">잘못된 시각("25:22", "09:65" 등)은 입력으로 주어지지 않습니다.</li>
</ul></li>
<li data-afsc-id="216" style="font-size: 8px !important;"><code data-afsc-id="217">차량번호</code>는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다.<br data-afsc-id="218"></li>
<li data-afsc-id="219" style="font-size: 8px !important;"><code data-afsc-id="220">내역</code>은 길이 2 또는 3인 문자열로, <code data-afsc-id="221">IN</code> 또는 <code data-afsc-id="222">OUT</code>입니다. <code data-afsc-id="223">IN</code>은 입차를, <code data-afsc-id="224">OUT</code>은 출차를 의미합니다. </li>
<li data-afsc-id="225" style="font-size: 8px !important;"><code data-afsc-id="226">records</code>의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다.</li>
<li data-afsc-id="227" style="font-size: 8px !important;"><code data-afsc-id="228">records</code>는 하루 동안의 입/출차된 기록만 담고 있으며, 입차된 차량이 다음날 출차되는 경우는 입력으로 주어지지 않습니다.</li>
<li data-afsc-id="229" style="font-size: 8px !important;">같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다.</li>
<li data-afsc-id="230" style="font-size: 8px !important;">마지막 시각(23:59)에 입차되는 경우는 입력으로 주어지지 않습니다.</li>
<li data-afsc-id="231" style="font-size: 8px !important;">아래의 예를 포함하여, 잘못된 입력은 주어지지 않습니다.

<ul data-afsc-id="232">
<li data-afsc-id="233" style="font-size: 8px !important;">주차장에 없는 차량이 출차되는 경우</li>
<li data-afsc-id="234" style="font-size: 8px !important;">주차장에 이미 있는 차량(차량번호가 같은 차량)이 다시 입차되는 경우</li>
</ul></li>
</ul></li>
</ul>

<hr data-afsc-id="235">

<h5 data-afsc-id="236" style="font-size: 7px !important;">입출력 예</h5>
<table class="table" data-afsc-id="237">
        <thead data-afsc-id="238"><tr data-afsc-id="239">
<th data-afsc-id="240" style="font-size: 8px !important;">fees</th>
<th data-afsc-id="241" style="font-size: 8px !important;">records</th>
<th data-afsc-id="242" style="font-size: 8px !important;">result</th>
</tr>
</thead>
        <tbody data-afsc-id="243"><tr data-afsc-id="244">
<td data-afsc-id="245" style="font-size: 8px !important;">[180, 5000, 10, 600]</td>
<td data-afsc-id="246" style="font-size: 8px !important;"><code data-afsc-id="247">["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]</code></td>
<td data-afsc-id="248" style="font-size: 8px !important;">[14600, 34400, 5000]</td>
</tr>
<tr data-afsc-id="249">
<td data-afsc-id="250" style="font-size: 8px !important;">[120, 0, 60, 591]</td>
<td data-afsc-id="251" style="font-size: 8px !important;"><code data-afsc-id="252">["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]</code></td>
<td data-afsc-id="253" style="font-size: 8px !important;">[0, 591]</td>
</tr>
<tr data-afsc-id="254">
<td data-afsc-id="255" style="font-size: 8px !important;">[1, 461, 1, 10]</td>
<td data-afsc-id="256" style="font-size: 8px !important;"><code data-afsc-id="257">["00:00 1234 IN"]</code></td>
<td data-afsc-id="258" style="font-size: 8px !important;">[14841]</td>
</tr>
</tbody>
      </table>
<hr data-afsc-id="259">

<h5 data-afsc-id="260" style="font-size: 7px !important;">입출력 예 설명</h5>

<p data-afsc-id="261" style="font-size: 8px !important;"><strong data-afsc-id="262">입출력 예 #1</strong></p>

<p data-afsc-id="263" style="font-size: 8px !important;">문제 예시와 같습니다.</p>

<p data-afsc-id="264" style="font-size: 8px !important;"><strong data-afsc-id="265">입출력 예 #2</strong></p>

<ul data-afsc-id="266">
<li data-afsc-id="267" style="font-size: 8px !important;"><strong data-afsc-id="268">요금표</strong></li>
</ul>
<table class="table" data-afsc-id="269">
        <thead data-afsc-id="270"><tr data-afsc-id="271">
<th data-afsc-id="272" style="font-size: 8px !important;">기본 시간(분)</th>
<th data-afsc-id="273" style="font-size: 8px !important;">기본 요금(원)</th>
<th data-afsc-id="274" style="font-size: 8px !important;">단위 시간(분)</th>
<th data-afsc-id="275" style="font-size: 8px !important;">단위 요금(원)</th>
</tr>
</thead>
        <tbody data-afsc-id="276"><tr data-afsc-id="277">
<td data-afsc-id="278" style="font-size: 8px !important;">120</td>
<td data-afsc-id="279" style="font-size: 8px !important;">0</td>
<td data-afsc-id="280" style="font-size: 8px !important;">60</td>
<td data-afsc-id="281" style="font-size: 8px !important;">591</td>
</tr>
</tbody>
      </table>
<p data-afsc-id="282" style="font-size: 8px !important;">&nbsp;</p>

<ul data-afsc-id="283">
<li data-afsc-id="284" style="font-size: 8px !important;"><strong data-afsc-id="285">입/출차 기록</strong></li>
</ul>
<table class="table" data-afsc-id="286">
        <thead data-afsc-id="287"><tr data-afsc-id="288">
<th data-afsc-id="289" style="font-size: 8px !important;">시각(시:분)</th>
<th data-afsc-id="290" style="font-size: 8px !important;">차량 번호</th>
<th data-afsc-id="291" style="font-size: 8px !important;">내역</th>
</tr>
</thead>
        <tbody data-afsc-id="292"><tr data-afsc-id="293">
<td data-afsc-id="294" style="font-size: 8px !important;">16:00</td>
<td data-afsc-id="295" style="font-size: 8px !important;">3961</td>
<td data-afsc-id="296" style="font-size: 8px !important;">입차</td>
</tr>
<tr data-afsc-id="297">
<td data-afsc-id="298" style="font-size: 8px !important;">16:00</td>
<td data-afsc-id="299" style="font-size: 8px !important;">0202</td>
<td data-afsc-id="300" style="font-size: 8px !important;">입차</td>
</tr>
<tr data-afsc-id="301">
<td data-afsc-id="302" style="font-size: 8px !important;">18:00</td>
<td data-afsc-id="303" style="font-size: 8px !important;">3961</td>
<td data-afsc-id="304" style="font-size: 8px !important;">출차</td>
</tr>
<tr data-afsc-id="305">
<td data-afsc-id="306" style="font-size: 8px !important;">18:00</td>
<td data-afsc-id="307" style="font-size: 8px !important;">0202</td>
<td data-afsc-id="308" style="font-size: 8px !important;">출차</td>
</tr>
<tr data-afsc-id="309">
<td data-afsc-id="310" style="font-size: 8px !important;">23:58</td>
<td data-afsc-id="311" style="font-size: 8px !important;">3961</td>
<td data-afsc-id="312" style="font-size: 8px !important;">입차</td>
</tr>
</tbody>
      </table>
<p data-afsc-id="313" style="font-size: 8px !important;">&nbsp;</p>

<ul data-afsc-id="314">
<li data-afsc-id="315" style="font-size: 8px !important;"><strong data-afsc-id="316">자동차별 주차 요금</strong></li>
</ul>
<table class="table" data-afsc-id="317">
        <thead data-afsc-id="318"><tr data-afsc-id="319">
<th data-afsc-id="320" style="font-size: 8px !important;">차량 번호</th>
<th data-afsc-id="321" style="font-size: 8px !important;">누적 주차 시간(분)</th>
<th data-afsc-id="322" style="font-size: 8px !important;">주차 요금(원)</th>
</tr>
</thead>
        <tbody data-afsc-id="323"><tr data-afsc-id="324">
<td data-afsc-id="325" style="font-size: 8px !important;">0202</td>
<td data-afsc-id="326" style="font-size: 8px !important;">120</td>
<td data-afsc-id="327" style="font-size: 8px !important;">0</td>
</tr>
<tr data-afsc-id="328">
<td data-afsc-id="329" style="font-size: 8px !important;">3961</td>
<td data-afsc-id="330" style="font-size: 8px !important;">120 + 1 = 121</td>
<td data-afsc-id="331" style="font-size: 8px !important;">0 +<code data-afsc-id="332">⌈</code>(121 - 120) / 60<code data-afsc-id="333">⌉</code>x 591 = 591</td>
</tr>
</tbody>
      </table>
<ul data-afsc-id="334">
<li data-afsc-id="335" style="font-size: 8px !important;"><code data-afsc-id="336">3961</code>번 차량은 2번째 입차된 후에는 출차된 내역이 없으므로, 23:59에 출차되었다고 간주합니다. </li>
</ul>

<p data-afsc-id="337" style="font-size: 8px !important;">&nbsp;</p>

<p data-afsc-id="338" style="font-size: 8px !important;"><strong data-afsc-id="339">입출력 예 #3</strong></p>

<ul data-afsc-id="340">
<li data-afsc-id="341" style="font-size: 8px !important;"><strong data-afsc-id="342">요금표</strong></li>
</ul>
<table class="table" data-afsc-id="343">
        <thead data-afsc-id="344"><tr data-afsc-id="345">
<th data-afsc-id="346" style="font-size: 8px !important;">기본 시간(분)</th>
<th data-afsc-id="347" style="font-size: 8px !important;">기본 요금(원)</th>
<th data-afsc-id="348" style="font-size: 8px !important;">단위 시간(분)</th>
<th data-afsc-id="349" style="font-size: 8px !important;">단위 요금(원)</th>
</tr>
</thead>
        <tbody data-afsc-id="350"><tr data-afsc-id="351">
<td data-afsc-id="352" style="font-size: 8px !important;">1</td>
<td data-afsc-id="353" style="font-size: 8px !important;">461</td>
<td data-afsc-id="354" style="font-size: 8px !important;">1</td>
<td data-afsc-id="355" style="font-size: 8px !important;">10</td>
</tr>
</tbody>
      </table>
<p data-afsc-id="356" style="font-size: 8px !important;">&nbsp;</p>

<ul data-afsc-id="357">
<li data-afsc-id="358" style="font-size: 8px !important;"><strong data-afsc-id="359">입/출차 기록</strong></li>
</ul>
<table class="table" data-afsc-id="360">
        <thead data-afsc-id="361"><tr data-afsc-id="362">
<th data-afsc-id="363" style="font-size: 8px !important;">시각(시:분)</th>
<th data-afsc-id="364" style="font-size: 8px !important;">차량 번호</th>
<th data-afsc-id="365" style="font-size: 8px !important;">내역</th>
</tr>
</thead>
        <tbody data-afsc-id="366"><tr data-afsc-id="367">
<td data-afsc-id="368" style="font-size: 8px !important;">00:00</td>
<td data-afsc-id="369" style="font-size: 8px !important;">1234</td>
<td data-afsc-id="370" style="font-size: 8px !important;">입차</td>
</tr>
</tbody>
      </table>
<p data-afsc-id="371" style="font-size: 8px !important;">&nbsp;</p>

<ul data-afsc-id="372">
<li data-afsc-id="373" style="font-size: 8px !important;"><strong data-afsc-id="374">자동차별 주차 요금</strong></li>
</ul>
<table class="table" data-afsc-id="375">
        <thead data-afsc-id="376"><tr data-afsc-id="377">
<th data-afsc-id="378" style="font-size: 8px !important;">차량 번호</th>
<th data-afsc-id="379" style="font-size: 8px !important;">누적 주차 시간(분)</th>
<th data-afsc-id="380" style="font-size: 8px !important;">주차 요금(원)</th>
</tr>
</thead>
        <tbody data-afsc-id="381"><tr data-afsc-id="382">
<td data-afsc-id="383" style="font-size: 8px !important;">1234</td>
<td data-afsc-id="384" style="font-size: 8px !important;">1439</td>
<td data-afsc-id="385" style="font-size: 8px !important;">461 +<code data-afsc-id="386">⌈</code>(1439 - 1) / 1<code data-afsc-id="387">⌉</code>x 10 = 14841</td>
</tr>
</tbody>
      </table>
<ul data-afsc-id="388">
<li data-afsc-id="389" style="font-size: 8px !important;"><code data-afsc-id="390">1234</code>번 차량은 출차 내역이 없으므로, 23:59에 출차되었다고 간주합니다.</li>
</ul>

<hr data-afsc-id="391">

<p data-afsc-id="392" style="font-size: 8px !important;">​</p>

<h5 data-afsc-id="393" style="font-size: 7px !important;">제한시간 안내</h5>

<ul data-afsc-id="394">
<li data-afsc-id="395" style="font-size: 8px !important;">정확성 테스트 : 10초</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges