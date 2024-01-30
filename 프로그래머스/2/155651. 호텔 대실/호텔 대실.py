def solution(book_time):
    timeTable = [0 for _ in range(1440)]
    timeMax = 0
    # 청소시간까지 고려해서 분으로 바꾸고 해당 분에 +1
    # 1번 예시의 경우 16:40분 부터 17:00분 까지는 3개의 예약이 있음으로
    # timeTable의 1000분(16:40분) 부터 1029분(17:09분) 까지는 3이 될 것
    for openTime, endTime in book_time:
        hOpen,mOpen = map(int, openTime.split(':'))
        hEnd,mEnd = map(int, endTime.split(':'))
        for m in range(hOpen*60+mOpen,hEnd*60+mEnd+10 if hEnd*60+mEnd+10 < 1440 else 1439):
            timeTable[m] += 1
            if timeMax < timeTable[m]: timeMax = timeTable[m]
    
    return timeMax