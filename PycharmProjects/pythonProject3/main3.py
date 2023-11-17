for i in [1, 2, 3, 4, 5]:
    print("와 첫눈이 내렸습니다.")

for i in [9, 8, 7, 6, 5]:
    print("i = ", i)

for i in range(5):              # 0, 1, 2, 3, 4가 생성됨
    print("와 첫눈이 내렸습니다.")

for i in range(1, 6, 1):
    print(i, end=" ")

print("-" * 20)

for i in range(1, 16, 2):
    print(i, end=" ")

print("-" * 20)
# 10 9 8 7 6 5 4 3 2 1
for i in range(10, 0, -1):
    print(i, end=" ")

print("-" * 20)
# 1부터 10까지의 합을 range() 활용해서 구하시오
sum = 0
n = 10
for i in range(1, n+1):
    sum += i
print("1부터 10까지의 합 = ", sum)

# for문을 이용해서 팩토리얼을 계산하기

