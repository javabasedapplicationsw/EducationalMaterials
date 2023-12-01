'''
    성적을 입력받아서 리스트에 저장함
    성적의 평균, 최대점수, 최소점수, 80점이상 성적을 받은 학생의 숫자 등 출력하시오.
'''

STUDENTS = 5
list_ = []
count = 0

for i in range(STUDENTS):
    value = int(input("성적을 입력하시오 : "))
    list_.append(value)

print("\n 성적 평균 : = ", sum(list_) / len(list_))
print("최대 점수 = ", max(list_))
print("최소 점수 = ", min(list_))

for score in list_:
    if score >= 80:
        count += 1
print("80점 이상 =", count)


