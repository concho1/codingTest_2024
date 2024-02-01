def solution(name, yearning, photo):
    n_y = dict(zip(name, yearning))
    sol = []
    for p in photo:
        scor = 0
        for p_name in p:
            try:
                scor += n_y[p_name]
            except:
                pass
        sol.append(scor)
    return sol