use std::collections::HashSet;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<i32>().unwrap();
    let m = input.next().unwrap().parse::<i32>().unwrap();

    let mut unheard_set: HashSet<&str> = HashSet::new();
    let mut unseen_set: HashSet<&str> = HashSet::new();

    for _ in 0..n {
        unheard_set.insert(input.next().unwrap());
    }
    for _ in 0..m {
        unseen_set.insert(input.next().unwrap());
    }

    let mut intersection_vec: Vec<&str> = unheard_set.intersection(&unseen_set).cloned().collect();
    intersection_vec.sort();

    write!(output, "{}\n", intersection_vec.len()).unwrap();
    for word in intersection_vec {
        write!(output, "{}\n", word).unwrap();
    }

    println!("{}", output);
}
