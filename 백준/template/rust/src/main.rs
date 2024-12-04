use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let word = input.next().unwrap();

    for word in input {
        write!(output, "{}\n", word).unwrap();
    }

    println!("{}", output);
}
