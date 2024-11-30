use std::collections::VecDeque;
use std::fmt::Write;
use std::io::{stdin, Read};

struct Node {
    x: usize,
    y: usize,
}

fn main() {
    let mut output = String::new();

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let t = input.next().unwrap().parse::<usize>().unwrap();
    for _ in 0..t {
        let m = input.next().unwrap().parse::<usize>().unwrap();
        let n = input.next().unwrap().parse::<usize>().unwrap();
        let k = input.next().unwrap().parse::<usize>().unwrap();

        let mut map: Vec<Vec<bool>> = vec![vec![false; m]; n];
        for _ in 0..k {
            let x = input.next().unwrap().parse::<usize>().unwrap();
            let y = input.next().unwrap().parse::<usize>().unwrap();
            map[y][x] = true;
        }

        let mut count = 0;
        for i in 0..n {
            for j in 0..m {
                if map[i][j] {
                    let mut dq = VecDeque::new();
                    dq.push_back(Node { x: j, y: i });
                    dfs(&mut dq, &mut map);
                    // bfs(&mut dq, &mut map);
                    count = count + 1;
                }
            }
        }

        write!(output, "{}\n", count).unwrap();
    }

    println!("{}", output);
}

fn dfs(dq: &mut VecDeque<Node>, map: &mut Vec<Vec<bool>>) {
    let node = dq.pop_back();
    match node {
        Some(node) => {
            map[node.y][node.x] = false;
            let mut x_list: Vec<usize> = vec![];
            let mut y_list: Vec<usize> = vec![];

            if node.x > 0 {
                x_list.push(node.x - 1);
            }
            if node.x + 1 < map[0].len() {
                x_list.push(node.x + 1);
            }
            if node.y > 0 {
                y_list.push(node.y - 1);
            }
            if node.y + 1 < map.len() {
                y_list.push(node.y + 1);
            }

            for y in y_list {
                if map[y][node.x] {
                    dq.push_back(Node { x: node.x, y });
                    dfs(dq, map);
                }
            }
            for x in x_list {
                if map[node.y][x] {
                    dq.push_back(Node { x, y: node.y });
                    dfs(dq, map);
                }
            }
        }
        None => {}
    }
}

fn bfs(dq: &mut VecDeque<Node>, map: &mut Vec<Vec<bool>>) {
    let node = dq.pop_front();
    match node {
        Some(node) => {
            map[node.y][node.x] = false;
            let mut x_list: Vec<usize> = vec![];
            let mut y_list: Vec<usize> = vec![];

            if node.x > 0 {
                x_list.push(node.x - 1);
            }
            if node.x + 1 < map[0].len() {
                x_list.push(node.x + 1);
            }
            if node.y > 0 {
                y_list.push(node.y - 1);
            }
            if node.y + 1 < map.len() {
                y_list.push(node.y + 1);
            }

            for y in y_list {
                if map[y][node.x] {
                    dq.push_back(Node { x: node.x, y });
                    bfs(dq, map);
                }
            }
            for x in x_list {
                if map[node.y][x] {
                    dq.push_back(Node { x, y: node.y });
                    bfs(dq, map);
                }
            }
        }
        None => {}
    }
}
