import random

print("매직볼로 값을 출력해 보세요")
answer = random.randint(1, 8)
if answer == 1:
    print("Outlook good")
elif answer == 2:
    print("Most likely")
elif answer == 3:
    print("It is certain")
elif answer == 4:
    print("It is decidedly so")
else:
    print("다시 매직볼로 값을 출력해 보세요")