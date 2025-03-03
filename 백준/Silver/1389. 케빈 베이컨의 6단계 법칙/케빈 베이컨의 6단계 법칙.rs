use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();

    let mut dist = vec![vec![usize::MAX >> 1; n]; n];
    for i in 0..n {
        dist[i][i] = 0;
    }

    for _ in 0..m {
        let a = input.next().unwrap().parse::<usize>().unwrap() - 1;
        let b = input.next().unwrap().parse::<usize>().unwrap() - 1;
        dist[a][b] = 1;
        dist[b][a] = 1;
    }

    for m in 0..n {
        for s in 0..n {
            for e in 0..n {
                dist[s][e] = dist[s][e].min(dist[s][m] + dist[m][e]);
            }
        }
    }

    let sum: Vec<usize> = dist.iter().map(|x| x.iter().sum()).collect();
    let mut answer = 0;

    for i in 0..n {
        if sum[answer] > sum[i] {
            answer = i;
        }
    }

    println!("{}", answer + 1);
}
