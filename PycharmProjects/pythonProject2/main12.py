'''
난수를 이용하여 게임을 작성하시오.

어디를 수비하시겠습니까? (왼쪽 : 1, 중앙 : 2, 오른쪽 : 3)

=> 수비에 성공하셨습니다.

=> 패널티킥이 성공하셨습니다.
'''
import random

computer_choice = random.randint(1,3)
user_choice = int(input("어디를 수비하시겠습니까? (왼쪽 : 1, 중앙 : 2, 오른쪽 : 3) : "))

if computer_choice == user_choice:
    print("수비에 성공하셨습니다.")
else:
    print("패널티킥이 성공하셨습니다.")



























