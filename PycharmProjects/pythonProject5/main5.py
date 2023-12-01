'''
    * 데이터 구조 중 하나인 스택을 리스트로 구현하기
        - 데이터를 추가한 순서와 삭제하는 순서가 반대인 자료구조임
        - 예) 과일을 입력하세요: apple
              과일을 입력하세요: orange
              과일을 입력하세요: grape
               grape
               orange
               apple
'''

stack = []

for i in range(3):
    fruit = input("과일을 입력하세요: ")
    stack.append(fruit)

for i in range(3):
    print(stack.pop())












