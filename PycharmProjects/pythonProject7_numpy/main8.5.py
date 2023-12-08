import numpy as np
import time

py_list = [i for i in range(10000000)]
start = time.time()                     # 시작 시간
py_list = [i+2 for i in py_list]
stop = time.time()                      # 종료 시간
print("파이썬 리스트 = ", stop-start)

np_arr = np.array([i for i in range(10000000)])
start = time.time()                     # 시작 시간
np_arr += 2
stop = time.time()                      # 종료 시간
print("넘파이 배열 = ", stop-start)