use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();

    let mut p_arr: Vec<usize> = Vec::with_capacity(n);

    for _ in 0..n {
        p_arr.push(input.next().unwrap().parse::<usize>().unwrap());
    }

    p_arr.sort();

    for i in (0..p_arr.len() - 1).rev() {
        for j in (i + 1)..p_arr.len() {
            p_arr[j] = p_arr[j] + p_arr[i];
        }
    }

    let mut sum = 0;
    for i in 0..n {
        sum = sum + p_arr[i];
    }

    println!("{}", sum);
}