use std::cmp::Ordering;
use std::collections::BinaryHeap;
use std::fmt::{self, Formatter, Write};
use std::io::{stdin, Read};

#[derive(Eq, PartialEq, Debug)]
struct Item(i32);

impl Ord for Item {
    fn cmp(&self, other: &Self) -> Ordering {
        let self_abs = self.0.abs();
        let other_abs = other.0.abs();
        match self_abs.cmp(&other_abs) {
            Ordering::Equal => other.0.cmp(&self.0), // 절대값이 같으면 작은 값이 우선
            other => other.reverse(),                // 절대값이 작은 값이 우선
        }
    }
}

impl PartialOrd for Item {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

impl fmt::Display for Item {
    fn fmt(&self, f: &mut Formatter) -> fmt::Result {
        write!(f, "{}", self.0)
    }
}

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();

    let mut heap = BinaryHeap::new();

    for _ in 0..n {
        let x = input.next().unwrap().parse::<i32>().unwrap();
        if x == 0 {
            write!(output, "{}\n", heap.pop().unwrap_or(Item(0))).unwrap();
        } else {
            heap.push(Item(x));
        }
    }

    println!("{}", output);
}
