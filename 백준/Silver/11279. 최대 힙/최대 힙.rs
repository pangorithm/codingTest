use std::collections::BinaryHeap;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let mut heap = BinaryHeap::new();

    for _ in 0..n {
        let x = input.next().unwrap().parse::<usize>().unwrap();

        if x == 0 {
            let max = heap.pop().unwrap_or(0);
            write!(output, "{}\n", max).unwrap();
        } else {
            heap.push(x);
        }
    }

    println!("{}", output);
}
