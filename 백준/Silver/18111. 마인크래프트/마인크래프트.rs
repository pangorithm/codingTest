use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();
    let b = input.next().unwrap().parse::<usize>().unwrap();

    let mut map: Vec<Vec<i32>> = vec![vec![0; m]; n];

    let mut max_h: i32 = 0;
    let mut min_h: i32 = 256;
    for i in 0..n {
        for j in 0..m {
            let h = input.next().unwrap().parse::<i32>().unwrap();
            map[i][j] = h;
            if h > max_h {
                max_h = h;
            }
            if h < min_h {
                min_h = h;
            }
        }
    }

    let mut result = (i32::MAX, 0);

    for result_h in min_h..=max_h {
        let mut time = 0;
        let mut inventory = b as i32;
        for i in 0..n {
            for j in 0..m {
                let h = map[i][j];
                let diff = h as i32 - result_h as i32;
                if diff > 0 {
                    time += diff * 2;
                    inventory += diff;
                } else if diff < 0 {
                    time -= diff;
                    inventory -= -diff;
                }
            }
        }

        if inventory >= 0{
            if time <= result.0 {
                result = (time, result_h);
            }
        } else {
            break;
        }
    }

    println!("{} {}", result.0, result.1);
}
