def solution(h1, m1, s1, h2, m2, s2):
    answer = 0
    # 1초에 시침이 움직이는 각도 = 0.008333..도 를 1 (myDgree)라 하자       [최소단위 각도를 구하기 위함]
    # 43200 myDgree = 360도
    # 시침보다 초침은 720배, 분침은 12배 빠르게 움직인다.
    # 초침이 1(myDgree) 움직이는데 걸리는 시간 = 1/720 = 0.0013888.. 초
    # 따라서 0.0013888...초를 1 (myMs)라 하자                            [최소단위 시간을 구하기 위함]
    
    # 1 myMs => 초침 1myDgree, 60 myMs => 분침 1myDgree, 720 myMs => 시침 1myDgree 움직임
    
    # 시간을 myMs로 환산
    d1 = (h1 * 3600 + m1 * 60 + s1)*720
    d2 = (h2 * 3600 + m2 * 60 + s2)*720
    h_pin, m_pin, s_pin = (d1//720)%43200, (d1//60)%43200, d1%43200 # 시작 핀 위치
    # 시계 구현
    for ms in range(1,d2-d1+2):
        # 알람, 43199myDgree 일때와 0 myDgree일때 둘다 알람이 울림;;
        # 아마 분침이 00시에 거의 다왔을때 초침하고 같이 넘어가는 듯 함
        if h_pin == s_pin or m_pin == s_pin:
            if s_pin != 43199:
                answer += 1
                
        if ms%60 == 0: 
            m_pin += 1
            if m_pin == 43200: m_pin = 0
            if ms%720 == 0:
                h_pin += 1
                if h_pin == 43200: h_pin = 0
        
        if s_pin == 43199: 
            s_pin = 0
        else:
            s_pin += 1
    return answer