func solution(storage []string, requests []string) int {
    cargo := make([][]rune, len(storage) + 2)
    cargo[0] = make([]rune, len(storage[0]) + 2)
    for i := range storage {
        row := append([]rune{0}, []rune(storage[i])...)
        row = append(row, 0)
        cargo[i + 1] = row
    }
    cargo[len(storage) + 1] = make([]rune, len(storage[0]) + 2)
    
    rest := len(storage) * len(storage[0])
    
    for _, req := range requests {
        if len(req) == 1 {
            visited := make([][]bool, len(cargo))
            for i := 0; i < len(cargo); i++ {
                visited[i] = make([]bool, len(cargo[i]))
            }
            stack := [][2]int{}
            stack = append(stack, [2]int{0, 0})
            tmp := [][2]int{}
            for len(stack) > 0 {
                p := stack[len(stack) - 1]
                stack = stack[:len(stack) - 1]
                if (cargo[p[0]][p[1]] == rune(req[0])) {
                    tmp = append(tmp, [2]int{p[0], p[1]})
                    rest--
                }
                if cargo[p[0]][p[1]] != 0 {
                    continue
                } 
                for _, a := range []int{-1, 1} {
                    ny := p[0] + a
                    if ny > 0 && ny < len(cargo) {
                        if !visited[ny][p[1]] {
                            stack = append(stack, [2]int{ny, p[1]})
                            visited[ny][p[1]] = true
                        }
                    }
                    
                    nx := p[1] + a
                    if nx > 0 && nx < len(cargo[0]) {
                        if !visited[p[0]][nx] {
                            stack = append(stack, [2]int{p[0], nx})
                            visited[p[0]][nx] = true
                        }                        
                    }
                }
            }
            for _, p := range tmp {
                cargo[p[0]][p[1]] = 0
            }
            
        } else {
            for i := 1; i < len(storage) + 1; i++ {
                for j := 1; j < len(storage[0]) + 1; j++ {
                    if cargo[i][j] == rune(req[0]) {
                        cargo[i][j] = 0
                        rest--
                    }
                }
            }
        }
    }
    
    return rest
}