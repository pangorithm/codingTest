use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let length = input.next().unwrap().parse::<usize>().unwrap();

    let mut com_list: Vec<Vec<usize>> = vec![vec![]; length];
    let mut is_infected: Vec<bool> = vec![false; length];
    let mut is_visited: Vec<bool> = vec![false; length];
    is_infected[0] = true;

    let link_count = input.next().unwrap().parse::<usize>().unwrap();
    for _ in 0..link_count {
        let l_node_num = input.next().unwrap().parse::<usize>().unwrap() - 1;
        let r_node_num = input.next().unwrap().parse::<usize>().unwrap() - 1;
        com_list[l_node_num].push(r_node_num);
        com_list[r_node_num].push(l_node_num);
    }

    search(0, &mut is_visited, &mut is_infected, &com_list);

    let mut count = -1; // 첫번째 컴퓨터 제외
    for value in is_infected {
        if value {
            count += 1;
        }
    }

    println!("{}", count);
}

fn search(
    index: usize,
    is_visited: &mut Vec<bool>,
    is_infected: &mut Vec<bool>,
    com_list: &Vec<Vec<usize>>,
) {
    is_visited[index] = true;
    if is_infected[index] {
        for next in &com_list[index] {
            is_infected[*next] = true;
            if !is_visited[*next] {
                search(*next, is_visited, is_infected, com_list);
            }
        }
    }
}
