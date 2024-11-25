use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();
    let mut list: Vec<usize> = vec![];

    list.push(input.next().unwrap().parse::<usize>().unwrap());
    for i in 1..n {
        let num = input.next().unwrap().parse::<usize>().unwrap();
        list.push(list[i - 1] + num);
    }

    for _ in 0..m {
        let start = input.next().unwrap().parse::<usize>().unwrap() - 1;
        let end = input.next().unwrap().parse::<usize>().unwrap() - 1;

        if start > 0 {
            write!(output, "{}\n", list[end] - list[start - 1]).unwrap();
        } else {
            write!(output, "{}\n", list[end]).unwrap();
        }
    }

    println!("{}", output);
}
