'''
    'l'을 입력하면 거북이가 왼쪽으로 100 픽셀이동하고
    'r'을 입력하면 거북이가 오른쪽 100픽셀 이동하는 프로그램을 작성하시오.
    'q'을 입력하면 종료함
'''
import turtle

t = turtle.Turtle()
t.shape("turtle")
t.width(3)
t.shapesize(3,3)        # 거북이 3배 확대

while True:
    command = input("명령을 입력하시오(l, r, q) : ")
    if command == 'l':
        t.left(90)
        t.forward(100)
    if command == 'r':
        t.right(90)
        t.forward(100)
    if command == 'q':
        break                           # 무한 루프를 빠져나감

turtle.mainloop()
turtle.bye()

















