def solution(players, callings):
    player_indices = {player: idx for idx, player in enumerate(players)}
    for call in callings:
        i = player_indices[call]
        players[i], players[i-1] = players[i-1], players[i]
        player_indices[call] -= 1
        player_indices[players[i]] += 1
        
    return players