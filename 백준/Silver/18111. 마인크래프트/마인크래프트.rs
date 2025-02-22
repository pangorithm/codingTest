use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();
    let b = input.next().unwrap().parse::<usize>().unwrap();

    let length = n * m;
    let mut map: Vec<i32> = vec![0; length];

    let mut max_h: i32 = 0;
    let mut min_h: i32 = 256;
    for i in 0..length {
        let h = input.next().unwrap().parse::<i32>().unwrap();
        map[i] = h;
        if h > max_h {
            max_h = h;
        }
        if h < min_h {
            min_h = h;
        }
    }

    let mut result = (i32::MAX, 0);

    for result_h in min_h..=max_h {
        let mut time = 0;
        let mut inventory = b as i32;
        map.iter().for_each(|&h| {
            let diff = h - result_h;
            if diff > 0 {
                time += diff * 2;
                inventory += diff;
            } else if diff < 0 {
                time -= diff;
                inventory += diff;
            }
        });

        if inventory >= 0 {
            if time <= result.0 {
                result = (time, result_h);
            }
        } else {
            break;
        }
    }

    println!("{} {}", result.0, result.1);
}
