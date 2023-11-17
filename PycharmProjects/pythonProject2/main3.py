# 부울 변수
radius = 100
flag = (radius > 50)
print(flag)

# 사용자로부터 물건의 가격을 입력받기
price = int(input("물건의 가격 : "))

expensive = price > 20000
if expensive:                   # 관계 수식 대신에 부울 변수가 들어가도 됨
    shipping_cost = 0
else:
    shipping_cost = 3000

# 택배비 출력하기
print("택배비 = ", shipping_cost)
