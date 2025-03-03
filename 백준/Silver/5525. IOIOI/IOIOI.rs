use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();
    let word = input.next().unwrap();

    let pn = format!("I{}", "OI".repeat(n));
    let mut count = 0;

    let mut i = pn.len();
    let len = 2 * n + 1;
    while i <= m {
        if &word[i - len..i] == pn {
            count += 1;
        } else {
            i += 1;
            continue;
        }
        let mut j = i + 2;
        i = j;
        while j <= m {
            match &word[j - 2..j] {
                "OI" => {
                    count += 1;
                    j += 2;
                    i = j;
                }
                "IO" => {
                    i += len - 2;
                    break;
                }
                "II" => {
                    i += len - 1;
                    break;
                }
                "OO" => {
                    i += len;
                    break;
                }
                _ => (),
            }
        }
    }

    println!("{}", count);
}
