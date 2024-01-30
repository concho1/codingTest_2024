import queue

def solution(priorities, location):
    answer = 0
    proQ, cnt = queue.Queue(), 0
    for loca, pri in enumerate(priorities):
        proQ.put([pri,loca])
    priorities.sort(reverse = True)

    while not proQ.empty():
        pro = proQ.get()
        idx_tm = priorities.index(pro[0]) 
        # index 메서드는 처음 일치하는 값의 idx를 반환함 
        if idx_tm != 0:
            proQ.put(pro)
        else:
            cnt += 1
            if pro[1] == location:  break
            del priorities[idx_tm]
    return cnt