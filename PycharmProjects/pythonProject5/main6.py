'''
    * 친구 관리 프로그램 구현하기
        - 1. 친구 리스트 출력
          2. 친구추가
          3. 친구삭제
          4. 친구이름변경
          5. 종료

          메뉴를 선택하시오 : 2
          이름을 입력하시오 : 이순신
          --------------------------
        - 1. 친구 리스트 출력
          2. 친구추가
          3. 친구삭제
          4. 친구이름변경
          5. 종료

          메뉴를 선택하시오 : 1
          ['이순신']
'''
menu = 0
friends = []
while menu != 5:
    print("----------------------")
    print("1. 친구 리스트 출력")
    print("2. 친구추가")
    print("3. 친구삭제")
    print("4. 친구이름변경")
    print("5. 종료")

    menu = int(input("메뉴를 선택하시오 : "))
    if menu == 1:
        print(friends)
    elif menu == 2:
        name = input("이름을 입력하시오 : ")
        friends.append(name)
    elif menu == 3:
        del_name = input("삭제하고 싶은 이름을 입력하시오 :")
        if del_name in friends:
            friends.remove(del_name)
        else:
            print("이름이 없음")
    elif menu == 4:
        old_name = input("변경하고 싶은 이름을 입력하시오 : ")
        if old_name in friends:
            index = friends.index(old_name)
            new_name = input("새로운 이름을 입력하시오 : ")
            friends[index] = new_name
        else:
            print("변경하고자 하는 이름이 없음")













