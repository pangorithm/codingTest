use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let input = input.split_ascii_whitespace();

    // let n = input.next().unwrap().parse::<i32>().unwrap();
    // let word = input.next().unwrap();

    let mut output = String::new();

    for word in input {
        write!(output, "{}\n", word).unwrap();
    }

    println!("{}", output);
}
