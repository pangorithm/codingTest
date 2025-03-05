func solution(schedules []int, timelogs [][]int, startday int) int {
    answer := 0
    n := len(schedules);
    
loop:
    for i := 0; i < n; i++ {
        lineSchedule := schedules[i] + 10
        if lineSchedule % 100 >= 60 {
            lineSchedule += 40
        }
        
        for days := 0; days < 7; days++ {
            day := (days + startday) % 7 
            if day == 0 || day == 6 {
                continue
            }
            if lineSchedule < timelogs[i][days] {
                continue loop
            }
        }
        answer += 1
    }
    return answer
}