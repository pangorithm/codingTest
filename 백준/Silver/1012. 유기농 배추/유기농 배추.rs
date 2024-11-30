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
                    let mut dq = Vec::new();
                    dq.push(Node { x: j, y: i });
                    while dq.len() > 0 {
                        let node = dq.pop();
                        match node {
                            Some(node) => {
                                if map[node.y][node.x] {
                                    map[node.y][node.x] = false;

                                    if node.x > 0 {
                                        dq.push(Node {
                                            x: node.x - 1,
                                            y: node.y,
                                        });
                                    }
                                    if node.x + 1 < map[0].len() {
                                        dq.push(Node {
                                            x: node.x + 1,
                                            y: node.y,
                                        });
                                    }
                                    if node.y > 0 {
                                        dq.push(Node {
                                            x: node.x,
                                            y: node.y - 1,
                                        });
                                    }
                                    if node.y + 1 < map.len() {
                                        dq.push(Node {
                                            x: node.x,
                                            y: node.y + 1,
                                        });
                                    }
                                }
                            }
                            None => {}
                        }
                    }
                    count = count + 1;
                }
            }
        }

        write!(output, "{}\n", count).unwrap();
    }

    println!("{}", output);
}
