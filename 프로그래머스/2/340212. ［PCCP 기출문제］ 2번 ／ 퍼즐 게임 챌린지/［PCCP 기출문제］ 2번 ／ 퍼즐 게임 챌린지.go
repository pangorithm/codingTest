func solution(diffs []int, times []int, limit int64) int {        
    l := 1
    r := 1
    for _, v := range diffs {
        if r < v {
            r = v
        }
    }
    
    for l < r {
        mid := (l + r) >> 1
        if canSolve(diffs, times, limit, mid) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    
    return l
}

func firstSolveTime(diff int, time int, time_prev int64, level int) int64 {
    if diff > level {
        return int64(time * (diff - level + 1)) + time_prev * int64(diff - level)
    } else {
        return int64(time)
    }
}

func canSolve(diffs []int, times []int, limit int64, level int) bool {
    sum := int64(0)
    for i := 0; i < len(diffs); i++ {
        time_prev := int64(0)
        if i > 0 {
            time_prev = int64(times[i - 1])
        }
        sum += firstSolveTime(diffs[i], times[i], time_prev, level)
        if sum > limit {
            return false
        }
    }
    return true
}