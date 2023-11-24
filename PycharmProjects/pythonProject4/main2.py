# 원의 면적 구하는  함수를 작성하고 호출하시오

def get_area(radius):
    area = 3.14*radius**2
    return area

result = get_area(3)
result2 = get_area(20)
print("반지름이 3인 원의 면적 = ", result)
print("반지름이 20인 원의 면적 = ", result2)

# 여러 개의 값 반환하기
def get_output():
    return 2, 3

x, y = get_output()
print("x =", x)
print("y =", y)



def func_multi(x):
    y1 = x * 2
    y2 = x * 4
    y3 = x * 6
    return y1, y2, y3

val1, val2, val3 = func_multi(3)
print(val1, val2, val3)


# 리스트 리턴
def func_multi2(x):
    y1 = x * 2
    y2 = x * 4
    y3 = x * 6
    return [y1, y2, y3]

list = func_multi2(6)
print(list, type(list))















def himedia():
    pass











