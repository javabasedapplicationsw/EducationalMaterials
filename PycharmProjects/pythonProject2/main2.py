# 사용자로부터 물건의 가격을 입력받기
price = int(input("물건의 가격 : "))

# 택배비 결정하기
if price > 40000:
    shipping_cost = 0               # 블록 : 여러 문장들을 묶은 것임
    discount = 0.1
else:
    shipping_cost = 3000

# 택배비 출력하기
print("택배비 = ", shipping_cost)