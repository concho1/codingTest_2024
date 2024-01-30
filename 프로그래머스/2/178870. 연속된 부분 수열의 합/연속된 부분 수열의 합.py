
def solution(sequence, k):
    """ 연속된 부분 수열의 합

    sol. 
    누적 합 행렬을 사용하여 구간합을 빠르게 계산할 수 있도록 한다.
    수열은 오름차순으로 정렬되어 있고, 연속된 수열의 합을 계산하기 때문에 
    두 개의 포인터를 사용하여 목표 값 k 를 찾도록 한다

    앞쪽 포인터는 그대로 두고 뒤쪽 포인터를 이동시켜가며 k 값에 가까워지는지 확인한다
    만약 구간 합이 k 보다 작다면 더 큰 수가 필요한 것 이기 때문에 뒤쪽 포인터를 더 뒤로 이동시킨다
    만약 구간 합이 k 보다 크가면 구간 내에서 일정 값을 덜어내야 하기 때문에 작은 값들을 먼저 버리도록 앞쪽 포인터를 뒤로 이동시킨다

    만약 구간 합이 k 인 지점을 찾았다면 정답을 기록한다. 
    이 때 구간합에 사용된 요소 개수가 작은 구간을 선택하도록 한다.


    """
    answer = []
    arr = [sequence[0]]
    for i in range(1, len(sequence)):
        num = sequence[i] + arr[-1]
        arr.append(num)

    start = 0
    end = 0
    answer = None
    answer_idx = None
    cnt = 0
    while start <= end and end < len(sequence):
        s = arr[start]
        e = arr[end]
        val = e - s + sequence[start]
        # print(start, end, val)
        if val == k:
            if answer is None:
                answer = [start, end]
            else:
                if (answer[-1] - answer[0]) > (end - start):
                    answer = [start, end]

        if start == end:
            end += 1
        elif val > k:
            start += 1
        else:
            end += 1

    return answer