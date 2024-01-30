def solution(targets):
    answer = 0
    targets.sort(key=lambda x : x[1])
    length = len(targets)
    i = 0
    tm_i = 1
    cnt = 1
    while tm_i < length:
        if targets[i][1] <= targets[tm_i][0]:
            i = tm_i
            cnt += 1
        tm_i += 1
    return cnt