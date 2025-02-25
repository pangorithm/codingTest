use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();

    let mut map = vec![vec![0; m]; n];
    let mut queue: Vec<(i32, i32)> = Vec::new();

    for i in 0..n {
        for (j, ch) in input.next().unwrap().chars().enumerate() {
            match ch {
                // 'O' => map[i][j] = 0,
                'X' => map[i][j] = -1,
                'I' => {
                    queue.push((i as i32, j as i32));
                    map[i][j] = -1;
                }
                'P' => map[i][j] = 1,
                _ => (),
            }
        }
    }

    let mut answer: usize = 0;

    let moves = [(0, 1), (0, -1), (1, 0), (-1, 0)];
    while !queue.is_empty() {
        let (i, j) = queue.pop().unwrap();

        for (di, dj) in moves.iter() {
            let ni = i + di;
            let nj = j + dj;
            if ni >= 0 && ni < n as i32 && nj >= 0 && nj < m as i32 {
                if map[ni as usize][nj as usize] >= 0 {
                    if map[ni as usize][nj as usize] == 1 {
                        answer += 1;
                    }
                    queue.push((ni, nj));
                    map[ni as usize][nj as usize] = -1;
                }
            }
        }
    }

    let output = if answer > 0 {
        answer.to_string()
    } else {
        "TT".to_string()
    };

    println!("{}", output);
}
