use std::collections::HashMap;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();

    let mut map: HashMap<&str, &str> = HashMap::new();
    for _ in 0..n {
        let site = input.next().unwrap();
        let pw = input.next().unwrap();
        map.insert(site, pw);
    }

    for _ in 0..m {
        let site = input.next().unwrap();
        write!(output, "{}\n", map.get(site).unwrap()).unwrap();
    }

    println!("{}", output);
}
