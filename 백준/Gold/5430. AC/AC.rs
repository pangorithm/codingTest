use std::collections::VecDeque;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let t: i32 = input.next().unwrap().parse::<i32>().unwrap();

    let mut output = String::new();

    for _ in 0..t {
        let cmd = input.next().unwrap();
        let length: usize = input.next().unwrap().parse::<usize>().unwrap();

        if length < cmd.chars().filter(|&c| c == 'D').count() {
            writeln!(output, "{}", "error").unwrap();
            input.next().unwrap();
            continue;
        }

        let mut dq: VecDeque<i32> = input
            .next()
            .unwrap()
            .trim_start_matches("[")
            .trim_end_matches("]")
            .split(",")
            .flat_map(|s| s.parse::<i32>().ok())
            .collect();

        let mut is_reverse = false;

        for char in cmd.chars() {
            match char {
                'R' => is_reverse = !is_reverse,
                'D' => {
                    if is_reverse {
                        let _ = dq.pop_back();
                    } else {
                        let _ = dq.pop_front();
                    }
                }
                _ => {}
            }
        }

        if is_reverse {
            dq.make_contiguous().reverse();
        }

        writeln!(
            output,
            "[{}]",
            dq.iter()
                .map(|n| n.to_string())
                .collect::<Vec<String>>()
                .join(",")
        )
        .unwrap();
    }

    println!("{}", output);
}
