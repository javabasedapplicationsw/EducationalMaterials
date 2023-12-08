# 균일 분포 난수 생성
import numpy as np
import matplotlib.pyplot as plt

np.random.seed(100)

# 5개의 난수 -- 난수는 0.0에서 1.0 사이 값으로 생성됨
array = np.random.rand(5)
print(array)

print("-" * 30)
array = np.random.rand(5, 3)
print(array)
plt.plot(array)
plt.show()