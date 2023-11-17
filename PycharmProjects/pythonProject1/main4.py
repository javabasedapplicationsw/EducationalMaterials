'''
 - 원기둥 부피 계산하기
    - (밑넓이) × (높이)
        πr2
'''

# 원주율 상수 정의
PI = 3.14

# 변수 정의
radius = 5
height = 10

# 부피계산
volume = PI * radius * radius * height
print("반지름=", radius, ", 높이=", height, ", 원기둥의 부피=", volume)

