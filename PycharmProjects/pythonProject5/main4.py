'''
    성적을 입력받아서 리스트에 저장함
    정수들이 저장된 리스트에서 두번째로 큰수를 출력하시오.

    출력 예시) 두번째로 큰 수 = 50

    tip1) 리스트를 정렬 -> 뒤에서 두번째 요소를 출력
    tip2) 제일 큰수 삭제 -> 그 다음으로 큰수를 출력
'''

STUDENTS = 6
list_ = []
count = 0

for i in range(STUDENTS):
    value = int(input("성적을 입력하시오 : "))
    list_.append(value)

# 리스트 정렬
# list_.sort()

# 뒤에서 두 번째 요소 출력
# print("두번째로 큰 수 =", list_[-2])


# 제일 큰수 삭제
list_.remove(max(list_))

# 그 다음으로 큰수 출력
print("두번째로 큰 수 =", max(list_))


