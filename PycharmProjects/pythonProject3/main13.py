# 1에서 10사이의 숫자중 3배의 배수를 제외하고 출력하시오.

for i in range(1, 11):
    if i % 3 == 0:              # 3의 배수이면
        continue                # 다음 반복 시작함
    print(i, end=" ")
