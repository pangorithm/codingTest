# [level 2] 오픈채팅방 - 42888 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42888) 

### 성능 요약

메모리: 181 MB, 시간: 110.92 ms

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

### 채점결과

Empty

### 문제 설명

<h2 data-afsc-id="55" style="font-size: 11px !important;">오픈채팅방</h2>

<p data-afsc-id="56" style="font-size: 8px !important;">카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할 수 있는데, 본래 닉네임이 아닌 가상의 닉네임을 사용하여 채팅방에 들어갈 수 있다.</p>

<p data-afsc-id="57" style="font-size: 8px !important;">신입사원인 김크루는 카카오톡 오픈 채팅방을 개설한 사람을 위해, 다양한 사람들이 들어오고, 나가는 것을 지켜볼 수 있는 관리자창을 만들기로 했다. 채팅방에 누군가 들어오면 다음 메시지가 출력된다.</p>

<p data-afsc-id="58" style="font-size: 8px !important;">"[닉네임]님이 들어왔습니다."</p>

<p data-afsc-id="59" style="font-size: 8px !important;">채팅방에서 누군가 나가면 다음 메시지가 출력된다.</p>

<p data-afsc-id="60" style="font-size: 8px !important;">"[닉네임]님이 나갔습니다."</p>

<p data-afsc-id="61" style="font-size: 8px !important;">채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.</p>

<ul data-afsc-id="62">
<li data-afsc-id="63" style="font-size: 8px !important;">채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.</li>
<li data-afsc-id="64" style="font-size: 8px !important;">채팅방에서 닉네임을 변경한다.</li>
</ul>

<p data-afsc-id="65" style="font-size: 8px !important;">닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다. </p>

<p data-afsc-id="66" style="font-size: 8px !important;">예를 들어, 채팅방에 "Muzi"와 "Prodo"라는 닉네임을 사용하는 사람이 순서대로 들어오면 채팅방에는 다음과 같이 메시지가 출력된다.</p>

<p data-afsc-id="67" style="font-size: 8px !important;">"Muzi님이 들어왔습니다."<br data-afsc-id="68">
"Prodo님이 들어왔습니다."</p>

<p data-afsc-id="69" style="font-size: 8px !important;">채팅방에 있던 사람이 나가면 채팅방에는 다음과 같이 메시지가 남는다.</p>

<p data-afsc-id="70" style="font-size: 8px !important;">"Muzi님이 들어왔습니다."<br data-afsc-id="71">
"Prodo님이 들어왔습니다."<br data-afsc-id="72">
"Muzi님이 나갔습니다."</p>

<p data-afsc-id="73" style="font-size: 8px !important;">Muzi가 나간후 다시 들어올 때, Prodo 라는 닉네임으로 들어올 경우 기존에 채팅방에 남아있던 Muzi도 Prodo로 다음과 같이 변경된다.</p>

<p data-afsc-id="74" style="font-size: 8px !important;">"Prodo님이 들어왔습니다."<br data-afsc-id="75">
"Prodo님이 들어왔습니다."<br data-afsc-id="76">
"Prodo님이 나갔습니다."<br data-afsc-id="77">
"Prodo님이 들어왔습니다."</p>

<p data-afsc-id="78" style="font-size: 8px !important;">채팅방은 중복 닉네임을 허용하기 때문에, 현재 채팅방에는 Prodo라는 닉네임을 사용하는 사람이 두 명이 있다. 이제, 채팅방에 두 번째로 들어왔던 Prodo가 Ryan으로 닉네임을 변경하면 채팅방 메시지는 다음과 같이 변경된다.</p>

<p data-afsc-id="79" style="font-size: 8px !important;">"Prodo님이 들어왔습니다."<br data-afsc-id="80">
"Ryan님이 들어왔습니다."<br data-afsc-id="81">
"Prodo님이 나갔습니다."<br data-afsc-id="82">
"Prodo님이 들어왔습니다."</p>

<p data-afsc-id="83" style="font-size: 8px !important;">채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.</p>

<h5 data-afsc-id="84" style="font-size: 7px !important;">제한사항</h5>

<ul data-afsc-id="85">
<li data-afsc-id="86" style="font-size: 8px !important;">record는 다음과 같은 문자열이 담긴 배열이며, 길이는 <code data-afsc-id="87">1</code> 이상 <code data-afsc-id="88">100,000</code> 이하이다.</li>
<li data-afsc-id="89" style="font-size: 8px !important;">다음은 record에 담긴 문자열에 대한 설명이다.

<ul data-afsc-id="90">
<li data-afsc-id="91" style="font-size: 8px !important;">모든 유저는 [유저 아이디]로 구분한다.</li>
<li data-afsc-id="92" style="font-size: 8px !important;">[유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")</li>
<li data-afsc-id="93" style="font-size: 8px !important;">[유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")</li>
<li data-afsc-id="94" style="font-size: 8px !important;">[유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")</li>
<li data-afsc-id="95" style="font-size: 8px !important;">첫 단어는 Enter, Leave, Change 중 하나이다.</li>
<li data-afsc-id="96" style="font-size: 8px !important;">각 단어는 공백으로 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다.</li>
<li data-afsc-id="97" style="font-size: 8px !important;">유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다.</li>
<li data-afsc-id="98" style="font-size: 8px !important;">유저 아이디와 닉네임의 길이는 <code data-afsc-id="99">1</code> 이상 <code data-afsc-id="100">10</code> 이하이다.</li>
<li data-afsc-id="101" style="font-size: 8px !important;">채팅방에서 나간 유저가 닉네임을 변경하는 등 잘못 된 입력은 주어지지 않는다.</li>
</ul></li>
</ul>

<h5 data-afsc-id="102" style="font-size: 7px !important;">입출력 예</h5>
<table class="table" data-afsc-id="103">
        <thead data-afsc-id="104"><tr data-afsc-id="105">
<th data-afsc-id="106" style="font-size: 8px !important;">record</th>
<th data-afsc-id="107" style="font-size: 8px !important;">result</th>
</tr>
</thead>
        <tbody data-afsc-id="108"><tr data-afsc-id="109">
<td data-afsc-id="110" style="font-size: 8px !important;"><code data-afsc-id="111">["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]</code></td>
<td data-afsc-id="112" style="font-size: 8px !important;"><code data-afsc-id="113">["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]</code></td>
</tr>
</tbody>
      </table>
<h5 data-afsc-id="114" style="font-size: 7px !important;">입출력 예 설명</h5>

<p data-afsc-id="115" style="font-size: 8px !important;">입출력 예 #1<br data-afsc-id="116">
문제의 설명과 같다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges