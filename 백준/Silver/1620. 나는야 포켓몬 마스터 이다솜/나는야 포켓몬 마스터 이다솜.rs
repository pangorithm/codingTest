use std::collections::HashMap;
use std::fmt::Write;
use std::io::{stdin, Read};

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();

    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();

    let mut arr: Vec<&str> = vec!["포켓몬"];
    let mut map: HashMap<&str, usize> = HashMap::new();
    for i in 1..=n {
        let pocketmon = input.next().unwrap();
        arr.push(pocketmon);
        map.insert(pocketmon, i);
    }

    for _ in 0..m {
        let question = input.next().unwrap();
        let result = question.parse::<usize>();

        match result {
            Ok(value) => write!(output, "{}\n", arr[value]).unwrap(),
            Err(_e) => write!(output, "{}\n", map.get(question).unwrap()).unwrap(),
        }
    }

    println!("{}", output);
}
