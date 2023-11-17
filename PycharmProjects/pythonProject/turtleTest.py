import turtle               # 터틀 모듈 포함

t = turtle.Turtle()         # 터틀 생성
t.shape("turtle")           # 터틀 모양을 거북이로 설정

t.forward(100)              # 100픽셀만큼 전진
t.left(90)                  # 90 회전
t.forward(50)

turtle.done()               # 터틀 그래픽 종료
