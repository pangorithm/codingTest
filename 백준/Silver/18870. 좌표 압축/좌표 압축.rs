use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input
        .split_ascii_whitespace()
        .map(|s| s.parse::<i32>().unwrap());

    let n = input.next().unwrap() as usize;
    let mut num_indices: Vec<_> = input.enumerate().collect();

    num_indices.sort_unstable_by_key(|&(_, num)| num);

    let mut compressed = vec![0; n];
    let mut unique_count = 0;

    for i in 1..n {
        let (index, num) = num_indices[i];

        if num != num_indices[i - 1].1 {
            unique_count += 1;
        }

        compressed[index] = unique_count;
    }

    for ord in compressed {
        write!(output, "{} ", ord).unwrap();
    }

    println!("{}", output);
}
