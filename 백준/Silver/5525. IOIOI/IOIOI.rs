use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let _m = input.next().unwrap().parse::<usize>().unwrap();
    let word = input.next().unwrap();

    let pn = format!("I{}", "OI".repeat(n));
    let count = word
        .as_bytes()
        .windows(pn.len())
        .filter(|&w| w == pn.as_bytes())
        .count();

    println!("{}", count);
}
