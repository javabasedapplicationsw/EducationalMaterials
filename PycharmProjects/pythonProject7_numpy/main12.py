# 균일 분포 난수 생성
import numpy as np
import matplotlib.pyplot as plt

np.random.seed(200)

# 5개의 정규 분포 난수 -- 난수는 0.0에서 1.0 사이 값으로 생성됨
array = np.random.randn(5)
print(array)


print("-" * 30)
array = np.random.randn(5, 4)
print(array)
