func solution(players []int, m int, k int) int {
    length := len(players)
    answer := 0
    servers := make([]int, length)
    
    for i := 0; i < length; i++ {
        if players[i] > m * servers[i] {
            addServer := (players[i] - m * servers[i]) / m
            answer += addServer
            for j := i; j < i + k && j < length; j++ {
                servers[j] += addServer
            }
        }
    }
    
    return answer
}