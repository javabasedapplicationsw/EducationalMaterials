'''
    프로그램으로 해를 계산하는 것임
    프로그램은 매우 빠르게 반복 할수 있음

    f(x) = x^2 - x - 1

'''
COUNT = 100
START = 1.0
END = 2.0

for i in range(COUNT):
    x = START + i*((END-START)/COUNT)
    f = (x**2 - x - 1)
    if abs(f-0.0) < 0.01:
        print(x)

