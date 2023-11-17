'''
    사용자로부터 사각형의 크기를 입력받아서 크기에 맞는 사각형을 그리시오.
'''

import turtle

t = turtle.Turtle()
t.shape("turtle")

size = int(input("사각형의 크기는 얼마로 할까요? : "))

t.forward(size)             # size만큼 거북이를 전진시킴
t.right(90)                 # 거북이를 오른쪽으로 90도 회전시킴
t.forward(size)
t.right(90)
t.forward(size)
t.right(90)
t.forward(size)

turtle.mainloop()
turtle.bye()
