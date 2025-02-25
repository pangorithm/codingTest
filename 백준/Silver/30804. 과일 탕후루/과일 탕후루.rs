use std::collections::HashMap;
use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();

    let mut sting = Vec::new();
    for _ in 0..n {
        let s = input.next().unwrap().parse::<usize>().unwrap();
        sting.push(s);
    }

    let mut count: usize = 0;
    let mut hash_map = HashMap::new();

    let mut start = 0;
    let mut end = 0;

    while end < n {
        let entry = hash_map.entry(sting[end]).or_insert(0);
        *entry += 1;
        while hash_map.len() > 2 {
            let entry = hash_map.get(&sting[start]).unwrap();
            if *entry == 1 {
                hash_map.remove(&sting[start]);
            } else {
                hash_map.insert(sting[start], entry - 1);
            }
            start += 1;
        }
        let length = end - start + 1;
        if length > count {
            count = length;
        }
        end += 1;
    }

    println!("{}", count);
}
