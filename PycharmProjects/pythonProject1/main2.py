# radius = 10
#
# radius = 10.003
#
# radius = "himedia"

print(type(1234))
print(type(12.30))
print(type("hello"))

x = 3
print(x)
print(id(x))

y = x   # 변수 y에 변수 x의 참조값이 복사됨
print(id(y))
print(y)

print("-" * 20)

y = 10      # 변수 y에 새로운 값이 할당되면 주소가 달라짐
print(id(y))
print(y)
