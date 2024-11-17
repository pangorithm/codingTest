use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let t = input.next().unwrap().parse::<u32>().unwrap();

    let mut fibonacci_arr: [[usize; 3]; 41] = [[0; 3]; 41];
    fibonacci_arr[0][0] = 1;
    fibonacci_arr[1][1] = 1;

    for _ in 0..t {
        let n = input.next().unwrap().parse::<usize>().unwrap();
        fibonacci(n, &mut fibonacci_arr);
        write!(output, "{} {}\n", fibonacci_arr[n][0], fibonacci_arr[n][1]).unwrap();
    }

    println!("{}", output);
}

fn fibonacci(n: usize, fibonacci_arr: &mut [[usize; 3]; 41]) -> usize {
    match n {
        0 => 0,
        1 => 1,
        _ => {
            if fibonacci_arr[n][2] == 0 {
                fibonacci_arr[n][2] =
                    fibonacci(n - 1, fibonacci_arr) + fibonacci(n - 2, fibonacci_arr);

                fibonacci_arr[n][0] = fibonacci_arr[n - 1][0] + fibonacci_arr[n - 2][0];
                fibonacci_arr[n][1] = fibonacci_arr[n - 1][1] + fibonacci_arr[n - 2][1];
            }

            fibonacci_arr[n][2]
        }
    }
}
