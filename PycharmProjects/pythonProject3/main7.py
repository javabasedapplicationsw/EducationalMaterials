# 원하는 단의 구구단을 출력하시오.

dan = int(input("원하는 단 입력 : "))

i = 1
while i <= 9:
    print("%s * %s = %s" % (dan, i, dan*i))
    i = i + 1


