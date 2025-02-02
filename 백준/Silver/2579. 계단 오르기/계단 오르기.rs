use std::cmp::max;
use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();

    let mut stairs: Vec<usize> = vec![0];
    for _ in 0..n {
        let score = input.next().unwrap().parse::<usize>().unwrap();
        stairs.push(score);
    }

    let mut dp: Vec<Vec<usize>> = vec![vec![0; 2]; n + 1];
    dp[1][1] = stairs[1];
    if n >= 2 {
        dp[2][0] = stairs[1] + stairs[2];
        dp[2][1] = stairs[2];
        for i in 3..=n {
            dp[i][0] = dp[i - 1][1] + stairs[i];
            dp[i][1] = max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
        }
    }

    println!("{}", max(dp[n][0], dp[n][1]));
}
