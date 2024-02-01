def solution(park, routes):
    cols = len(park[0])
    rows = len(park)
    point = []
    x_point = []
    for i in range(rows):
        for j in range(cols):
            if park[i][j] == 'S':
                point.append(i)
                point.append(j)
            elif park[i][j] == 'X':
                x_point.append([i,j])
    for r in routes:
        way, num = r[0], int(r[2])
        if way == 'E' and point[1] +  num < cols:
            for i in range(num):
                point[1] += 1
                if point in x_point:
                    point[1] -= i+1
                    break
        elif way == 'W' and point[1] - num >= 0:
            for i in range(num):
                point[1] -= 1
                if point in x_point:
                    point[1] += i+1
                    break
        elif way == 'S' and point[0] + num < rows:
            for i in range(num):
                point[0] += 1
                if point in x_point:
                    point[0] -= i+1
                    break
        elif way == 'N' and point[0] - num >= 0:
            for i in range(num):
                point[0] -= 1
                if point in x_point:
                    point[0] += i+1
                    break
    return point