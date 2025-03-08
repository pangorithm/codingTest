import (
    "fmt"
    "strings"
    "strconv"
)

func strToIntArr(time string) (int, int) {
    parts := strings.Split(time, ":")
    min, _  := strconv.Atoi(parts[0])
    sec, _  := strconv.Atoi(parts[1])
    return min, sec
}

func solution(video_len string, pos string, op_start string, op_end string, commands []string) string {
    if pos >= op_start && pos <= op_end {
        pos = op_end
    }
    
    posMin, posSec := strToIntArr(pos)
    for _, v := range commands {
        switch v {
            case "prev":
                posSec -= 10
                if posSec < 0 {
                    if posMin == 0 {
                        posMin = 0
                        posSec = 0
                    } else {
                        posMin -= 1
                        posSec += 60                        
                    }
                }
            case "next":
                posSec += 10
                if posSec >= 60 {
                    posMin += 1
                    posSec -= 60
                }
        }
        newPos := fmt.Sprintf("%02d:%02d", posMin, posSec)
        if newPos > video_len {
            posMin, posSec = strToIntArr(video_len)
        } else if newPos >= op_start && newPos <= op_end {
            posMin, posSec = strToIntArr(op_end)
        }
        
    }
    result := fmt.Sprintf("%02d:%02d", posMin, posSec)
    return result
}