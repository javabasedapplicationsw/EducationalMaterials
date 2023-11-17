'''
  - 화씨 온도를 받아서 섭씨 온도로 변환하시오.
    (32°F − 32) × 5/9 = 0°C
'''

ftemp = 100     # 화씨 온도 100를 변수에 저장함
ctemp = (ftemp-32.0) * 5.0/9.0    # 화씨온도 -> 섭씨온도
print("섭씨 온도 : ", ctemp)

INCOME = 10000
TAX_RATE = 0.35

tax = INCOME * TAX_RATE
my_income = INCOME - tax


