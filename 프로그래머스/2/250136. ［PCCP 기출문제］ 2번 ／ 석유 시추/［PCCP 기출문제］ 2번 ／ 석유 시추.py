from collections import deque

def solution(land):
    def dfs(start, land_map, total_dung):
        move = [(1,0),(-1,0),(0,-1),(0,1)]
        vist_que = deque([start])
        visted_x_set = set()
        cnt = 0
        while len(vist_que) != 0:
            y,x = vist_que.popleft()
            visted_x_set.add(x)
            cnt += 1
            for m in move:
                dy, dx = y, x
                dy -= m[0]
                dx -= m[1]
                if 0 <= dy < len(land_map) and 0 <= dx < len(land_map[0]):
                    if not (dy,dx) in total_dung and land_map[dy][dx] == 1:
                        vist_que.append((dy,dx))
                        total_dung.add((dy,dx))

        return visted_x_set, cnt, total_dung
        
    # 덩이리 set 만들기
    total_dung = set()
    dung_list = [0 for _ in range(len(land[0]))]
    for j in range(len(land[0])):
        for i in range(len(land)):
            if land[i][j] == 1 and not (i,j) in total_dung:
                total_dung.add((i,j))
                dung_x, cnt, total_dung = dfs((i,j), land, total_dung)
                for x in dung_x:
                    dung_list[x] += cnt
                    
    return max(dung_list)
                
                