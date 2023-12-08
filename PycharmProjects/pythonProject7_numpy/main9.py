import numpy as np
import matplotlib.pyplot as plt

ftemp = [63, 73, 80, 86, 84, 78, 66, 54, 45, 63]

# 넘파이의 1 차원 배열로 변환 array()
F = np.array(ftemp)
print(F)
print(type(F))
plt.plot(F)
plt.show()

print("-" * 20)

arr = np.array([1, 2, 3])
print(arr)
print(type(arr))

print("-" * 20)

# 2차원 배열
arr2 =np.array([[1, 2, 3],
               [4, 5, 6],
               [7, 8, 9]
              ])
print(arr2)
print(type(arr2))

print("-" * 20)











