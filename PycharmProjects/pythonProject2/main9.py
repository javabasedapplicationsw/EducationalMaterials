'''
    배송비지가 한국이면 다음 기준으로 배송비를 계산하시오.
    상품 가격이 2만원 이상이면 배송비는 없고 그렇지 않으면 3000원 배송비가 붙는다.

    배송비지가 캐나다이면 다음 기준으로 배송비를 계산하시오.
    상품 가격이 10만원 이상이면 배송비는 없고 그렇지 않으면 8000원 배송비가 붙는다.
'''

country = input("배송지(korea와 canada 중 입력) : ")
price = int(input("상품의 가격 : "))

#배송비를 결정하기
if country == "korea":
    if price >= 20000:
        shipping_cost = 0
    else:
        shipping_cost = 3000
else:
    if price >= 100000:
        shipping_cost = 0
    else:
        shipping_cost = 8000

#배송비 출력하기
print("배송비 = ", shipping_cost)











