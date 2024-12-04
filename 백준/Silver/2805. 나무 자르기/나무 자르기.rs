use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace();

    let n = input.next().unwrap().parse::<usize>().unwrap();
    let m = input.next().unwrap().parse::<usize>().unwrap();
    let mut tree_list: Vec<usize> = vec![];
    for _ in 0..n {
        tree_list.push(input.next().unwrap().parse::<usize>().unwrap());
    }

    tree_list.sort();

    let h = find_h(&tree_list, &m);
    println!("{}", h);
}

// 해당 높이보다 큰 나무 중 가장 작은 나무 찾기
fn find_tree_index(tree_list: &Vec<usize>, h: &usize) -> usize {
    let mut l = 0;
    let mut r = tree_list.len();
    while l < r {
        let mid = (l + r) / 2;
        if tree_list[mid] <= *h {
            l = mid + 1
        } else {
            r = mid;
        }
    }
    l
}

// 최대 높이 찾기
fn find_h(tree_list: &Vec<usize>, m: &usize) -> usize {
    let mut l = 0;
    let mut r = tree_list[tree_list.len() - 1];
    let mut result = 0;
    while l < r {
        let mid = (l + r) / 2;
        let start_index = find_tree_index(tree_list, &mid);
        let sum: usize = tree_list[start_index..]
            .iter()
            .map(|&height| height - mid)
            .sum();
        if sum >= *m {
            result = mid;
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    result
}
