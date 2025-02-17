use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();

    let mut numbers = Vec::new();
    let mut operators = Vec::new();
    let mut num = String::new();

    for c in input.chars() {
        if c.is_numeric() {
            num.push(c);
        } else {
            if !num.is_empty() {
                numbers.push(num.clone());
                num.clear();
            }
            operators.push(c);
        }
    }
    if !num.is_empty() {
        numbers.push(num);
    }

    let mut answers = 0;

    let first_minus = operators
        .iter()
        .position(|&x| x == '-')
        .unwrap_or(operators.len());

    for i in 0..numbers.len() {
        if i <= first_minus {
            answers += numbers[i].parse::<i32>().unwrap();
        } else {
            answers -= numbers[i].parse::<i32>().unwrap();
        }
    }

    write!(output, "{}\n", answers).unwrap();

    println!("{}", output);
}
