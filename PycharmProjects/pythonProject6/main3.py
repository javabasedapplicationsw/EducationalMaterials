numbers = {1, 2, 3}
print(numbers)
print(type(numbers))

print("-" * 20)
values = set()          # 공백 세트 생성
print(values)
print(type(values))

print("-" * 20)
numbers = set([1, 2, 3, 4, 5])
print(numbers)

numbers = set([1, 2, 3, 1, 2, 3])
print(numbers)

print("-" * 20)
letters = set("abcde")          #  문자열을 분해하여 세트로 생성함
print(letters)

print("-" * 20)
fruits = {"apple", "banana", "grace"}
size = len(fruits)
print(size)

if "apple" in fruits:
    print("집합 안에 apple이 있습니다.")

print("-" * 20)

aList = [1,2,3,4,5,1,2]
result = { x for x in aList if x%2==0 }
print(result)



