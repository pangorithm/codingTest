use std::collections::HashMap;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let case = input.next().unwrap().parse::<usize>().unwrap();

    for _ in 0..case {
        let n = input.next().unwrap().parse::<usize>().unwrap();

        let mut map: HashMap<&str, Vec<&str>> = std::collections::HashMap::new();
        for _ in 0..n {
            let name = input.next().unwrap();
            let category = input.next().unwrap();
            map.entry(category).or_insert(Vec::new()).push(name);
        }

        let mut count: usize = 1;
        for vec in map.values() {
            count *= vec.len() + 1;
        }
        count -= 1;

        write!(output, "{}\n", count).unwrap();
    }

    println!("{}", output);
}
