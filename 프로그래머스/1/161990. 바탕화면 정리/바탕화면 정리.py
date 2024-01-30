def solution(wallpaper):
    answer = []
    
    def sol0(wallpaper):
        col = len(wallpaper)
        row = len(wallpaper[0])
        # 북쪽부터 (#)위치 찾기
        for i in range(col):
            for j in range(row):
                if wallpaper[i][j] == '#':
                    answer.append(i)
                    break
            if wallpaper[i][j] == '#':
                    break
    def sol1(wallpaper):
        col = len(wallpaper)
        row = len(wallpaper[0])    
        # 서쪽부터 (#)위치 찾기
        for j in range(row):
            for i in range(col):
                if wallpaper[i][j] == '#':
                    answer.append(j)
                    break
            if wallpaper[i][j] == '#':
                    break
    def sol2(wallpaper):
        col = len(wallpaper)
        row = len(wallpaper[0])
        # 남쪽부터 (#)위치 찾기
        for i in range(col,-1,-1):
            for j in range(row,-1,-1):
                if wallpaper[i-1][j-1] == '#':
                    answer.append(i)
                    break
            if wallpaper[i-1][j-1] == '#':
                    break
    def sol3(wallpaper):
        col = len(wallpaper)
        row = len(wallpaper[0])    
        # 동쪽부터 (#)위치 찾기
        for j in range(row,-1,-1):
            for i in range(col,-1,-1):
                if wallpaper[i-1][j-1] == '#':
                    answer.append(j)
                    break
            if wallpaper[i-1][j-1] == '#':
                    break
    sol0(wallpaper)
    sol1(wallpaper)
    sol2(wallpaper)
    sol3(wallpaper)
    return answer