# 함수 내에서는 아직 정의되지 않은 함수를 호출 할수는 있음

def main():
    result1 = get_area(3)
    print("반지름이 3인 원의 면적은 = ", result1, "입니다.")

def get_area(radius):
    area = 3.14 * radius **2
    return area

main()