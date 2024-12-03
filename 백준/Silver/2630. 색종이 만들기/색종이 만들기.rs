use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let mut paper: Vec<Vec<u8>> = vec![vec![0; n]; n];

    for i in 0..n {
        for j in 0..n {
            paper[i][j] = input.next().unwrap().parse::<u8>().unwrap();
        }
    }

    let res = split(&paper, 0, 0, n);

    println!("{}\n{}", res[0], res[1]);
}

fn split(paper: &Vec<Vec<u8>>, start_y: usize, start_x: usize, size: usize) -> [usize; 2] {
    for i in start_y..start_y + size {
        for j in start_x..start_x + size {
            if paper[start_y][start_x] != paper[i][j] {
                let half_size = size / 2;
                let mid_y = start_y + half_size;
                let mid_x = start_x + half_size;

                let results = [
                    split(paper, start_y, start_x, half_size),
                    split(paper, start_y, mid_x, half_size),
                    split(paper, mid_y, start_x, half_size),
                    split(paper, mid_y, mid_x, half_size),
                ];

                return results
                    .iter()
                    .fold([0, 0], |acc, res| [acc[0] + res[0], acc[1] + res[1]]);
            }
        }
    }

    match paper[start_y][start_x] {
        0 => return [1, 0],
        1 => return [0, 1],
        _ => return [0, 0],
    }
}
