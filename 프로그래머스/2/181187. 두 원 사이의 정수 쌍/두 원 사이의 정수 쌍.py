import math
def solution(r1, r2):
    cnt_list = []
    for x in range(1,r1):
        y2 = int(math.sqrt(r2**2 - x**2))
        y1 = math.sqrt(r1**2 - x**2)
        if y1.is_integer():
            cnt_list.append(int(y2) - int(y1) + 1)
        else:
            cnt_list.append(int(y2) - int(y1))
    for x in range(r1,r2):
        cnt_list.append(int(math.sqrt(r2**2 - x**2)))
    cnt_list.append(r2-r1+1)
    
    return 4*sum(cnt_list)