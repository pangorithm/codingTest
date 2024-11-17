use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let t = input.next().unwrap().parse::<u32>().unwrap();

    let mut fibonacci_arr: [[usize; 2]; 41] = [[0; 2]; 41];
    fibonacci_arr[0][0] = 1;
    fibonacci_arr[1][1] = 1;

    for i in 2..41 {
        fibonacci_arr[i][0] = fibonacci_arr[i - 1][0] + fibonacci_arr[i - 2][0];
        fibonacci_arr[i][1] = fibonacci_arr[i - 1][1] + fibonacci_arr[i - 2][1];
    }

    for _ in 0..t {
        let n = input.next().unwrap().parse::<usize>().unwrap();
        write!(output, "{} {}\n", fibonacci_arr[n][0], fibonacci_arr[n][1]).unwrap();
    }

    println!("{}", output);
}
