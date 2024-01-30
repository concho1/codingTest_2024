from collections import deque 
def solution(board):
    answer = 0
    yLength, xLength, start, end = len(board), len(board[0]), (0,0), (0,0)
    movable = [(1,0), (-1,0), (0,1), (0,-1)]
    visitWayCnt = dict()
    for i in range(yLength):
        for j in range(xLength):
            if board[i][j] == 'R': 
                start = (i,j)
            if board[i][j] == 'G': 
                end = (i,j)
            visitWayCnt[(i,j)] = 0
    #print(start)
    visitQ = deque([start])
    visited = set([start])
    visitedWay = []
    
    while visitQ:
        y,x = visitQ.pop()
        visitedWay.append((y,x))
        if board[y][x] == 'G':
            break
        for i in range(4):
            tmY, tmX = y, x
            while 0 <= tmY+movable[i][0] < yLength and 0 <= tmX+movable[i][1] < xLength:
                if board[tmY+movable[i][0]][tmX+movable[i][1]] == 'D': break
                #print(tmY+movable[i][0] , tmX+movable[i][1])
                tmY+=movable[i][0]
                tmX+=movable[i][1]
            if not (tmY,tmX) in visited:
                #print((tmY,tmX))
                visitWayCnt[(tmY,tmX)] += (visitWayCnt[(y,x)]+1)
                visited.add((tmY,tmX))
                visitQ.appendleft((tmY,tmX))
    #print(visitedWay)
    #print(visitWayCnt)
    return -1 if visitWayCnt[end] == 0 else visitWayCnt[end]