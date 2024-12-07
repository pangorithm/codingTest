use std::collections::BTreeMap;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let mut tree_map: BTreeMap<i32, Vec<usize>> = BTreeMap::new();

    for i in 0..n {
        let x = input.next().unwrap().parse::<i32>().unwrap();

        // tree_map.entry(x).or_insert(vec![]).push(i);
        if !tree_map.contains_key(&x) {
            tree_map.insert(x, vec![]);
        }
        let vec = tree_map.get_mut(&x).unwrap();
        vec.push(i);
    }

    let mut output_vec: Vec<usize> = vec![0; n];
    let mut ordinal = 0;
    for vec in tree_map.values() {
        for i in vec {
            output_vec[*i] = ordinal;
        }
        ordinal = ordinal + 1;
    }

    for ord in output_vec {
        write!(output, "{} ", ord).unwrap();
    }

    println!("{}", output);
}
