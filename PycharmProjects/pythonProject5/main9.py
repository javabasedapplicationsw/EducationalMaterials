# 슬라이싱
numbers = [ 10, 20, 30, 40, 50, 60, 70, 80, 90 ]
sublist = numbers[2:7]
print(sublist)

print(numbers[:3])
print(numbers[3:])
print(numbers[:])

num_numbers = numbers[:]
print(num_numbers)
print(id(numbers))
print(id(num_numbers))

print("-" * 20)

sublist2 = numbers[2:7:2]
print(sublist2)

print(numbers[::-1])

# 리스트 변경하기
print("-" * 20)
lst = [1, 2, 3, 4, 5, 6, 7, 8]
lst[0:3] = ['white', 'blue', 'red']                 # 리스트 일부 변경
print(lst)

print("-" * 20)
lst = [1, 2, 3, 4, 5, 6, 7, 8]
lst[::2] = [99, 100, 99, 101]                       # 중간 중간 일부 변경
print(lst)

print("-" * 20)
lst = [1, 2, 3, 4, 5, 6, 7, 8]
lst[:] = []                                         # 리스트의 모든 요소 삭제함
print(list)

print("-" * 20)
numbers = list(range(0,10))                         # 0에서 9까지를 저장하는 리스트
print(numbers)
del numbers[-1]                                     # 마지막 항목 삭제
print(numbers)

print("-" * 20)
str = "Wecome Hi Media!"                # 문자열은 문자들이 모인 리스트임
print(str[0])
print(str[7:9])
print(str[-16:-10])

print("-" * 20)
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# [10, 8, 6, 4, 2]
print(numbers[::-2])