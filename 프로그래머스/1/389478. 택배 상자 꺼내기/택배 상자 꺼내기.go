func solution(n int, w int, num int) int {
    answer := n / w
    unders := num / w
    nRem := n % w
    numRem := num % w
    if nRem == 0 {
        answer -= 1
        nRem = 6
    }
    if numRem == 0 {
        unders -= 1
        numRem = 6
    }
    if answer & 1 == unders & 1 {
        if nRem >= numRem {
            answer += 1
        }
    } else {
        if w - nRem < numRem {
            answer += 1            
        }
    }
    return answer - unders
}