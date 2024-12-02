use std::cmp::Reverse;
use std::collections::BinaryHeap;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();

    let mut binary_heap: BinaryHeap<Reverse<usize>> = BinaryHeap::new();

    for _ in 0..n {
        let x = input.next().unwrap().parse::<usize>().unwrap();
        if x > 0 {
            binary_heap.push(Reverse(x));
        } else {
            match binary_heap.pop() {
                Some(Reverse(value)) => write!(output, "{}\n", value).unwrap(),
                None => write!(output, "{}\n", 0).unwrap(),
            }
        }
    }

    println!("{}", output);
}
