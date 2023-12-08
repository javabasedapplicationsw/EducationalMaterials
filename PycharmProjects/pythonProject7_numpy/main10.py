# 배열 간 연산
import numpy as np
import matplotlib.pyplot as plt

A = np.array([1, 2, 3, 4])
B = np.array([5, 6, 7, 8])
result = A + B
print(result)       # 넘파일 배열에 + 연산이 적용됨

a = np.array([0, 9, 21, 3])
print(a < 10)

# 2차원 배열
b = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print(b)
print(b[0][2])

# 넘파이의 데이터 생성함수 :  arange(start, stop, step)   시작값, 종료값, 간격
A = np.arange(1, 10, 2)
print(A)
#plt.plot(A)
#plt.show()

print("-" * 30)
# 넘파이의 데이터 생성함수 : linspace(start, stop, num)   시작값, 종료값, 개수
A = np.linspace(0, 10, 100)
print(A)
plt.plot(A)
plt.show()