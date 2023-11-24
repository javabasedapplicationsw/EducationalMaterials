'''
    "환영합니다." 문자열을 여러 번 출력하는 함수 display(msg, count)를 작성하시오.
    두번째 인수의 디폴트 인수값으로 1을 설정하시오.

    예시) display("환영합니다", 5)
         display("환영합니다")
'''
def display(msg, count=1):
    for k in range(count):
        print(msg)

display("환영합니다",5)
print("-" * 25)
display("환영합니다")