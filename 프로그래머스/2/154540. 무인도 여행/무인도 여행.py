from collections import deque

def solution(maps):
    answer = []
    startable = set()
    for i,row in enumerate(maps):
        for j,block in enumerate(row):
            if block != 'X':
                startable.add((i,j))
    
    movable = [(1,0),(-1,0),(0,-1),(0,1)]
    foodCntList = []
    while startable:
        start = startable.pop()
        visitQ = deque([start])
        visited = set([start])
        foodCnt = 0
        while visitQ:
            y,x = visitQ.pop()
            foodCnt += int(maps[y][x])
            for move in movable:
                dy,dx = y,x
                dy += move[0]
                dx += move[1]
                if 0 <= dx < len(maps[0]) and 0 <= dy < len(maps):
                    if not (dy,dx) in visited and maps[dy][dx] != 'X':
                        visitQ.appendleft((dy,dx))
                        visited.add((dy,dx))
                        
        foodCntList.append(foodCnt)
        startable -= visited
    foodCntList.sort()
    return [-1] if len(foodCntList) == 0 else foodCntList