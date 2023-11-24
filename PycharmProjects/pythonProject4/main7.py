# 가변인수

def varfunc(*args):
    print(args)

print("하나의 값으로 호출")
varfunc(10)

print("여러 개의 값으로 호출")
varfunc(10, 20, 30)

print("-" * 20)

def add(*numbers):
    sum = 0
    for n in numbers:
        sum += n
    return  sum

print(add(10, 20))
print(add(10, 20, 30))

print("-" * 20)

def myfunc(**kwargs):
    result = ""
    for arg in kwargs.values():
        result += arg
    return result

print(myfunc(x="안녕하세요! ",y="추운 ", z="겨울 잘 보내세요!"))
