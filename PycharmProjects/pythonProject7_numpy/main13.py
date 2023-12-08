import numpy as np

A = np.array([0, 1, 2, 3])
narr = 10 * np.sin(A)
print(narr)


scores = np.array([[99, 93, 60], [98, 82, 93],
                   [93, 65, 81], [78, 82, 81]])
print(scores.sum())
print(scores.min())
print(scores.max())
print(scores.mean())
print(scores.std())