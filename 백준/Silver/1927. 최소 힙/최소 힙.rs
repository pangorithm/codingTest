use std::cmp::Ordering;
use std::collections::BinaryHeap;
use std::fmt::Write;
use std::io::{stdin, Read};

// 숫자를 저장할 구조체 정의
#[derive(Eq, PartialEq)] // Eq와 PartialEq는 BinaryHeap 사용에 필요
struct MinHeapItem {
    value: u32, // 저장할 숫자
}

// `Ord` 트레이트를 구현하여 최소 힙 동작 정의
impl Ord for MinHeapItem {
    fn cmp(&self, other: &Self) -> Ordering {
        other.value.cmp(&self.value) // 비교 순서를 뒤집어 최소 힙으로 동작
    }
}

// `PartialOrd` 트레이트도 구현 (필수)
impl PartialOrd for MinHeapItem {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other)) // Ord의 cmp를 활용
    }
}

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<u32>().unwrap();

    let mut binary_heap: BinaryHeap<MinHeapItem> = BinaryHeap::new();

    for _ in 0..n {
        let x = input.next().unwrap().parse::<u32>().unwrap();
        if x > 0 {
            binary_heap.push(MinHeapItem { value: x });
        } else {
            match binary_heap.pop() {
                Some(MinHeapItem { value }) => write!(output, "{}\n", value).unwrap(),
                None => write!(output, "{}\n", 0).unwrap(),
            }
        }
    }

    println!("{}", output);
}
