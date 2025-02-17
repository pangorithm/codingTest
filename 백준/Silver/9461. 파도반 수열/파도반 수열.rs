use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let mut dp: Vec<usize> = vec![0; 101];
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;
    dp[6] = 3;

    let t = input.next().unwrap().parse::<usize>().unwrap();

    for _ in 0..t {
        let n = input.next().unwrap().parse::<usize>().unwrap();

        write!(output, "{}\n", get_p_n(n, &mut dp)).unwrap();
    }

    println!("{}", output);
}

fn get_p_n(n: usize, dp: &mut Vec<usize>) -> usize {
    if dp[n] != 0 {
        return dp[n];
    }

    dp[n] = get_p_n(n - 1, dp) + get_p_n(n - 5, dp);

    dp[n]
}
