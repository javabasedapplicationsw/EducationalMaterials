'''
    * 리스트 복사하기
        - 얕은 복사
'''

temps = [28, 31, 33, 35, 27, 26, 25]
values = temps

print(temps)
print(id(temps))
print(values)
print(id(values))

values[3] = 39
print(temps)

'''
    * 리스트 복사하기
        - 깊은 복사
'''
print("----------------------------------")
temps = [28, 31, 33, 35, 27, 26, 25]
values = list(temps)

print(temps)
print(id(temps))
print(values)
print(id(values))