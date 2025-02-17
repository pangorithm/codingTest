use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let mut dp: [usize; 50001] = [0; 50001];

    for i in 1..=(n as f64).powf(0.5) as usize {
        let square = i * i;
        dp[square] = 1;
    }

    for i in 1..=n {
        if dp[i] == 0 {
            dp[i] = i;
            for j in 1..=(i as f64).powf(0.5) as usize {
                dp[i] = dp[i].min(dp[i - j * j] + 1);
            }
        }
    }

    write!(output, "{}\n", dp[n]).unwrap();

    println!("{}", output);
}
