'''
숫자 맞추기 게임
    - 프로그램이 가지고 있는 정수를
      사용자가 알아맞히는 게임.
'''

import random

tries = 0                   # 시도 횟수
input_guess = 0             # 사용자가 추축한 값(입력한 값)
good_answer = random.randint(1, 100)

print("1부터 100 사이의 숫자를 맞추세요")

while good_answer != input_guess:
    input_guess = int(input("숫자를 입력하세요: "))
    tries = tries + 1
    if input_guess < good_answer:
        print("너무 낮음!")
    elif input_guess > good_answer:
        print("너무 높음!")

if input_guess == good_answer:
    print("정답입니다. 굿잡~. 시도 횟수는 =", tries)




















